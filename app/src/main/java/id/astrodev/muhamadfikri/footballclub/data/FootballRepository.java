package id.astrodev.muhamadfikri.footballclub.data;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import java.util.List;

import id.astrodev.muhamadfikri.footballclub.data.local.FootballDatabase;
import id.astrodev.muhamadfikri.footballclub.model.DetailFootballTeam;
import id.astrodev.muhamadfikri.footballclub.data.remote.FootballRemoteDataSource;

public class FootballRepository implements FootballDataSource {
    private FootballRemoteDataSource remoteDataSource;
    private final FootballDataSource localDataSource;
    private FootballDatabase footballDatabase;

    public FootballRepository(FootballRemoteDataSource remoteDataSource, FootballDataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    @Override
    public void getListFootball(Context context, final GetListFootballCallback callback) {
        NetworkInfo info = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        footballDatabase = FootballDatabase.getFootballDatabase(context);
        if (footballDatabase.detailFootballTeamDao().select().size() != 0) {
            Toast.makeText(context, "Using database local", Toast.LENGTH_SHORT).show();
            localDataSource.getListFootball(context, new GetListFootballCallback() {
                @Override
                public void onSuccess(List<DetailFootballTeam> data) {
                    callback.onSuccess(data);
                }

                @Override
                public void onFailed(String errorMessage) {
                    callback.onFailed(errorMessage);
                }
            });
        } else if (info != null && info.isConnected()) {
            Toast.makeText(context, "Using database cloud", Toast.LENGTH_SHORT).show();
            remoteDataSource.getListFootball(context, new GetListFootballCallback() {
                @Override
                public void onSuccess(List<DetailFootballTeam> data) {
                    if (data == null || data.size() == 0){
                        Toast.makeText(context, "Data Null", Toast.LENGTH_SHORT).show();
                    } else {
                        callback.onSuccess(data);
                        footballDatabase.detailFootballTeamDao().insert(data);
                    }
                }

                @Override
                public void onFailed(String errorMessage) {
                    callback.onFailed(errorMessage);
                }
            });
        } else {
            callback.onSuccess(null);
            callback.onFailed("");
        }
    }

}
