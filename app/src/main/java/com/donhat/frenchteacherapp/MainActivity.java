package com.donhat.frenchteacherapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Get view instances
        Button blackBtn = findViewById(R.id.black_btn);
        Button greenBtn = findViewById(R.id.green_btn);
        Button purpleBtn = findViewById(R.id.purple_btn);
        Button redBtn = findViewById(R.id.red_btn);
        Button yellowBtn = findViewById(R.id.yellow_btn);

        // Handle click
        blackBtn.setOnClickListener(this);
        greenBtn.setOnClickListener(this);
        purpleBtn.setOnClickListener(this);
        redBtn.setOnClickListener(this);
        yellowBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int clickedBtnId = v.getId();

        if (clickedBtnId == R.id.black_btn) {
            playSounds(R.raw.black);
        } else if (clickedBtnId == R.id.green_btn) {
            playSounds(R.raw.green);
        } else if (clickedBtnId == R.id.purple_btn) {
            playSounds(R.raw.purple);
        } else if (clickedBtnId == R.id.red_btn) {
            playSounds(R.raw.red);
        } else if (clickedBtnId == R.id.yellow_btn) {
            playSounds(R.raw.yellow);
        }
    }

    private void playSounds(int id) {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, id);
        mediaPlayer.start();
    }
}