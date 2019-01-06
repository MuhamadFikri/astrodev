package id.astrodev.muhamadfikri.footballclub.data.remote;


import java.util.List;

import id.astrodev.muhamadfikri.footballclub.model.ResponsFootball;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("api/v1/json/1/search_all_teams.php")
    Call<ResponsFootball> getData(
        @Query("s")String s,
        @Query("c")String c
    );


}



