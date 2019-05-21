package com.itgds.khadametdz.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import com.itgds.khadametdz.R;

public class SplashScreenBus extends AppCompatActivity {
    private ProgressBar progressBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_bus);
         progressBar=findViewById(R.id.id_progress_bus);
        // Start lengthy operation in a background thread
        new Thread(new Runnable() {
            public void run() {
                doWork();
                startApp();
                try {
                    ActivityCompat.finishAfterTransition(SplashScreenBus.this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void doWork() {
        for (int progress = 0; progress < 100; progress++) {
            try {
                Thread.sleep(20);
                progressBar.setProgress(progress);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void startApp() {
        Intent intent = new Intent(this, ActivityBus.class);
        startActivity(intent);
    }
}
