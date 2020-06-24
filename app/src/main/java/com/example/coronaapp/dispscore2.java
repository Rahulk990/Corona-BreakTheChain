package com.example.coronaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class dispscore2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispscore2);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(0xFFA6D4F8);
        }

        TextView text=(TextView) findViewById(R.id.disp2);
        if(Global.lost == 1)
            text.setText("You Actually Lost Your Nation!!");
        else
            text.setText("Your Score is: " + Global.score);
    }

    public void home(View view)
    {
        Intent i=new Intent(getBaseContext(), MainActivity.class);
        startActivity(i);
    }
}
