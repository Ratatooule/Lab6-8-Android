package com.example.lab6.view;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class SharedPreferenceActivity extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SharedPreferenceFragment())
                .commit();
    }
}
