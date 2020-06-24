package com.example.coronaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class peopleActivity extends AppCompatActivity {
    LinearLayout layout, layout1;
    Animation in, out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(0xFFC3C3C5);
        }

        Button button = (Button)findViewById(R.id.LEVEL1);
        Button button1 = (Button)findViewById(R.id.LEVEL2);
        layout = (LinearLayout) findViewById(R.id.layout4);
        layout1 = (LinearLayout) findViewById(R.id.layout5);
        in = AnimationUtils.loadAnimation(this, R.anim.in_anim);
        out = AnimationUtils.loadAnimation(this, R.anim.out_anim);

        GradientDrawable gd = new GradientDrawable();
        gd.setStroke(1,0xFF5139F9);
        gd.setCornerRadius(350);
        GradientDrawable gd2 = new GradientDrawable();
        gd2.setStroke(1,0xFF5139F9);
        gd2.setCornerRadius(75);

        button.setBackgroundDrawable(gd);
        button1.setBackgroundDrawable(gd);
        layout.setBackgroundDrawable(gd2);
        layout1.setBackgroundDrawable(gd2);
        layout.setVisibility(View.GONE);
        layout1.setVisibility(View.GONE);
    }

    public void toggle_contents_1(View view)
    {
        if(layout.isShown())
            layout.setVisibility(View.GONE);
        else
            layout.setVisibility(View.VISIBLE);
    }

    public void toggle_contents_2(View view)
    {
        if(layout1.isShown())
            layout1.setVisibility(View.GONE);
        else
            layout1.setVisibility(View.VISIBLE);
    }

    public void LEVEL1(View view) {
        Global.q_index = 0;
        Intent nxt = new Intent(this, question.class);
        startActivity(nxt);
    }

    public void LEVEL2(View view) {
        Global.score = 4;
        Intent nxt = new Intent(this, symptoms.class);
        startActivity(nxt);
    }
}
