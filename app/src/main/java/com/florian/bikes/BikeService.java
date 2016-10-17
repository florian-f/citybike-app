package com.florian.bikes;

import com.florian.bikes.json.BikeResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BikeService {
    @GET("/v2/networks/citybike-wien")
    Call<BikeResponse> getBikes();
}
