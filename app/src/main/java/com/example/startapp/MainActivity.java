package com.example.startapp;

import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Button startButton;
    private MyDraw md;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        md = findViewById(R.id.myDraw);
        md.setMa(this);

        startButton = findViewById(R.id.button);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //начать запись видео
                startButton.setText("Идёт запись");
                startButton.setEnabled(false);
                md.setPause(false);

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        md.setPause(true);
        startButton.setText("Запись не удалась. Начать заново.");
        startButton.setEnabled(true);
    }

}