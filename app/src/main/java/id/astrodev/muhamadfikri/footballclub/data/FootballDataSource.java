package id.astrodev.muhamadfikri.footballclub.data;

import android.content.Context;

import java.util.List;

import id.astrodev.muhamadfikri.footballclub.model.DetailFootballTeam;

public interface FootballDataSource {

    void getListFootball(Context context, GetListFootballCallback callBack);

    interface GetListFootballCallback {
        void onSuccess(List<DetailFootballTeam> data);

        void onFailed(String errorMessage);
    }



}
