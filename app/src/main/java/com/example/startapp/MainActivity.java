package com.example.startapp;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Button startButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((MySurfaceView) findViewById(R.id.mySurfaceView)).setMainActivity(this);
        startButton = findViewById(R.id.button);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //начать запись видео
                startButton.setAlpha(0);
                ((FrameLayout)findViewById(R.id.fl)).setAlpha(0);
            }
        });
    }
}