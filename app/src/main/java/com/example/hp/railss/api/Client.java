package com.example.hp.railss.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Client {
    @GET("/v2/pnr-status/pnr/<pnr no>/apikey/<apikey>")
    Call<List<Model>> reposForUser(@Path("pnr no") String pnr );
}

