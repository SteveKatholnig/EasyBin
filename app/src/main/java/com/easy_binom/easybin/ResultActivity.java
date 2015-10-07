package com.easy_binom.easybin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by PC-Alpha on 16.09.2015.
 */
public class ResultActivity extends AppCompatActivity {

    String showResultKey = "com.easy_binom.easybin.resultKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        SharedPreferences prefs = getSharedPreferences(
                "com.easy_binom.app", Context.MODE_PRIVATE);

        TextView resultText = (TextView) findViewById(R.id.resultView);
        resultText.setText(prefs.getString(showResultKey, "no result"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_back) {
            finish();
            return true;
        }
        else if (id == R.id.action_info) {
        Intent mainIntent = new Intent(ResultActivity.this, InfoActivity.class);
        startActivity(mainIntent);
        return true;
    }

        return super.onOptionsItemSelected(item);
    }
}
