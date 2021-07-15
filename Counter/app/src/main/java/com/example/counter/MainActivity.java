package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button startBtn, stopBtn,clrBtn;
    EditText lCounter;
    int counter = 0;
    boolean running = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lCounter = findViewById(R.id.counterView);
        startBtn = findViewById(R.id.start);
        stopBtn = findViewById(R.id.stop);
        clrBtn=findViewById(R.id.clr);
        clrBtn.setOnClickListener(this);
        startBtn.setOnClickListener(this);
        stopBtn.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.equals(startBtn)) {
            running = true;
            new MyCounter().start();
        } else if (v.equals(stopBtn)) {
            running = false;
        }
        else if(v.equals(clrBtn)){
            lCounter.setText(" ");
            counter=0;
        }
    }

    Handler handler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message m) {
            lCounter.setText(String.valueOf(m.what));
        }
    };

    class MyCounter extends Thread {
        public void run(){
            while(running){
                counter++;
                handler.sendEmptyMessage(counter);
                try{
                    Thread.sleep(1000);
                }
                catch (Exception e){

                }
            }
        }

    }
}

