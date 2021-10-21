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

    //Vowls and n
    public void aClicked(View view) {
        list.add("ahiragana");
    }

    public void eClicked(View view) {
        list.add("ehiragana");
    }

    public void iClicked(View view) {
        list.add("ihiragana");
    }

    public void oClicked(View view) {
        list.add("ohiragana");
    }

    public void uClicked(View view) {
        list.add("uhiragana");
    }

    public void nClicked(View view) {
        list.add("nhiragana");
    }

    //K an g
    public void kaClicked(View view) {
        list.add("kahiragana");
    }

    public void keClicked(View view) {
        list.add("kehiragana");
    }

    public void kiClicked(View view) {
        list.add("kihiragana");
    }

    public void koClicked(View view) {
        list.add("kohiragana");
    }

    public void kuClicked(View view) {
        list.add("kuhiragana");
    }

    public void gaClicked(View view) {
        list.add("gahiragana");
    }

    public void geClicked(View view) {
        list.add("gehiragana");
    }

    public void giClicked(View view) {
        list.add("gihiragana");
    }

    public void goClicked(View view) {
        list.add("gohiragana");
    }

    public void guClicked(View view) {
        list.add("guhiragana");
    }

    //s and z
    public void saClicked(View view) {
        list.add("sahiragana");
    }

    public void seClicked(View view) {
        list.add("sehiragana");
    }

    public void shiClicked(View view) {
        list.add("shihiragana");
    }

    public void soClicked(View view) {
        list.add("sohiragana");
    }

    public void suClicked(View view) {
        list.add("suhiragana");
    }

    public void zaClicked(View view) {
        list.add("zahiragana");
    }

    public void zeClicked(View view) {
        list.add("zehiragana");
    }

    public void jiClicked(View view) {
        list.add("jihiragana");
    }

    public void zoClicked(View view) {
        list.add("zohiragana");
    }

    public void zuClicked(View view) {
        list.add("zuhiragana");
    }

    //t and d
    public void taClicked(View view) {
        list.add("tahiragana");
    }

    public void teClicked(View view) {
        list.add("tehiragana");
    }

    public void chiClicked(View view) {
        list.add("chihiragana");
    }

    public void toClicked(View view) {
        list.add("tohiragana");
    }

    public void tsuClicked(View view) {
        list.add("tsuhiragana");
    }

    public void daClicked(View view) {
        list.add("ahiragana");
    }

    public void deClicked(View view) {
        list.add("ehiragana");
    }

    public void jidiClicked(View view) {
        list.add("jidihiragana");
    }

    public void doClicked(View view) {
        list.add("dohiragana");
    }

    public void zuduClicked(View view) {
        list.add("zuduhiragana");
    }

    //n
    public void naClicked(View view) {
        list.add("nahiragana");
    }

    public void neClicked(View view) {
        list.add("nehiragana");
    }

    public void niClicked(View view) {
        list.add("nihiragana");
    }

    public void noClicked(View view) {
        list.add("nohiragana");
    }

    public void nuClicked(View view) {
        list.add("nuhiragana");
    }

    //h, b, and p
    public void haClicked(View view) {
        list.add("hahiragana");
    }

    public void heClicked(View view) {
        list.add("hehiragana");
    }

    public void hiClicked(View view) {
        list.add("hihiragana");
    }

    public void hoClicked(View view) {
        list.add("hohiragana");
    }

    public void fuClicked(View view) {
        list.add("fuhiragana");
    }

    public void baClicked(View view) {
        list.add("bahiragana");
    }

    public void beClicked(View view) {
        list.add("behiragana");
    }

    public void biClicked(View view) {
        list.add("bihiragana");
    }

    public void boClicked(View view) {
        list.add("bohiragana");
    }

    public void buClicked(View view) {
        list.add("buhiragana");
    }

    public void paClicked(View view) {
        list.add("pahiragana");
    }

    public void peClicked(View view) {
        list.add("pehiragana");
    }

    public void piClicked(View view) {
        list.add("pihiragana");
    }

    public void poClicked(View view) {
        list.add("pohiragana");
    }

    public void puClicked(View view) {
        list.add("puhiragana");
    }

    //m
    public void maClicked(View view) {
        list.add("mahiragana");
    }

    public void meClicked(View view) {
        list.add("mehiragana");
    }

    public void miClicked(View view) {
        list.add("mihiragana");
    }

    public void moClicked(View view) {
        list.add("mohiragana");
    }

    public void muClicked(View view) {
        list.add("muhiragana");
    }

    //y
    public void yaClicked(View view) {
        list.add("yahiragana");
    }

    public void yoClicked(View view) {
        list.add("yohiragana");
    }

    public void yuClicked(View view) {
        list.add("yuhiragana");
    }

    //r
    public void raClicked(View view) {
        list.add("rahiragana");
    }

    public void reClicked(View view) {
        list.add("rehiragana");
    }

    public void riClicked(View view) {
        list.add("rihiragana");
    }

    public void roClicked(View view) {
        list.add("rohiragana");
    }

    public void ruClicked(View view) {
        list.add("ruhiragana");
    }

    //w
    public void waClicked(View view) {
        list.add("wahiragana");
    }

    public void woClicked(View view) {
        list.add("wohiragana");
    }

    public void practiceClicked(View view) {
        Intent learnIntent = new Intent(getApplicationContext(), Practice.class);
        learnIntent.putExtra("setBackground", list);
        startActivity(learnIntent);
        finish();
    }

    public void testClicked(View view) {
        Intent testIntent = new Intent(getApplicationContext(), Practice.class);
        testIntent.putExtra("setName", list);
        startActivity(testIntent);
        finish();
    }
}