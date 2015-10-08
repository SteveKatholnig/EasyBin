package com.easy_binom.easybin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Zeige Menü mithilfe von MenuInflater wenn Menüelemente vorhanden.
        getMenuInflater().inflate(R.menu.about_us, menu);
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

        return super.onOptionsItemSelected(item);
    }
}
