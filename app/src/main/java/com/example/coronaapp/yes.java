package com.example.coronaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class yes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yes);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(0xFF76EC95);
        }

        Button button = (Button)findViewById(R.id.yes_continue);
        LinearLayout layout = (LinearLayout)findViewById(R.id.layout2);
        TextView textView = findViewById(R.id.text_block);

        GradientDrawable gd = new GradientDrawable();
        gd.setStroke(1,0xFF45E341);
        gd.setCornerRadius(350);

        textView.setText(Global.yes[Global.q_index - 1]);
        layout.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] {0xFF76EC95,0xFFFFFFFF}));
        button.setBackgroundDrawable(gd);
    }

    public void cont(View view){
        Intent nxt;
        if(Global.q_index != 10) {
            nxt = new Intent(getBaseContext(), question.class);
        }
        else {
            nxt = new Intent(getBaseContext(), MainActivity.class);
        }
        startActivity(nxt);
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
