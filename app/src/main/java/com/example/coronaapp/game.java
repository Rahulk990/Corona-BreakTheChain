package com.example.coronaapp;
import java.util.LinkedList;
import java.util.Queue;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class game extends AppCompatActivity {
    TextView[] display;
    Button[] buttons;
    AlertDialog.Builder builder;
    AlertDialog dialog;
    int flag = 0;
    long last = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(0xFFA6D4F8);
        }

        display = new TextView[6];
        display[0] = (TextView)findViewById(R.id.textView5);
        display[1] = (TextView)findViewById(R.id.textView6);
        display[2] = (TextView)findViewById(R.id.textView7);
        display[3] = (TextView)findViewById(R.id.textView8);
        display[4] = (TextView)findViewById(R.id.textView9);
        display[5] = (TextView)findViewById(R.id.textView10);

        buttons = new Button[4];
        buttons[0] = (Button)findViewById(R.id.button5);
        buttons[1] = (Button)findViewById(R.id.button6);
        buttons[2] = (Button)findViewById(R.id.button7);
        buttons[3] = (Button)findViewById(R.id.button8);
        for(int i=0;i<4;i++)
            buttons[i].setText("Set " + (i+1));

        builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("Continue", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id) {
                if(Global.parameters[0] != 0 && Global.parameters[0] < 7e6 && flag == 0){
                    flag = 1;
                    refresh(500);
                }
            }
        });

        TextView title = new TextView(this);
        title.setText("Warning!!");
        title.setPadding(10, 20, 10, 10);
        title.setGravity(Gravity.CENTER);
        title.setTextColor(0xFFFF093C);
        title.setTextSize(20);
        builder.setCustomTitle(title);

        dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        last = (long)Global.parameters[3];
    }

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    public void update(){
        for(int i=0;i<4;i++)
        {
            long t = (long)(Global.parameters[i]);
            if(i == 3){
                if (t > 1000000)
                display[i].setText(String.format("%3.2f", (long)Global.parameters[i]/1000000) + "M" + " (+ " + (((long)Global.parameters[i] - last > 0)? ((long)Global.parameters[i] - last):(0)) + ")");
                else if (t > 100000)
                    display[i].setText(String.format("%d", (long)Global.parameters[i]/1000) + "K" + " (+ " + (((long)Global.parameters[i] - last > 0)? ((long)Global.parameters[i] - last):(0)) + ")");
                else if (t > 10000)
                    display[i].setText(String.format("%3.1f", Global.parameters[i]/1000) + "K" + " (+ " + (((long)Global.parameters[i] - last > 0)? ((long)Global.parameters[i] - last):(0)) + ")");
                else if (t > 1000)
                    display[i].setText(String.format("%3.2f", Global.parameters[i]/1000) + "K" + " (+ " + (((long)Global.parameters[i] - last > 0)? ((long)Global.parameters[i] - last):(0)) + ")");
                else
                    display[i].setText(String.format("%d", (long)Global.parameters[i]) + " (+ " + (((long)Global.parameters[i] - last > 0)? ((long)Global.parameters[i] - last):(0)) + ")");
                if(Global.update_counter%2 == 1)
                    last = (long)Global.parameters[i];
            }
            else{
                if (t > 1000000)
                    display[i].setText(String.format("%3.2f", Global.parameters[i]/1000000) + "M");
                else if (t > 100000)
                    display[i].setText(String.format("%d", (long)Global.parameters[i]/1000) + "K");
                else if (t > 10000)
                    display[i].setText(String.format("%3.1f", Global.parameters[i]/1000) + "K");
                else if (t > 1000)
                    display[i].setText(String.format("%3.2f", Global.parameters[i]/1000) + "K");
                else
                    display[i].setText(String.format("%d", (long)Global.parameters[i]));
            }
        }

        display[4].setText("" + (long)(Global.parameters[4]));
        display[5].setText("" + (10 - (long)(Global.parameters[4])%10) + " / " + (long)(Global.parameters[5]));

        if(Global.counter == 0)
        {
            flag = 0;
            dialog.setMessage("Due to many Foreign Tourists and NRIs, the Corona Virus has started to infect your Country. Take decisions to prevent it's mass-spread");
            try {
                dialog.show();
            }
            catch (WindowManager.BadTokenException e) {
                //use a log message
            }
        }

        if(Global.counter == 90 && Global.parameters[0] > 10)
        {
            flag = 0;
            dialog.setMessage("Many NRIs are found hiding at their houses. Thus, the active cases increased by 100");
            try {
                dialog.show();
            }
            catch (WindowManager.BadTokenException e) {
                //use a log message
            }
            Global.multiplier = 3;
            Global.parameters[0] += 100;
            Global.weights[2][0] = 0.46;
        }

        if(Global.counter == 288 && Global.parameters[0] > 50)
        {
            flag = 0;
            dialog.setMessage("Many people are going to their homes across states. Thus, the infection rate increased");
            try {
                dialog.show();
            }
            catch (WindowManager.BadTokenException e) {
                //use a log message
            }
            Global.multiplier = 2;
            Global.weights[2][0] = 0.62;
        }

        if(Global.counter == 492 && Global.parameters[0] > 100)
        {
            flag = 0;
            dialog.setMessage("Many people started to Protest for getting essential commodities. Thus, infection rate increased");
            try {
                dialog.show();
            }
            catch (WindowManager.BadTokenException e) {
                //use a log message
            }
            Global.multiplier = 1.5;
            Global.weights[2][0] = 0.82;
        }

        if(Global.counter == 784  && Global.parameters[0] > 200)
        {
            flag = 0;
            dialog.setMessage("Many people are found captured at some hidden place. Thus, the active cases increased by 1000");
            try {
                dialog.show();
            }
            catch (WindowManager.BadTokenException e) {
                //use a log message
            }
            Global.parameters[0] += 1000;
        }

        if(Global.parameters[0] < 1)
        {
            flag = 0;
            TextView title = new TextView(this);
            title.setText("Congratulations!!");
            title.setPadding(10, 20, 10, 10);
            title.setGravity(Gravity.CENTER);
            title.setTextColor(0xFF3DAF58);
            title.setTextSize(20);
            builder.setCustomTitle(title);

            builder.setPositiveButton("Go to Score", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int id) {
                    Global.lost = 0;
                    Global.score = (long)(100 * (Global.parameters[2]/Global.parameters[1]) * (1000/Global.parameters[4] + 5));
                    Intent nxt = new Intent(getBaseContext(), dispscore2.class);
                    startActivity(nxt);
                    finish();
                }
            });

            dialog = builder.create();
            dialog.setCanceledOnTouchOutside(false);
            dialog.setCancelable(false);

            dialog.setMessage("You Saved your Nation from Corona!!");
            try {
                dialog.show();
            }
            catch (WindowManager.BadTokenException e) {
                //use a log message
            }
        }

        Global.update_parameters();
        if(Global.parameters[3] < 1e6 && flag == 1)
            refresh(500);

        if(Global.parameters[3] > 1e6)
        {
            flag = 0;
            TextView title = new TextView(this);
            title.setText("Congratulations!!");
            title.setPadding(10, 20, 10, 10);
            title.setGravity(Gravity.CENTER);
            title.setTextColor(0xFFFF093C);
            title.setTextSize(20);
            builder.setCustomTitle(title);

            builder.setPositiveButton("Go to Score", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int id) {
                    Global.lost = 1;
                    Intent nxt = new Intent(getBaseContext(), dispscore2.class);
                    startActivity(nxt);
                    finish();
                }
            });
            builder.setNegativeButton("Back to Home", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int id) {
                    Intent nxt = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(nxt);
                    finish();
                }
            });

            dialog = builder.create();
            dialog.setCanceledOnTouchOutside(false);
            dialog.setCancelable(false);

            dialog.setMessage("You are not a Good Leader!! The Spread of Evil Corona destroyed your Nation");
            try {
                dialog.show();
            }
            catch (WindowManager.BadTokenException e) {
                //use a log message
            }
        }
    }

    public void refresh(int ms){
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                update();
            }
        };
        handler.postDelayed(runnable,ms);
    }

    public void cat1(View view) {
        if(Global.parameters[5] < 1)
            Toast.makeText(getBaseContext(), "Not Enough Power", Toast.LENGTH_SHORT).show();
        else{
        Global.cat_offset = 0;
        Intent i = new Intent(this, decision.class);
        startActivity(i);}
    }

    public void cat2(View view) {
        if(Global.parameters[5] < 1)
        Toast.makeText(getBaseContext(), "Not Enough Power", Toast.LENGTH_SHORT).show();
    else{
        Global.cat_offset = 1;
        Intent i = new Intent(this, decision.class);
        startActivity(i);}
    }

    public void cat3(View view) {
        if(Global.parameters[5] < 1)
            Toast.makeText(getBaseContext(), "Not Enough Power", Toast.LENGTH_SHORT).show();
        else{
            Global.cat_offset = 2;
            Intent i = new Intent(this, decision.class);
            startActivity(i);}
    }

    public void cat4(View view) {
        if(Global.parameters[5] < 1)
            Toast.makeText(getBaseContext(), "Not Enough Power", Toast.LENGTH_SHORT).show();
        else{
            Global.cat_offset = 3;
            Intent i = new Intent(this, decision.class);
            startActivity(i);}
    }

    private long back_time = 0;
    @Override
    public void onBackPressed() {
        if(back_time + 2000 > System.currentTimeMillis())
        {
            super.onBackPressed();
            finish();
        }
        else
            Toast.makeText(getBaseContext(), "Press Back Again, to Exit", Toast.LENGTH_SHORT).show();
        back_time = System.currentTimeMillis();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        if(flag==0)
        {
            flag = 1;
           update();
        }
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        flag = 0;
    }
}
