package com.easy_binom.easybin;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Transition;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

public class BinomActivity extends AppCompatActivity {

    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    //Hier wird die Beschriftung der Tabs für das TabMenü festgelegt
    CharSequence titles[] = {"First", "Second", "Third"};
    int numbOfTabs = 3;
    int usedTheme = 0;

    String showAlertKey = "com.easy_binom.easybin.showAlert";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ThemeChanger.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_binom);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        // Lade shared Preferences für die Anzeige von Disclaimer Toast
        // Wird im Moment noch von FirstActivity bei jedem Start auf true gesetzt.
        SharedPreferences prefs = getSharedPreferences(
                "com.easy_binom.app", Context.MODE_PRIVATE);
        boolean showAlert = prefs.getBoolean(showAlertKey, true);

        // Custom Toast mit Material Design. SharedPreferences werden in FirstActivity gesetzt,
        // damit Toast nur bei Programmstart und nicht bei OnCreate von Activity gestartet wird.
        if (showAlert) {
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

        // Erstellen des ViewPagerAdapter und übergabe des Fragment Managers, Titel der Tabs und die Anzahl der Tabs.
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), titles, numbOfTabs);

        // Zuweisen der ViewPager Views und setzen des Adapters
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        // Zuweisen der SlidingTabLayout View. SetDistributeEvenly(true) verteilt den Raum der Tabs
        // gleichmäßig in der verfügbaren Breite.
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true);

        // Setze eine spezifische Farbe für den Tab Indikator
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return ContextCompat.getColor(BinomActivity.this, R.color.tabsScrollColor);
            }
        });

        // Setze nun den ViewPager für die tabs
        tabs.setViewPager(pager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Zeige Menü mithilfe von MenuInflater wenn Menüelemente vorhanden.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Hier werden klicks auf die Action Bar Elemente behandelt. Die Action Bar behandelt klicks
        // automatisch wenn keine parent activity in der AndroidManifest.xml angegeben wurde.
        // Somit ist kein OnClickListener nötig.
        int id = item.getItemId();
        // Unterscheide die Menüaktionen.
        if (id == R.id.action_settings) {
            // Wurde "Über uns" im Menü gewählt, wird nun diese Activity geöffnet
            // finish Methode von BinomActivity wird nicht aufgerufen um Sie auf dem Stack zu lassen.
            Intent mainIntent = new Intent(BinomActivity.this, AboutUsActivity.class);
            startActivity(mainIntent);
            return true;
        } else if (id == R.id.action_settings2) {
            // Wurde "Mario Werner" im Menü gewählt, werden nun über die ThemeChanger Klasse die
            // Änderungen der Akzentfarber eingeleitet.
            ThemeChanger.changeToTheme(this, ThemeChanger.THEME_SECOND);
            return true;
        } else if (id == R.id.action_settings3) {
            // Wurde "Steve Katholnig" im Menü gewählt, werden nun über die ThemeChanger Klasse die
            // Änderungen der Akzentfarber eingeleitet.
            ThemeChanger.changeToTheme(this, ThemeChanger.THEME_DEFAULT);
            return true;
        } else if (id == R.id.action_settings4) {
            Intent mainIntent = new Intent(BinomActivity.this, NullActivity.class);
            startActivity(mainIntent);
            finish();
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
            return true;
        } else if (id == R.id.action_info) {
            // Wurde der Info Button in der Action Bar betätigt, wird die zugehörige Activity gestartet
            // finish Methode von BinomActivity wird nicht aufgerufen um Sie auf dem Stack zu lassen.
            Intent mainIntent = new Intent(BinomActivity.this, InfoActivity.class);
            startActivity(mainIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
