package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreBoard extends AppCompatActivity implements View.OnClickListener {
    Button btnBack;
    TextView xWin,oWin,draw,match;
    String x,o,Draw,matches;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);
        btnBack=findViewById(R.id.buttonBack);
        match=findViewById(R.id.MatchView);
        xWin=findViewById(R.id.Xmatch);
        oWin=findViewById(R.id.Omatch);
        draw=findViewById(R.id.drawMatch);
        btnBack.setOnClickListener(this);
        Bundle bundle=getIntent().getBundleExtra("data");
        matches=bundle.getString("Match");
        x=bundle.getString("Xwin");
        o=bundle.getString("Owin");
        Draw=bundle.getString("draw");
        match.setText("Matches Played: "+matches);
        xWin.setText(x);
        oWin.setText(o);
        draw.setText(Draw);
    }


    public void onClick(View v)
    {
        Intent it=new Intent(this,MainActivity.class);
        startActivity(it);
    }

}