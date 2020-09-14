package com.example.newspaper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Trace;

import static java.lang.Thread.sleep;

public class NewsPaper extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_paper);

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(1000);
                    Intent i=new Intent(NewsPaper.this,LoginActivity.class);
                     startActivity(i);
                     finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
    }



}
