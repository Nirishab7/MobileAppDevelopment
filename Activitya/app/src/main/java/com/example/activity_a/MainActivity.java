package com.example.activity_a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText Username;
    EditText Password;
    Button signup;
    String regex="^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@!#$%^&*])[A-Za-z\\d@$!]{8,}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Username=(EditText)findViewById(R.id.Text_UserName);
        Password=(EditText)findViewById(R.id.Text_Password);
        signup=(Button)findViewById(R.id.signUpBtn);
        signup.setOnClickListener(this);


    }

    public void onClick(View v){
        String username=Username.getText().toString();
        String password=Password.getText().toString();
        if(validatepassword(password)){
            Bundle bundle=new Bundle();
            bundle.putString("user",username);
            bundle.putString("passkey",password);
            Intent it=new Intent(this,MainActivity2.class);
            it.putExtra("data",bundle);
            startActivity(it);
        }
        else{
            Toast.makeText(getBaseContext(),"InvalidPassword", Toast.LENGTH_LONG).show();
        }
    }
    public boolean validatepassword(String password){
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(password);
        return matcher.matches();
    }


}