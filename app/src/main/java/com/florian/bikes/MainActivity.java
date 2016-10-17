package com.florian.bikes;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.florian.bikes.json.BikeResponse;
import com.florian.bikes.json.Station;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String STATE_KEY = "rv_state";

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Parcelable mState;

    private Retrofit retrofit;
    private BikeService bikeService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdapter = new StationAdapter(new ArrayList<Station>());

        mRecyclerView = (RecyclerView) findViewById(R.id.stationlist_recycler_view);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setAdapter(mAdapter);

        retrofit = new Retrofit.Builder()
                .baseUrl(BikeServiceConstants.BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        bikeService = retrofit.create(BikeService.class);

        getStations();

    }

    @Override
    protected void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
        mState = mLayoutManager.onSaveInstanceState();
        state.putParcelable(STATE_KEY, mState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle state) {
        super.onRestoreInstanceState(state);
        if (state != null) {
            mState = state.getParcelable(STATE_KEY);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mState != null) {
            mLayoutManager.onRestoreInstanceState(mState);
        }
    }

    private void getStations() {
        Call<BikeResponse> call = bikeService.getBikes();

        call.enqueue(new Callback<BikeResponse>() {
            @Override
            public void onResponse(Call<BikeResponse> call, Response<BikeResponse> response) {

                List<Station> stations;
                try {
                    stations = response.body().getNetwork().getStations();
                } catch (Exception e) {
                    onFailure(call, e);
                    return;
                }

                if (stations != null && !stations.isEmpty()) {
                    mRecyclerView.swapAdapter(new StationAdapter(stations), true);
                } else {
                    showErrorAlert();
                }
            }

            @Override
            public void onFailure(Call<BikeResponse> call, Throwable t) {
                showErrorAlert();
            }
        });
    }

    private void showErrorAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage(R.string.dialog_message)
                .setTitle(R.string.dialog_title)
                .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
