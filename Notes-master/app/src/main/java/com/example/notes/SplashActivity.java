package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


    }

    @Override
    protected void onStart() {
        super.onStart();
        Thread td = new Thread(){

            public void run(){
                try {
                    sleep(1000);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                finally {
                    Intent intent = new Intent(SplashActivity.this , LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };td.start();
    }
}