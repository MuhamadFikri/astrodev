package id.astrodev.muhamadfikri.footballclub.view;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.astrodev.muhamadfikri.footballclub.Injection;
import id.astrodev.muhamadfikri.footballclub.R;
import id.astrodev.muhamadfikri.footballclub.adapter.FootballAdapter;
import id.astrodev.muhamadfikri.footballclub.main.FootballContract;
import id.astrodev.muhamadfikri.footballclub.main.FootballPresenter;
import id.astrodev.muhamadfikri.footballclub.model.DetailFootballTeam;

public class FootballActivity extends AppCompatActivity implements FootballContract.View {

    @BindView(R.id.recyclerView)
    public RecyclerView recyclerView;

    private ProgressDialog progressDialog;
    private FootballAdapter adapter;
    private List<DetailFootballTeam> data = new ArrayList<>();

    private FootballPresenter presenter = new FootballPresenter(Injection.provideRepository(), this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_football);
        ButterKnife.bind(this);
        initAdapter();
        presenter.getDataListFootball(this);
    }
    @Override
    public void showProgress() {
        progressDialog = new ProgressDialog(FootballActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.setTitle("Harap tunggu");
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void showDataList(List<DetailFootballTeam> data) {
        this.data.addAll(data);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showFailureMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void initAdapter() {
        adapter = new FootballAdapter(this, data);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

}
