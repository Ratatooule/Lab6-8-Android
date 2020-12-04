package com.example.lab6.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.lab6.R;
import com.example.lab6.viewmodel.HistoryFacade;

public class DbActivity extends AppCompatActivity {

    TextView dbContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        dbContent = findViewById(R.id.db_textView);


        Button showDbButton = findViewById(R.id.show_db_button);
        showDbButton.setOnClickListener(v -> showDb());
        Button clearDbButton = findViewById(R.id.clear_db_button);
        clearDbButton.setOnClickListener(v -> clearDb());
    }

    private void showDb() {
        dbContent.setText(HistoryFacade.getAllAsString(getBaseContext()));
    }
    private void clearDb() {
        HistoryFacade.deleteAll(getBaseContext());
    }

}