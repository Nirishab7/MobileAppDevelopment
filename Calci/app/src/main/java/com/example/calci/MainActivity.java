package com.example.calci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //java objects should be camelCase(recommended)
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnAdd, btnsub, btnmulti, btndiv, btnac, btndot, btndel, btnEqual;
    //to refactor (to change all occurences) press shift + f6 over the object
    //format ctrl + alt + -
    TextView txtresult, Txtresult2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //and no need of type casting
        btn1 = findViewById(R.id.button_1);
        btn2 = findViewById(R.id.button_2);
        btn3 = findViewById(R.id.button_3);
        btn4 = findViewById(R.id.button_4);
        btn5 = findViewById(R.id.button_5);
        btn6 = findViewById(R.id.button_6);
        btn7 = findViewById(R.id.button_7);
        btn8 = findViewById(R.id.button_8);
        btn9 = findViewById(R.id.button_9);
        btn0 = findViewById(R.id.button_0);
        btnAdd = findViewById(R.id.button_add);
        btnsub = findViewById(R.id.button_sub);
        btnmulti = findViewById(R.id.button_multi);
        btndiv = findViewById(R.id.button_div);
        btnac = findViewById(R.id.button_ac);
        btndot = findViewById(R.id.button_dot);
        btnEqual = findViewById(R.id.button_equals);
        btndel = findViewById(R.id.button_del);
        txtresult = findViewById(R.id.text_result);
        Txtresult2 = findViewById(R.id.text_result2);
        //better to separate xml linkings(findViewById) and setOnClickListeners

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
        btnAdd.setOnClickListener(this);
        btnsub.setOnClickListener(this);
        btndiv.setOnClickListener(this);
        btnmulti.setOnClickListener(this);
        btndot.setOnClickListener(this);
        btnac.setOnClickListener(this);
        btndel.setOnClickListener(this);
        btnEqual.setOnClickListener(this);

        txtresult.setText("");
    }

    @Override
    public void onClick(View v) {
        if (v.equals(btn1)) {
            txtresult.append("1");
        }
        if (v.equals(btn2)) {
            txtresult.append("2");
        }
        if (v.equals(btn3)) {
            txtresult.append("3");
        }
        if (v.equals(btn4)) {
            txtresult.append("4");
        }
        if (v.equals(btn5)) {
            txtresult.append("5");
        }
        if (v.equals(btn6)) {
            txtresult.append("6");
        }
        if (v.equals(btn7)) {
            txtresult.append("7");
        }
        if (v.equals(btn8)) {
            txtresult.append("8");
        }
        if (v.equals(btn9)) {
            txtresult.append("9");
        }
        if (v.equals(btn0)) {
            txtresult.append("0");
        }

        if (v.equals(btnEqual)) {

            String data = txtresult.getText().toString();
            if (data.contains("+")) {
                String[] operands = data.split("\\+");
                if (operands.length == 2) {
                    double operand1 = Double.parseDouble(operands[0]);
                    double operand2 = Double.parseDouble(operands[1]);
                    double result = operand1 + operand2;

                    Txtresult2.setText(String.valueOf(result));
                }

            }
            if (data.contains("-")) {
                String[] operands = data.split("\\-");
                if (operands.length == 2) {
                    double operand1 = Double.parseDouble(operands[0]);
                    double operand2 = Double.parseDouble(operands[1]);
                    double result = operand1 - operand2;

                    Txtresult2.setText(String.valueOf(result));
                }

            }
            if (data.contains("*")) {
                String[] operands = data.split("\\*");
                if (operands.length == 2) {
                    double operand1 = Double.parseDouble(operands[0]);
                    double operand2 = Double.parseDouble(operands[1]);
                    double result = operand1 * operand2;

                    Txtresult2.setText(String.valueOf(result));
                }

            }
            if (data.contains("/")) {
                String[] operands = data.split("\\/");
                if (operands.length == 2) {
                    double operand1 = Double.parseDouble(operands[0]);
                    double operand2 = Double.parseDouble(operands[1]);
                    double result = operand1 / operand2;

                    Txtresult2.setText(String.valueOf(result));
                }

            }
        }
        if (v.equals(btndel)) {
            String string = txtresult.getText().toString();
            String substring = string.substring(0, string.length() - 1);
            txtresult.setText(substring);
        }
        if (v.equals(btnAdd)) {
            txtresult.append("+");
        }
        if (v.equals(btnsub)) {
            txtresult.append("-");
        }
        if (v.equals(btnmulti)) {
            txtresult.append("*");
        }
        if (v.equals(btndiv)) {
            txtresult.append("/");
        }
        if (v.equals(btndot)) {
            txtresult.append(".");
        }
        if (v.equals(btnac)) {
            txtresult.setText("");
            Txtresult2.setText("");
        }
    }
}
//android:drawableLeft="@drawable/ic_baseline_add_24"