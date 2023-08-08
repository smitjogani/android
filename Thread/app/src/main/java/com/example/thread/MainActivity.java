package com.example.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar mProgressBar;
    private Button mStartBtn;
    private Thread mThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressBar = findViewById(R.id.progressBarThread);
        mStartBtn = findViewById(R.id.btn);

        mStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startProgress(view);
            }
        });
    }

    public void startProgress(View view){
        mProgressBar.setProgress(0);
        mThread = new Thread(){
            @Override
            public void run(){
                for(int i = 0; i <= 10; i++){
                    final int value = i;

                    try{
                        Thread.sleep(10);
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                    mProgressBar.setProgress(value);
                }
                stopThread(this);
            }
        };
        mThread.start();
    }

    private synchronized void stopThread(Thread theThread){
        if(theThread != null){
            theThread = null;
        }
    }
}