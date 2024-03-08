package com.example.calculator;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class MainActivity extends AppCompatActivity {

    Button oneBtn,twoBtn,threeBtn,fourBtn,fiveBtn,sixBtn,sevenBtn,eightBtn,nineBtn,
            zeroBtn,equalBtn,plusBtn,minusBtn,multiplyBtn,divideBtn,delBtn,acBtn,dotBtn;
    TextView calculationField,realField;

    String data="";
    String output="";
    //    double[] calculate=new double[3];
    BigDecimal[] calculate = new BigDecimal[3];

    Switch modeChangeBtn;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oneBtn=findViewById(R.id.one_btn);
        twoBtn=findViewById(R.id.two_btn);
        threeBtn=findViewById(R.id.three_btn);
        fourBtn=findViewById(R.id.four_btn);
        fiveBtn=findViewById(R.id.five_btn);
        sixBtn=findViewById(R.id.six_btn);
        sevenBtn=findViewById(R.id.seven_btn);
        eightBtn=findViewById(R.id.eight_btn);
        nineBtn=findViewById(R.id.nine_btn);
        zeroBtn=findViewById(R.id.zero_btn);

        equalBtn=findViewById(R.id.equal_btn);
        plusBtn=findViewById(R.id.plus_btn);
        minusBtn=findViewById(R.id.minus_btn);
        multiplyBtn=findViewById(R.id.multiply_btn);
        divideBtn=findViewById(R.id.divide_btn);
        delBtn=findViewById(R.id.del_btn);
        acBtn=findViewById(R.id.all_Clear_btn);
        dotBtn=findViewById(R.id.dot_btn);

        calculationField=findViewById(R.id.calculation_field);
        realField=findViewById(R.id.real_field);

        modeChangeBtn=findViewById(R.id.switch1);

//                Save changes

        sharedPreferences=getSharedPreferences("night",0);
        boolean nightMode=sharedPreferences.getBoolean("nightMode",false);

        if (nightMode){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            modeChangeBtn.setChecked(true);
        }else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            modeChangeBtn.setChecked(false);
        }
        modeChangeBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putBoolean("nightMode",true);
                    editor.apply();
                }else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putBoolean("nightMode",false);
                    editor.apply();
                }
            }
        });
        oneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data+="1";
                calculationField.setText(data);
            }
        });

        twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data+="2";
                calculationField.setText(data);
            }
        });
        threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data+="3";
                calculationField.setText(data);
            }
        });
        fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data+="4";
                calculationField.setText(data);
            }
        });
        fiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data+="5";
                calculationField.setText(data);
            }
        });
        sixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data+="6";
                calculationField.setText(data);
            }
        });
        sevenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data+="7";
                calculationField.setText(data);
            }
        });
        eightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data+="8";
                calculationField.setText(data);
            }
        });
        nineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data+="9";
                calculationField.setText(data);
            }
        });
        zeroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data+="0";
                calculationField.setText(data);
            }
        });
        acBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data="";
                output="";
                realField.setText(output);
                calculationField.setText(data);
            }
        });
        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=data.substring(0,data.length()-1);
                calculationField.setText(data);
            }
        });
        divideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data+="/";
                calculationField.setText(data);
            }
        });
        multiplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data+="x";
                calculationField.setText(data);
            }
        });
        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data+="-";
                calculationField.setText(data);
            }
        });
        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data+="+";
                calculationField.setText(data);
            }
        });
        dotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data+=".";
                calculationField.setText(data);
            }
        });
        equalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (data.contains("+")){
                    String[] parts=data.split("\\+",2);
                    calculate[0]=new BigDecimal(parts[0]);
                    calculate[1]=new BigDecimal(parts[1]);
                    calculate[2]=calculate[0].add(calculate[1]);
                    output=String.valueOf(calculate[2]);
                    realField.setText(output);
                    data=output;
                } else if (data.contains("-")) {
                    String[] parts=data.split("\\-",2);
                    calculate[0]=new BigDecimal(parts[0]);
                    calculate[1]=new BigDecimal(parts[1]);
                    calculate[2]=calculate[0].subtract(calculate[1]);
                    output=String.valueOf(calculate[2]);
                    realField.setText(output);
                    data=output;
                } else if (data.contains("x")) {
                    String[] parts=data.split("x",2);
                    calculate[0]=new BigDecimal(parts[0]);
                    calculate[1]=new BigDecimal(parts[1]);
                    calculate[2]=calculate[0].multiply(calculate[1]);
                    output=String.valueOf(calculate[2]);
                    realField.setText(output);
                    data=output;
                } else if (data.contains("/")) {
                    String[] parts=data.split("\\/",2);
                    calculate[0]=new BigDecimal(parts[0]);
                    calculate[1]=new BigDecimal(parts[1]);
                    calculate[2]=calculate[0].divide(calculate[1], 10, RoundingMode.HALF_UP);
                    output=String.valueOf(calculate[2]);
                    realField.setText(output);
                    data=output;
                }
            }
        });

    }
}