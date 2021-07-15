package com.example.texttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1;
    EditText txt;
    TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=findViewById(R.id.Text);
        b1=findViewById(R.id.button);
        b1.setOnClickListener(this);
        textToSpeech=new TextToSpeech(getBaseContext(),new TextToSpeech.OnInitListener(){
            @Override
            public void onInit(int status){
                if(status!=TextToSpeech.ERROR){
                    Toast.makeText(getBaseContext(),"success",Toast.LENGTH_LONG).show();
                }
            }
        });
        textToSpeech.setLanguage(Locale.UK);
    }
    @Override
    public void onClick(View view) {
        String text=txt.getText().toString();
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH,null,"id");
    }


}