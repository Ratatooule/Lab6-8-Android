package com.example.lab6.view;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;

import com.example.lab6.R;

public class SharedPreferenceFragment extends PreferenceFragment {

    private final int NOT_HIDE = 1;
    private final int HIDE = 2;

    public SharedPreferenceFragment() {
    }

    public static SharedPreferenceFragment newInstance() {
        SharedPreferenceFragment fragment = new SharedPreferenceFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.shared_preference);

        PreferenceScreen screen = (PreferenceScreen) findPreference("pref");
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) findPreference("check");
        ListPreference listPreference = (ListPreference) findPreference("name");

        checkBoxPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                if (!checkBoxPreference.isChecked()) {
                    screen.removePreference(listPreference);
                    return true;
                } else {
                    screen.addPreference(listPreference);
                    return true;
                }
            }
        });
    }
}
