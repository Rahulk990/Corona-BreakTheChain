package com.example.coronaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void leader(View view) {
        Global.initialize_parameters();
        for(int i = 0;i<40;i++)
            Global.dec_active[i] = 0;

        Intent i = new Intent(this, before_game.class);
        startActivity(i);
    }

    public void people(View view) {
        Intent i = new Intent(this, peopleActivity.class);
        startActivity(i);
    }

    public void settings(View view) {
        Intent i = new Intent(this, settings.class);
        startActivity(i);
    }

}
