package com.example.antsoft.animation;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class App extends Application {

    private Typeface typeace;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        typeace = Typeface.createFromAsset(getAssets(), getResources().getString(R.string.font_name));
    }



    private void overrideFonts(final Context context, final View v) {
        try {
            if (v instanceof ViewGroup) {
                ViewGroup vg = (ViewGroup) v;
                for (int i = 0; i < vg.getChildCount(); i++) {
                    View child = vg.getChildAt(i);
                    overrideFonts(context, child);
                }
            } else if (v instanceof TextView) {
                ((TextView) v).setTypeface(typeace);
            } else if (v instanceof EditText) {
                ((EditText) v).setTypeface(typeace);
            } else if (v instanceof Button) {
                ((Button) v).setTypeface(typeace);
            }
        } catch (Exception e) {
        }
    }
}