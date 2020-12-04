package com.example.lab6.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.lab6.model.HistoryEntry;
import com.example.lab6.R;
import com.example.lab6.viewmodel.HistoryFacade;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FrameLayout fragmentSlot;

    private int status = 1;
    private final int SUM_FRAGMENT = 1;
    private final int BTN_FRAGMENT = 2;
    public static final String HISTORY_KEY = "history";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentSlot = findViewById(R.id.fragment_place);

        if (fragmentSlot != null) {
            changeToSumFragment();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    private void changeFragment(android.app.Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_place, fragment);
        fragmentTransaction.commit();
    }

    private void changeToBtnFragment() {
        changeFragment(SecondFragment.newInstance());
        status = BTN_FRAGMENT;
    }

    private void changeToSumFragment() {
        changeFragment(FirstFragment.newInstance());
        status = SUM_FRAGMENT;
    }

    public void switchFragment(View view) {
        if (status == SUM_FRAGMENT)
            changeToBtnFragment();
        else if (status == BTN_FRAGMENT)
            changeToSumFragment();
    }

    public void switchActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void addToHistory(HistoryEntry newItem) {
        HistoryFacade.addItem(getBaseContext(), newItem);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.history_open:
                intent = new Intent(this, HistoryActivity.class);
                intent.putParcelableArrayListExtra(HISTORY_KEY, new ArrayList<>(HistoryFacade.getAllAsList(getBaseContext())));
                startActivity(intent);
                break;
            case R.id.service_item:
                intent = new Intent(this, ServiceActivity.class);
                startActivity(intent);
                break;
            case R.id.browser_call_item:
                intent = new Intent(this, BrowserCallActivity.class);
                startActivity(intent);
                break;
            case R.id.file_item:
                intent = new Intent(this, FileActivity.class);
                startActivity(intent);
                break;
            case R.id.shared_pref_item:
                intent = new Intent(this, SharedPreferenceActivity.class);
                startActivity(intent);
                break;
            case R.id.db_item:
                intent = new Intent(this, DbActivity.class);
                startActivity(intent);
                break;
            case R.id.animation_item:
                intent = new Intent(this, AnimationActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
