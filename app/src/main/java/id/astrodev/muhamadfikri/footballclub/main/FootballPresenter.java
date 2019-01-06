package id.astrodev.muhamadfikri.footballclub.main;

import android.content.Context;

import java.util.List;

import id.astrodev.muhamadfikri.footballclub.data.FootballDataSource;
import id.astrodev.muhamadfikri.footballclub.data.FootballRepository;
import id.astrodev.muhamadfikri.footballclub.model.DetailFootballTeam;

public class FootballPresenter implements FootballContract.Presenter {

    private FootballRepository repository;
    private FootballContract.View view;

    public FootballPresenter(FootballRepository repository, FootballContract.View view) {
        this.repository = repository;
        this.view = view;
    }

    @Override
    public void getDataListFootball(Context context) {
        view.showProgress();
        repository.getListFootball(context, new FootballDataSource.GetListFootballCallback() {
            @Override
            public void onSuccess(List<DetailFootballTeam> data) {
                view.hideProgress();
                view.showDataList(data);

            }

            @Override
            public void onFailed(String errorMessage) {
                view.hideProgress();
                view.showFailureMessage(errorMessage);
            }
        });
    }

}
