package com.example.lab6.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.example.lab6.R;

public class AnimationActivity extends AppCompatActivity {
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        img = findViewById(R.id.imageView);

        final Animation scaleAlpha = AnimationUtils.loadAnimation(this, R.anim.scale);
        final Animation rotateTranslate = AnimationUtils.loadAnimation(this, R.anim.rotate);

        Button rotTranslate = findViewById(R.id.rotate_translate);
        rotTranslate.setOnClickListener(v -> animate(rotateTranslate));

        Button scAlpha = findViewById(R.id.scale_alpha);
        scAlpha.setOnClickListener(v -> animate(scaleAlpha));
    }

    private void animate(Animation animation) {
        img.startAnimation(animation);
    }
}