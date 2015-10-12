package com.easy_binom.easybin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

public class FirstActivity extends AppCompatActivity {

    String showAlertKey = "com.easy_binom.easybin.showAlert";
    String showResultKey = "com.easy_binom.easybin.resultKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        // Lade shared Preferences um Sie auf definierte Zustände bei App Start zu setzen.
        SharedPreferences prefs = getSharedPreferences(
                "com.easy_binom.app", Context.MODE_PRIVATE);

        // Setzte Fullscreen-Flag um Fenster im Vollbildmodus und ohne Status-Leiste von Android
        // anzuzeigen.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Starte LogoTimer Thread um die Activity eine bestimmte Zeit anzuzeigen.
        Thread logoTimer = new Thread() {
            public void run() {
                try {
                    sleep(1500);
                    Intent mainIntent = new Intent(FirstActivity.this, BinomActivity.class);
                    startActivity(mainIntent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // Erstelle Editor Objekt um sharedPreferences bearbeiten zu können.
        SharedPreferences.Editor editor = prefs.edit();
        // Setzte showAlertKey auf true um Disclaimer in BinomActivity anzuzeigen.
        editor.putBoolean(showAlertKey, true);

        // Setzte showResultKey auf isEmpty()= true um einen definierten Zustand herzustellen.
        // Diese SharedPreference wird in den Tabs verwendet um mit der ResultActivity zu kommunizieren.
        editor.putString(showResultKey, "");
        editor.commit();
        logoTimer.start();
    }
}
