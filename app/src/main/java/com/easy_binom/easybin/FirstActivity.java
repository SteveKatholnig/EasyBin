package com.easy_binom.easybin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

/**
 * Created by PC-Alpha on 16.09.2015.
 */
public class FirstActivity extends AppCompatActivity {

    String showAlertKey = "com.easy_binom.easybin.showAlert";
    String showResultKey = "com.easy_binom.easybin.resultKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        SharedPreferences prefs = getSharedPreferences(
                "com.easy_binom.app", Context.MODE_PRIVATE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Thread logoTimer = new Thread() {
            public void run() {
                try {
                    sleep(1500);
                    Intent mainIntent = new Intent(FirstActivity.this, BinomActivity.class);
                    startActivity(mainIntent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {

                }
            }
        };
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(showAlertKey, true);
        editor.putString(showResultKey, "");
        editor.commit();
        logoTimer.start();
    }
}
