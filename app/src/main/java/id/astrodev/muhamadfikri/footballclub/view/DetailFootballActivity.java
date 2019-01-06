package id.astrodev.muhamadfikri.footballclub.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.astrodev.muhamadfikri.footballclub.R;
import id.astrodev.muhamadfikri.footballclub.model.DetailFootballTeam;

public class DetailFootballActivity extends AppCompatActivity {
   @BindView(R.id.strFoto_stadium)ImageView Gstadium;
   @BindView(R.id.strStadium)TextView Nstadium;
   @BindView(R.id.strStadiumDeskripsi)TextView Dstadium;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_football);
        ButterKnife.bind(this);
        setTeam();
    }

    private void setTeam() {
        Bundle bundle = getIntent().getExtras();
        DetailFootballTeam detailFootballTeam = (DetailFootballTeam) bundle.getSerializable("data");
        //Toast.makeText(this, detailFootballTeam.getStrStadiumThumb_(), Toast.LENGTH_SHORT).show();
        Picasso.get().load(detailFootballTeam.getStrStadiumThumb_()).into(Gstadium);
        Nstadium.setText(detailFootballTeam.getStrStadium_());
        Dstadium.setText(detailFootballTeam.getStrStadiumDescription_());
    }
}
