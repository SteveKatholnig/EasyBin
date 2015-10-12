package com.easy_binom.easybin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    String showResultKey = "com.easy_binom.easybin.resultKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        // Lade shared Preferences für die Anzeige des Ergebnisses aus den Tabs
        SharedPreferences prefs = getSharedPreferences(
                "com.easy_binom.app", Context.MODE_PRIVATE);

        //Setzte Textview nun auf den Wert, der in SharedPreferences durch die Tabs gesetzt wurde.
        TextView resultText = (TextView) findViewById(R.id.resultView);
        resultText.setText(prefs.getString(showResultKey, "no result"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Zeige Menü mithilfe von MenuInflater wenn Menüelemente vorhanden.
        getMenuInflater().inflate(R.menu.menu_result, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Hier werden klicks auf die Action Bar Elemente behandelt. Die Action Bar behandelt klicks
        // automatisch wenn keine parent activity in der AndroidManifest.xml angegeben wurde.
        // Somit ist kein OnClickListener nötig.
        int id = item.getItemId();

        // Wenn Zurückbutton geklickt wurde, wird finish Methode der Activity aufgerufen
        if (id == R.id.action_back) {
            finish();
            return true;
        }
        // Wurde der Info Button in der Action Bar betätigt, wird die zugehörige Activity gestartet
        // finish Methode von BinomActivity wird nicht aufgerufen um Sie auf dem Stack zu lassen.
        else if (id == R.id.action_info) {
            Intent mainIntent = new Intent(ResultActivity.this, InfoActivity.class);
            startActivity(mainIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
