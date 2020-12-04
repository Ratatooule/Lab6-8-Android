package com.example.lab6.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab6.R;
import com.example.lab6.model.HistoryEntry;

public class HistoryActivity extends AppCompatActivity {

    HistoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Intent intent = getIntent();

        adapter = new HistoryAdapter();
        if (intent != null && intent.hasExtra(MainActivity.HISTORY_KEY)) {
            adapter.initialize(intent.<HistoryEntry>getParcelableArrayListExtra(MainActivity.HISTORY_KEY));
        }

        RecyclerView recyclerView = findViewById(R.id.history_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}