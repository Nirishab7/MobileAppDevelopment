package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText PriAmt, DownPay, IntRate, LoanTerm;
    Button Calculator;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PriAmt=(EditText)findViewById(R.id.PAmt);
        DownPay=(EditText)findViewById(R.id.DpAmt);
        IntRate=(EditText)findViewById(R.id.IRate);
        LoanTerm=(EditText)findViewById(R.id.LoTerm);
        result=findViewById(R.id.EMI);
        Calculator=(Button)findViewById(R.id.button);
        Calculator.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        DecimalFormat df=new DecimalFormat("#.00");
        double Principal = Double.parseDouble(PriAmt.getText().toString());
        double DownPayment = Double.parseDouble(DownPay.getText().toString());
        double Rate = Double.parseDouble(IntRate.getText().toString());
        Rate=Rate/(12*100);
        double Term = Double.parseDouble(LoanTerm.getText().toString());
        double x=Math.pow(1+Rate,Term);
        Principal=Principal-DownPayment;
        double EMI=new Double(df.format(Principal*(Rate*x)/(x-1)));


        result.setText(String.valueOf(EMI));

    }

}