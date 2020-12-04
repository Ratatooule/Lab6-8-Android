package com.example.lab6.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.TextView;

import com.example.lab6.R;
import com.example.lab6.viewmodel.FileProcessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileActivity extends AppCompatActivity {

    TextView fileContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        Button fileButton = findViewById(R.id.show_file_button);
        fileButton.setOnClickListener(v -> loadFileContents());
        fileContent = findViewById(R.id.file_textView);
    }

    private void loadFileContents() {
        fileContent.setText(FileProcessor.loadFileContent(getString(R.string.log_file_name)));
    }
}