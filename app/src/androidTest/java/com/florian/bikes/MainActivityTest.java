package com.florian.bikes;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.InstrumentationTestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest extends InstrumentationTestCase {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class, true, false);
    private MockWebServer server;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        server = new MockWebServer();
        server.start();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        BikeServiceConstants.BASE_URL = server.url("/").toString();
    }

    @Test
    public void testStationIsShown() throws Exception {
        String fileName = "citybike-wien.json";
        String response = readResponseFile(fileName);

        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(response));

        Intent intent = new Intent();
        mActivityRule.launchActivity(intent);
        onView(withText("Hoher Markt")).check(matches(isDisplayed()));

        onView(withId(R.id.stationlist_recycler_view))
                .perform(RecyclerViewActions.scrollToPosition(119));

        onView(withText("Millennium Tower")).check(matches(isDisplayed()));
    }

    @Test
    public void testErrorIsShownOnInvalidResponse() throws Exception {

        String response = "oh no";

        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(response));

        Intent intent = new Intent();
        mActivityRule.launchActivity(intent);
        onView(withText(R.string.dialog_message)).check(matches(isDisplayed()));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.stationlist_recycler_view)).check(matches(isDisplayed()));

    }

    @Test
    public void testErrorIsShownOn404() throws Exception {

        String response = "oh no";

        server.enqueue(new MockResponse()
                .setResponseCode(404)
                .setBody(response));

        Intent intent = new Intent();
        mActivityRule.launchActivity(intent);
        onView(withText(R.string.dialog_message)).check(matches(isDisplayed()));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.stationlist_recycler_view)).check(matches(isDisplayed()));

    }

    @After
    public void tearDown() throws Exception {
        server.shutdown();
    }

    private String readResponseFile(String fileName) throws IOException {
        InputStream inputStream = getClass().getResourceAsStream(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        reader.close();
        inputStream.close();

        return sb.toString();
    }
}
