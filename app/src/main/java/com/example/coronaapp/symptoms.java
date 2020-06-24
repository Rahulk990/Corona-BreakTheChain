package com.example.coronaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.Toast;

public class symptoms extends AppCompatActivity {
    CheckBox[] cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(0xFFA6D4F8);
        }

        cb = new CheckBox[9];
        cb[0]=(CheckBox)findViewById(R.id.check1);
        cb[1]=(CheckBox)findViewById(R.id.check2);
        cb[2]=(CheckBox)findViewById(R.id.check3);
        cb[3]=(CheckBox)findViewById(R.id.check4);
        cb[4]=(CheckBox)findViewById(R.id.check5);
        cb[5]=(CheckBox)findViewById(R.id.check6);
        cb[6]=(CheckBox)findViewById(R.id.check7);
        cb[7]=(CheckBox)findViewById(R.id.check8);
        cb[8]=(CheckBox)findViewById(R.id.check9);
    }

    public void ch1(View view)
    {
        cb[0].toggle();
    }
    public void ch2(View view)
    {
        cb[1].toggle();
    }
    public void ch3(View view)
    {
        cb[2].toggle();
    }
    public void ch4(View view)
    {
        cb[3].toggle();
    }
    public void ch5(View view)
    {
        cb[4].toggle();
    }
    public void ch6(View view)
    {
        cb[5].toggle();
    }
    public void ch7(View view) { cb[6].toggle(); }
    public void ch8(View view)
    {
        cb[7].toggle();
    }
    public void ch9(View view)
    {
        cb[8].toggle();
    }

    public void submit(View view)
    {
        for(int i=0;i<9;i++){
            if(cb[i].isChecked()){
                if(i==0 || i==2 || i==4 || i==6 || i==8)
                    Global.score++;
                else
                    Global.score--;
            }
        }
        Intent i = new Intent(this, dispscore.class);
        startActivity(i);
        finish();
    }

    private long backtime;
    @Override
    public void onBackPressed() {
        if(backtime + 2000 > System.currentTimeMillis())
        {
            super.onBackPressed();
            finish();
        } else
        {
            Toast.makeText(getBaseContext(), "Press Back Again, to Exit", Toast.LENGTH_SHORT).show();
        }
        backtime = System.currentTimeMillis();
    }
}
