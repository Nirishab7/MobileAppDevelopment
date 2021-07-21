package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class StartPage extends AppCompatActivity implements View.OnClickListener {
    Button Start;
    EditText player1,player2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        player1=findViewById(R.id.Player1);
        player2=findViewById(R.id.Player2);
        Start=findViewById(R.id.buttonStart);
        Start.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        String firstPlayer=player1.getText().toString();
        String secondPlayer=player2.getText().toString();
        Intent it=new Intent(this,MainActivity.class);
        Bundle bundle=new Bundle();
        bundle.putString("Player1", String.valueOf(firstPlayer));
        bundle.putString("Player2", String.valueOf(secondPlayer));
        it.putExtra("PlayerList",bundle);
        startActivity(it);
    }
}