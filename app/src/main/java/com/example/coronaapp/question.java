package com.example.coronaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class question extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(0xFF99BDF9);
        }

        LinearLayout layout = (LinearLayout)findViewById(R.id.layout1);
        TextView textView = findViewById(R.id.Q_text);
        ImageView imageView = findViewById(R.id.question_icon);
        String image_path = "@drawable/ques" + (char)(Global.q_index + '0');
        int imageResource = getResources().getIdentifier(image_path, null, getPackageName());

        textView.setText(Global.questions[Global.q_index]);
        Drawable res = getResources().getDrawable(imageResource);
        imageView.setImageDrawable(res);
        layout.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] {0xFF99BDF9,0xFFFFFFFF}));
    }

    public void yes(View view){
        Global.q_index++;
        Intent nxt;
        if(Global.truth[Global.q_index-1] == 1){
            nxt = new Intent(getBaseContext(), yes.class);
        }
        else{
            nxt = new Intent(getBaseContext(), no.class);
        }
        startActivity(nxt);
        finish();
    }

    public void no(View view) {
        Global.q_index++;
        Intent nxt;
        if(Global.truth[Global.q_index-1] == 0){
            nxt = new Intent(getBaseContext(), yes.class);
        }
        else{
            nxt = new Intent(getBaseContext(), no.class);
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