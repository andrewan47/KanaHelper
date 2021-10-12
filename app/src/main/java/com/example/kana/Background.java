package com.example.kana;

import android.view.View;

import java.util.ArrayList;

public class Background {

    public Background(ArrayList<String> background, int num, KanaTrace kt) {
        if (background.get(num).equals("ahiragana")) {
            kt.setBackgroundResource(R.drawable.ahiragana);
            kt.getBackground().setAlpha(120);
        }
        else if (background.get(num).equals("kihiragana")) {
            kt.setBackgroundResource(R.drawable.kihiragana);
            kt.getBackground().setAlpha(120);
        }
        else if (background.get(num).equals("uhiragana")) {
            kt.setBackgroundResource(R.drawable.uhiragana);
            kt.getBackground().setAlpha(120);
        }
    }
}
