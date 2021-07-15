package com.example.vtu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.button);
        b1.setOnClickListener(this);
    }
    @Override

        public void onClick(View v) {
            Uri uri=Uri.parse("https://vtu.ac.in/");
            Intent it=new Intent(Intent.ACTION_VIEW,uri);
            startActivity(it);
        }
    }
