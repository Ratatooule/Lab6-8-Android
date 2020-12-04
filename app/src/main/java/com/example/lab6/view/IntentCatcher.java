package com.example.lab6.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.lab6.R;

public class IntentCatcher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_catcher);

        ImageView imgView = findViewById(R.id.image_link);
        Intent intent = getIntent();
        if (intent != null) {
            imgView.setImageURI(intent.getParcelableExtra(Intent.EXTRA_STREAM));
        }
    }
}