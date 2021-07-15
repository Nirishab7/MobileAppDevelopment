package com.example.activity_a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    EditText login_Username;
    EditText login_Password;
    Button login;
    String user,pass;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        login_Username=(EditText)findViewById(R.id.logIn_UserName);
        login_Password=(EditText)findViewById(R.id.logIn_Password);
        login=(Button)findViewById(R.id.logInBtn);
        login.setOnClickListener(this);
        Bundle bundle=getIntent().getBundleExtra("data");
        user=bundle.getString("user");
        pass=bundle.getString("passkey");

    }
    public void onClick(View v)
    {
        String user1=login_Username.getText().toString();
        String pass1=login_Password.getText().toString();
        if(user.equals(user1)&& pass.equals(pass1))
        {
            Toast.makeText(this,"login successful",Toast.LENGTH_LONG).show();
        }
        else
        {
            count++;
            if(count==3) {
                login.setEnabled(false);
                Toast.makeText(this, "failed login attempts", Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(this,"login failed"+count,Toast.LENGTH_LONG).show();

            }
        }
    }
}