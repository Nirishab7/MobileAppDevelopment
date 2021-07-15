package com.example.xml_json;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
     Button xml,json;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xml=findViewById(R.id.xmlBtn);
        json=findViewById(R.id.jsonBtn);
        xml.setOnClickListener(this);
        json.setOnClickListener(this);
    }
    public void onClick(View v){
        if(v.equals(json)){
            Intent it=new Intent(this,MainActivity2.class);
            it.putExtra("mode",1);
            startActivity(it);
        }
        else if(v.equals(xml)){
            Intent it=new Intent(this,MainActivity2.class);
            it.putExtra("mode",2);
            startActivity(it);
        }
    }
}