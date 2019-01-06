package id.astrodev.muhamadfikri.footballclub.main;

import android.content.Context;

import java.util.List;

import id.astrodev.muhamadfikri.footballclub.model.DetailFootballTeam;

public interface FootballContract {
    interface View {
        void showProgress();
        void hideProgress();
        void showDataList(List<DetailFootballTeam> data);
        void showFailureMessage(String msg);
    }

    interface Presenter {
        void getDataListFootball(Context context);
    }
}
