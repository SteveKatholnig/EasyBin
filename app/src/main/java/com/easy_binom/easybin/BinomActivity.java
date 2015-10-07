package com.easy_binom.easybin;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;


/**
 * Created by KatholnigS on 23.09.2015.
 */

public class BinomActivity extends AppCompatActivity {

    // Declaring Your View and Variables
    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence titles[] = {"First", "Second", "Third"};
    int numbOfTabs = 3;
    boolean showAlert;
    String showAlertKey = "com.easy_binom.easybin.showAlert";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThemeChanger.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_binom);

        SharedPreferences prefs = getSharedPreferences(
                "com.easy_binom.app", Context.MODE_PRIVATE);

        showAlert = prefs.getBoolean(showAlertKey, true);

        //Custom Toast mit Material Design. SharedPreferences werden in FirstActivity gesetzt,
        //damit Toast nur bei Programmstart gezeigt wird.
        if (showAlert == true) {
            AlertDialog.Builder builder = new AlertDialog.Builder(BinomActivity.this, R.style.MyAlertDialogStyle);
            builder.setTitle("DISCLAIMER");
            builder.setMessage(R.string.lorem);
            builder.setPositiveButton("OK", null);
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.setCancelable(false);
            builder.show();
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean(showAlertKey, false);
            editor.commit();
        }

        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), titles, numbOfTabs);

        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return ContextCompat.getColor(BinomActivity.this, R.color.tabsScrollColor);
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent mainIntent = new Intent(BinomActivity.this, AboutUsActivity.class);
            startActivity(mainIntent);
            return true;
        } else if (id == R.id.action_settings2) {
            ThemeChanger.changeToTheme(this, ThemeChanger.THEME_SECOND);
            return true;
        } else if (id == R.id.action_settings3) {
            ThemeChanger.changeToTheme(this, ThemeChanger.THEME_DEFAULT);
            return true;
        } else if (id == R.id.action_info) {
            Intent mainIntent = new Intent(BinomActivity.this, InfoActivity.class);
            startActivity(mainIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
