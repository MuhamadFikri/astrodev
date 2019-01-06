package id.astrodev.muhamadfikri.footballclub.view;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import id.astrodev.muhamadfikri.footballclub.R;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
       init();
    }
    public void init(){
        new Handler().postDelayed(new Runnable() {
            public void run(){
                Intent i = new Intent(Splash.this,FootballActivity.class);
                startActivity(i);
                finish();
            }
        }, 1000);
    }

}
