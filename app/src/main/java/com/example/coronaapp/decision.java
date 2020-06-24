package com.example.coronaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class decision extends AppCompatActivity {
    Button[] buttons;
    TextView[] texts;
    LinearLayout[] layouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decision);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(0xFFC3C3C5);
        }

        GradientDrawable gd = new GradientDrawable();
        gd.setStroke(1,0xFF5139F9);
        gd.setCornerRadius(350);
        GradientDrawable gd2 = new GradientDrawable();
        gd2.setStroke(1,0xFF5139F9);
        gd2.setCornerRadius(75);

        buttons = new Button[10];
        buttons[0] = (Button)findViewById(R.id.des_but0);
        buttons[1] = (Button)findViewById(R.id.des_but1);
        buttons[2] = (Button)findViewById(R.id.des_but2);
        buttons[3] = (Button)findViewById(R.id.des_but3);
        buttons[4] = (Button)findViewById(R.id.des_but4);
        buttons[5] = (Button)findViewById(R.id.des_but5);
        buttons[6] = (Button)findViewById(R.id.des_but6);
        buttons[7] = (Button)findViewById(R.id.des_but7);
        buttons[8] = (Button)findViewById(R.id.des_but8);
        buttons[9] = (Button)findViewById(R.id.des_but9);

        layouts = new LinearLayout[10];
        layouts[0] = (LinearLayout)findViewById(R.id.des_layout0);
        layouts[1] = (LinearLayout)findViewById(R.id.des_layout1);
        layouts[2] = (LinearLayout)findViewById(R.id.des_layout2);
        layouts[3] = (LinearLayout)findViewById(R.id.des_layout3);
        layouts[4] = (LinearLayout)findViewById(R.id.des_layout4);
        layouts[5] = (LinearLayout)findViewById(R.id.des_layout5);
        layouts[6] = (LinearLayout)findViewById(R.id.des_layout6);
        layouts[7] = (LinearLayout)findViewById(R.id.des_layout7);
        layouts[8] = (LinearLayout)findViewById(R.id.des_layout8);
        layouts[9] = (LinearLayout)findViewById(R.id.des_layout9);

        texts = new TextView[10];
        texts[0] = (TextView)findViewById(R.id.des_txt0);
        texts[1] = (TextView)findViewById(R.id.des_txt1);
        texts[2] = (TextView)findViewById(R.id.des_txt2);
        texts[3] = (TextView)findViewById(R.id.des_txt3);
        texts[4] = (TextView)findViewById(R.id.des_txt4);
        texts[5] = (TextView)findViewById(R.id.des_txt5);
        texts[6] = (TextView)findViewById(R.id.des_txt6);
        texts[7] = (TextView)findViewById(R.id.des_txt7);
        texts[8] = (TextView)findViewById(R.id.des_txt8);
        texts[9] = (TextView)findViewById(R.id.des_txt9);

        for(int i=0;i<10;i++) {
            buttons[i].setBackgroundDrawable(gd);
            buttons[i].setText(Global.decisions[Global.cat_offset * 10 + i]);
            texts[i].setText(Global.descriptions[Global.cat_offset * 10 + i]);
            texts[i].setTextSize(14);
            if(Global.dec_active[Global.cat_offset * 10 + i] == 1){
                buttons[i].setEnabled(false);
                buttons[i].setText("Already Taken");
                buttons[i].setTypeface(null, Typeface.BOLD_ITALIC);
                buttons[i].setTextColor(0xFF2D69DF);
            }
            layouts[i].setBackgroundDrawable(gd2);
            layouts[i].setVisibility(View.GONE);
        }
    }

    public void dec0(View view) {
        Global.cat_index = 0;
        Global.dec_active[Global.cat_offset * 10 + Global.cat_index] = 1;
        Global.parameters[5]--;
        finish();
    }

    public void dec1(View view) {
        Global.cat_index = 1;
        Global.dec_active[Global.cat_offset * 10 + Global.cat_index] = 1;
        Global.parameters[5]--;
        finish();
    }

    public void dec2(View view) {
        Global.cat_index = 2;
        Global.dec_active[Global.cat_offset * 10 + Global.cat_index] = 1;
        Global.parameters[5]--;
        finish();
    }

    public void dec3(View view) {
        Global.cat_index = 3;
        Global.dec_active[Global.cat_offset * 10 + Global.cat_index] = 1;
        Global.parameters[5]--;
        finish();
    }

    public void dec4(View view) {
        Global.cat_index = 4;
        Global.dec_active[Global.cat_offset * 10 + Global.cat_index] = 1;
        Global.parameters[5]--;
        finish();
    }

    public void dec5(View view) {
        Global.cat_index = 5;
        Global.dec_active[Global.cat_offset * 10 + Global.cat_index] = 1;
        Global.parameters[5]--;
        finish();
    }

    public void dec6(View view) {
        Global.cat_index = 6;
        Global.dec_active[Global.cat_offset * 10 + Global.cat_index] = 1;
        Global.parameters[5]--;
        finish();
    }

    public void dec7(View view) {
        Global.cat_index = 7;
        Global.dec_active[Global.cat_offset * 10 + Global.cat_index] = 1;
        Global.parameters[5]--;
        finish();
    }

    public void dec8(View view) {
        Global.cat_index = 8;
        Global.dec_active[Global.cat_offset * 10 + Global.cat_index] = 1;
        Global.parameters[5]--;
        finish();
    }

    public void dec9(View view) {
        Global.cat_index = 9;
        Global.dec_active[Global.cat_offset * 10 + Global.cat_index] = 1;
        Global.parameters[5]--;
        finish();
    }

    public void toggle_contents_1(View view)
    {
        layouts[0].setVisibility((layouts[0].isShown())? View.GONE:View.VISIBLE);
    }

    public void toggle_contents_2(View view)
    {
        layouts[1].setVisibility((layouts[1].isShown())? View.GONE:View.VISIBLE);
    }

    public void toggle_contents_3(View view)
    {
        layouts[2].setVisibility((layouts[2].isShown())? View.GONE:View.VISIBLE);
    }

    public void toggle_contents_4(View view)
    {
        layouts[3].setVisibility((layouts[3].isShown())? View.GONE:View.VISIBLE);
    }

    public void toggle_contents_5(View view)
    {
        layouts[4].setVisibility((layouts[4].isShown())? View.GONE:View.VISIBLE);
    }

    public void toggle_contents_6(View view)
    {
        layouts[5].setVisibility((layouts[5].isShown())? View.GONE:View.VISIBLE);
    }

    public void toggle_contents_7(View view)
    {
        layouts[6].setVisibility((layouts[6].isShown())? View.GONE:View.VISIBLE);
    }

    public void toggle_contents_8(View view)
    {
        layouts[7].setVisibility((layouts[7].isShown())? View.GONE:View.VISIBLE);
    }

    public void toggle_contents_9(View view)
    {
        layouts[8].setVisibility((layouts[8].isShown())? View.GONE:View.VISIBLE);
    }

    public void toggle_contents_10(View view)
    {
        layouts[9].setVisibility((layouts[9].isShown())? View.GONE:View.VISIBLE);
    }
}
