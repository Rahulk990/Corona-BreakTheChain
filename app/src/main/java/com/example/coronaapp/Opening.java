package com.example.coronaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Opening extends AppCompatActivity {
    private TextView tv;
    private ImageView iv, iv1, iv2;
    private LinearLayout buttons, icons;
    Animation open, enter_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_opening);

        open = AnimationUtils.loadAnimation(this, R.anim.opening);
        enter_in = AnimationUtils.loadAnimation(this, R.anim.frombutton);
        buttons = (LinearLayout)findViewById(R.id.buttons);
        icons = (LinearLayout)findViewById(R.id.icons);

        tv = (TextView)findViewById(R.id.tv);
        iv = (ImageView)findViewById(R.id.iv);
        iv1 = (ImageView)findViewById(R.id.iv1);
        iv2 = (ImageView)findViewById(R.id.iv2);
        tv.animate().translationY(-450).setDuration(800).setStartDelay(1000);
        iv.animate().translationY(-450).setDuration(800).setStartDelay(1000);
        iv1.animate().alpha((float)0.5).setDuration(600).setStartDelay(2000);
        iv2.animate().alpha((float)0.5).setDuration(600).setStartDelay(2000);

        icons.startAnimation(open);
        buttons.startAnimation(enter_in);
    }

    public void enter(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
