package com.example.coronaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
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

public class no extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(0xFFFF7E7E);
        }

        Button button = (Button)findViewById(R.id.no_continue);
        LinearLayout layout = (LinearLayout)findViewById(R.id.layout3);
        TextView textView = findViewById(R.id.text_block);

        GradientDrawable gd = new GradientDrawable();
        gd.setStroke(1,0xFFFB494E);
        gd.setCornerRadius(350);

        textView.setText(Global.no[Global.q_index - 1]);
        layout.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] {0xFFFF7E7E,0xFFFFFFFF}));
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
