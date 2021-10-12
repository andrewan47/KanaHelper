package com.example.kana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = new ArrayList<String>();
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void LearnClicked(View view) {
        list.add("ahiragana");
    }

    public void TestClicked(View view) {
        list.add("uhiragana");
    }

    public void Continue(View view) {
        Intent learnIntent = new Intent(getApplicationContext(), Practice.class);
        learnIntent.putExtra("setBackground", list);
        startActivity(learnIntent);
        finish();
    }
}