package com.example.telephone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnStar, btnHash, btnSave, btnCall;
    ImageButton btnDel;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.one);
        btn2 = findViewById(R.id.two);
        btn3 = findViewById(R.id.three);
        btn4 = findViewById(R.id.four);
        btn5 = findViewById(R.id.five);
        btn6 = findViewById(R.id.six);
        btn7 = findViewById(R.id.seven);
        btn8 = findViewById(R.id.eight);
        btn9 = findViewById(R.id.nine);
        btn0 = findViewById(R.id.zero);
        btnStar = findViewById(R.id.star);
        btnHash = findViewById(R.id.hash);
        btnSave = findViewById(R.id.save);
        btnCall = findViewById(R.id.call);
        btnDel = findViewById(R.id.del);
        text = findViewById(R.id.textView2);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btnStar.setOnClickListener(this);
        btnHash.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        btnCall.setOnClickListener(this);
        btnDel.setOnClickListener(this);
        text.setText("");
    }

    @Override
    public void onClick(View v) {
        if (v.equals(btn1)) {
            text.append("1");
        } else if (v.equals(btn2)) {
            text.append("2");
        } else if (v.equals(btn3)) {
            text.append("3");
        } else if (v.equals(btn4)) {
            text.append("4");
        } else if (v.equals(btn5)) {
            text.append("5");
        } else if (v.equals(btn6)) {
            text.append("6");
        } else if (v.equals(btn7)) {
            text.append("7");
        } else if (v.equals(btn8)) {
            text.append("8");
        } else if (v.equals(btn9)) {
            text.append("9");
        } else if (v.equals(btn0)) {
            text.append("0");
        } else if (v.equals(btnStar)) {
            text.append("*");
        } else if (v.equals(btnHash)) {
            text.append("#");
        } else if (v.equals(btnDel)) {
            String string = text.getText().toString();
            String substring = string.substring(0, string.length() - 1);
            text.setText(substring);
        } else if (v.equals(btnSave)) {
            Intent contactIntent = new Intent(ContactsContract.Intents.Insert.ACTION);
            contactIntent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
            contactIntent.putExtra(ContactsContract.Intents.Insert.NAME, "unknown");
            contactIntent.putExtra(ContactsContract.Intents.Insert.PHONE, text.getText().toString());
            startActivity(contactIntent);
        } else if (v.equals(btnCall)) {
            String data=text.getText().toString();
            Intent intent=new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:"+data));
            startActivity(intent);
        }


    }
}