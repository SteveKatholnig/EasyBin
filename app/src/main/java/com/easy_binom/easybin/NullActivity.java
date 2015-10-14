package com.easy_binom.easybin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.transition.Transition;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

public class NullActivity extends AppCompatActivity {
    String showResultKey = "com.easy_binom.easybin.resultKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ThemeChanger.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_null);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        final EditText editText1 = (EditText) findViewById(R.id.editText);
        final EditText editText2 = (EditText) findViewById(R.id.editText2);
        final EditText editText3 = (EditText) findViewById(R.id.editText3);

        View view = this.findViewById(R.id.entire_view);

        view.setOnTouchListener(new OnSwipeTouchListener(this.getBaseContext()) {
            public void onSwipeBottom() {
                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
            }

            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        });

        SharedPreferences prefs = this.getSharedPreferences(
                "com.easy_binom.app", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = prefs.edit();

        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fab1);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double firstParam;
                double secondParam;
                double thirdParam;

                if (editText1.getText().toString().isEmpty()) {
                    editText1.setError(getString(R.string.errorMessage));
                    if (editText2.getText().toString().isEmpty()) {
                        editText2.setError(getString(R.string.errorMessage));
                        if (editText3.getText().toString().isEmpty()) {
                            editText3.setError(getString(R.string.errorMessage));
                        }
                    }
                } else {
                    firstParam = Double.parseDouble(editText1.getText().toString());
                    if (editText2.getText().toString().isEmpty()) {
                        editText2.setError(getString(R.string.errorMessage));
                    } else {
                        secondParam = Double.parseDouble(editText2.getText().toString());
                        if (editText3.getText().toString().isEmpty()) {
                            editText3.setError(getString(R.string.errorMessage));
                        } else {
                            thirdParam = Double.parseDouble((editText3.getText().toString()));
                            editor.putString(showResultKey, "Your input was: " + editText1.getText().toString() +  "x² + " + editText2.getText().toString() + "x + " + editText3.getText().toString() + "\n" + Abc.formel(firstParam, secondParam, thirdParam));
                            editor.commit();
                            Intent mainIntent = new Intent(NullActivity.this, ResultActivity.class);
                            startActivity(mainIntent);
                        }
                    }
                }

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
            Intent mainIntent = new Intent(NullActivity.this, BinomActivity.class);
            startActivity(mainIntent);
            finish();
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
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

    @Override
    public void onBackPressed() {
        Intent mainIntent = new Intent(NullActivity.this, BinomActivity.class);
        startActivity(mainIntent);
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
        super.onBackPressed();
    }
}
