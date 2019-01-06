package id.astrodev.muhamadfikri.footballclub.data.remote;

import android.content.Context;
import android.widget.Toast;

import java.util.List;

import id.astrodev.muhamadfikri.footballclub.adapter.Contract;
import id.astrodev.muhamadfikri.footballclub.data.FootballDataSource;
import id.astrodev.muhamadfikri.footballclub.model.DetailFootballTeam;
import id.astrodev.muhamadfikri.footballclub.model.ResponsFootball;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FootballRemoteDataSource implements FootballDataSource {

    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    @Override
    public void getListFootball(Context context, final GetListFootballCallback callback) {
        Call<ResponsFootball> call = apiInterface.getData(Contract.s, Contract.c);
        call.enqueue(new Callback<ResponsFootball>() {
            @Override
            public void onResponse(Call<ResponsFootball> call, Response<ResponsFootball> response) {
                if (response.body() != null) {
                    callback.onSuccess(response.body().getDetailFootballTeams());
                } else
                    Toast.makeText(context, "Data Null", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponsFootball> call, Throwable t) {
                callback.onFailed(t.toString());
            }
        });


    }





}
