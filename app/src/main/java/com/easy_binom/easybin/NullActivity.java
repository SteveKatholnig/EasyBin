package com.easy_binom.easybin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class NullActivity extends AppCompatActivity {
    String themeKey = "com.easy_binom.easybin.themeKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThemeChanger.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_null);

        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fab1);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO Die Nullstellenberechnung

            }
        });
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
            Intent mainIntent = new Intent(NullActivity.this, InfoActivity.class);
            startActivity(mainIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
