package com.example.myapplication;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    MediaPlayer muzyka;
    RadioGroup radiogrupa1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        muzyka = MediaPlayer.create(this, R.raw.music2);
        radiogrupa1 = findViewById(R.id.radiogrupa1);


        radiogrupa1.setOnCheckedChangeListener((group, checkedId) -> {
            if (muzyka != null) {
                muzyka.stop();
                muzyka.release();
                muzyka = null;
            }

            if (checkedId == R.id.utwor1) {
                muzyka = MediaPlayer.create(this, R.raw.music1);
            } else if (checkedId == R.id.utwor2) {
                muzyka = MediaPlayer.create(this, R.raw.music2);
            }
        });
    }

    public void Play(View view) {
        if (muzyka != null) {
            muzyka.start();
        }
    }

    public void Stop(View view) {
        if (muzyka != null) {
            muzyka.stop();
            muzyka.release();
            muzyka = null;
        }
    }

    public void Pauza(View view) {
        if (muzyka != null && muzyka.isPlaying()) {
            muzyka.pause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (muzyka != null) {
            muzyka.release();
            muzyka = null;
        }
    }
}