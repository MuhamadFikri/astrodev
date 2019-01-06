package id.astrodev.muhamadfikri.footballclub.data.local;


import android.content.Context;

import id.astrodev.muhamadfikri.footballclub.data.FootballDataSource;

public class FootballLocalDataSource implements FootballDataSource {

    @Override
    public void getListFootball(Context context, GetListFootballCallback callBack) {
        FootballDatabase footballDatabase = FootballDatabase.getFootballDatabase(context);
        if (footballDatabase.detailFootballTeamDao().select() != null) {
            callBack.onSuccess(footballDatabase.detailFootballTeamDao().select());
        } else {
            callBack.onFailed("no database on local");
        }
    }
}
