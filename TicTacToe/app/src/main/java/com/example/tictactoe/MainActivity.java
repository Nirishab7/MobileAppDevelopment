package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    boolean gameActive = true;

    // Player representation
    // 0 - X
    // 1 - O
    int activePlayer = 0;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int Match=1;
    int xWin=0,oWin=0,draw=0;
    // State meanings:
    // 0 - X
    // 1 - O
    // 2 - Null
    // put all win positions in a 2D array
    int[][] winPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}};
    public static int counter = 0;
    Button btnEnd;
    String p1,p2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnEnd=findViewById(R.id.buttonEnd);
        btnEnd.setOnClickListener(this);
        Bundle bundle=getIntent().getBundleExtra("PlayerList");
        p1=bundle.getString("Player1");
        p2=bundle.getString("Player2");
    }
    // this function will be called every time a
    // players tap in an empty box of the grid
    public void playerTap(View view) {
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        TextView matchView = findViewById(R.id.MatchView);
        matchView.setText("Match: "+String.valueOf(Match));
        // game reset function will be called
        // if someone wins or the boxes are full
        if (!gameActive) {
            gameReset(view);
        }
        // if the tapped image is empty
        if (gameState[tappedImage] == 2) {
            // increase the counter
            // after every tap
            counter++;
            // check if its the last box

                // mark this position
                gameState[tappedImage] = activePlayer;

                // this will give a motion
                // effect to the image
                img.setTranslationY(-1000f);

                // change the active player
                // from 0 to 1 or 1 to 0
                if (activePlayer == 0) {
                    // set the image of x
                    img.setImageResource(R.drawable.x);
                    activePlayer = 1;
                    TextView status = findViewById(R.id.status);

                    // change the status
                    status.setText(p2+" (O)Turn");
                } else {
                    // set the image of o
                    img.setImageResource(R.drawable.o);
                    activePlayer = 0;
                    TextView status = findViewById(R.id.status);

                    // change the status
                    status.setText(p1+" (X)Turn");
                }
                img.animate().translationYBy(1000f).setDuration(300);

            if (counter == 9) {

                gameActive = false;
            }
    }
        int flag = 0;
        // Check if any player has won
        for (int[] winPosition : winPositions) {
            if (gameState[winPosition[0]] == gameState[winPosition[1]] &&
                    gameState[winPosition[1]] == gameState[winPosition[2]] &&
                    gameState[winPosition[0]] != 2) {
                flag = 1;

                // Somebody has won! - Find out who!
                String winnerStr;

                // game reset function be called
                gameActive = false;
                if (gameState[winPosition[0]] == 0) {
                    winnerStr = p1+" has won";
                    xWin+=1;
                } else {
                    winnerStr = p2+" has won";
                    oWin+=1;
                }
                // Update the status bar for winner announcement
                TextView status = findViewById(R.id.status);
                status.setText(winnerStr);

            }
        }
        // set the status if the match draw
        if (counter == 9 && flag == 0) {
            TextView status = findViewById(R.id.status);
            status.setText("Match Draw");
            draw+=1;
        }
    }



    // reset the game
    public void gameReset(View view) {
        gameActive = true;
        Match+=1;
        TextView matchView = findViewById(R.id.MatchView);
        matchView.setText("Match: "+String.valueOf(Match));
        activePlayer = 0;
        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;
        }
        counter=0;
        // remove all the images from the boxes inside the grid
        ((ImageView) findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("X's Turn - Tap to play");
    }

    public void onClick(View v){
            counter=0;
            Bundle bundle=new Bundle();
            bundle.putString("Match", String.valueOf(Match));
            bundle.putString("Xwin", String.valueOf(xWin));
            bundle.putString("Owin", String.valueOf(oWin));
            bundle.putString("draw", String.valueOf(draw));
            Intent it=new Intent(this,ScoreBoard.class);
            it.putExtra("data",bundle);
            startActivity(it);

    }


}
