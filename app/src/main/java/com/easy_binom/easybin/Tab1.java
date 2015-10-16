package com.easy_binom.easybin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class Tab1 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View vi = inflater.inflate(R.layout.tab1, container, false);
        final String showResultKey = "com.easy_binom.easybin.resultKey";
        SharedPreferences prefs = this.getActivity().getSharedPreferences(
                "com.easy_binom.app", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = prefs.edit();
        final EditText editText1 = (EditText) vi.findViewById(R.id.editText11);
        final EditText editText2 = (EditText) vi.findViewById(R.id.editText12);

        vi.setOnTouchListener(new OnSwipeTouchListener(this.getContext()) {
            public void onSwipeBottom() {
                editText1.setText("");
                editText2.setText("");
            }

            public boolean onTouch(View v, MotionEvent event) {
                editText1.setError(null);
                editText2.setError(null);
                InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(getActivity().INPUT_METHOD_SERVICE);
                try{
                    inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
                }catch (NullPointerException e){
                    return gestureDetector.onTouchEvent(event);
                }
                return gestureDetector.onTouchEvent(event);
            }
        });

        FloatingActionButton floatingActionButton = (FloatingActionButton) vi.findViewById(R.id.fab1);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double firstParam;
                double secondParam;

                if (editText1.getText().toString().isEmpty()) {
                    editText1.setError(getString(R.string.errorMessage));
                    if (editText2.getText().toString().isEmpty()) {
                        editText2.setError(getString(R.string.errorMessage));
                    }
                } else {
                    if (editText2.getText().toString().isEmpty()) {
                        editText2.setError(getString(R.string.errorMessage));
                    } else {
                        try {
                            firstParam = Double.parseDouble(editText1.getText().toString());
                            secondParam = Double.parseDouble(editText2.getText().toString());
                            editor.putString(showResultKey, Binom.firstBinom(firstParam, secondParam));
                            editor.commit();
                            Intent mainIntent = new Intent(getActivity(), ResultActivity.class);
                            startActivity(mainIntent);
                        } catch (NumberFormatException e) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.MyAlertDialogStyle);
                            builder.setTitle("Don't try it");
                            builder.setMessage(R.string.numberFormatError);
                            builder.setPositiveButton("OK", null);
                            builder.setCancelable(false);
                            builder.show();
                        }
                    }
                }
            }
        });
        return vi;
    }
}
