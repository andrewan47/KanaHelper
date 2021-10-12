package com.example.kana;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.LinkedList;

public class Practice extends AppCompatActivity {
    private static final String TAG = "Practice";
    private KanaTrace kanaTrace;
    ArrayList<String> background;
    Background bg;
    int current;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
        current = getIntent().getIntExtra("num", 0);
        background = getIntent().getStringArrayListExtra("setBackground");
        kanaTrace = (KanaTrace) findViewById(R.id.traceView);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        kanaTrace.init(metrics);
        bg = new Background(background, current, kanaTrace);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void Next(View view) {
        if (current < background.size() - 1) {
            current++;
            getIntent().putExtra("num", current);
            finish();
            overridePendingTransition(0, 0);
            startActivity(getIntent());
            overridePendingTransition(0, 0);
            bg = new Background(background, current, kanaTrace);
        }
        else {
            Intent main = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(main);
            finish();
        }
    }
}