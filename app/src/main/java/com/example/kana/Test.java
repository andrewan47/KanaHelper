package com.example.kana;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
public class Test extends AppCompatActivity {
    private static final String TAG = "Test";
    private KanaTrace kanaTrace;
    ArrayList<String> background;
    TextView textView;
    Background bg;
    int current;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        current = getIntent().getIntExtra("num", 0);
        background = getIntent().getStringArrayListExtra("setName");
        kanaTrace = (KanaTrace) findViewById(R.id.traceView);
        textView = (TextView) findViewById(R.id.textView4);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        kanaTrace.init(metrics);
        bg = new Background(background, current, textView);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void nextTestClicked(View view) {
        if (current < background.size() - 1) {
            current++;
            getIntent().putExtra("num", current);
            finish();
            startActivity(getIntent());
            overridePendingTransition(0, 0);
            bg = new Background(background, current, textView);
        }
        else {
            Intent main = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(main);
            finish();
        }
    }

    public void prevTestClicked(View view) {
        if (current > 0) {
            current--;
            getIntent().putExtra("num", current);
            finish();
            startActivity(getIntent());
            overridePendingTransition(0, 0);
            bg = new Background(background, current, textView);
        }
        else {
            clearTestClicked(view);
        }
    }

    public void clearTestClicked(View view) {
        getIntent().putExtra("num", current);
        finish();
        startActivity(getIntent());
        overridePendingTransition(0, 0);
        bg = new Background(background, current, textView);
    }

    public void displayClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.radioButton:
                if (checked)
                    bg = new Background(background, current, kanaTrace, textView);
                break;
        }
    }
}