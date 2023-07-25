package com.sample.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sample.calculator.logic.Logic;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView c, opnbrc, clsbrc, div, mul, sub, add, exp, eql, dot;
    TextView zero, one, two, three, four, five, six ,seven, eight, nine;
    TextView input, result;
    ImageView del;
    static Logic l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        l=new Logic();

        del=findViewById(R.id.del);

        c=findViewById(R.id.C);
        opnbrc=findViewById(R.id.opnBrc);
        clsbrc=findViewById(R.id.clsBrc);
        div=findViewById(R.id.div);
        mul=findViewById(R.id.mul);
        sub=findViewById(R.id.sub);
        add=findViewById(R.id.add);
        exp=findViewById(R.id.exp);
        eql=findViewById(R.id.eql);
        dot=findViewById(R.id.dot);

        zero=findViewById(R.id.zero);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);
        five=findViewById(R.id.five);
        six=findViewById(R.id.six);
        seven=findViewById(R.id.seven);
        eight=findViewById(R.id.eight);
        nine=findViewById(R.id.nine);

        input=findViewById(R.id.input);
        result=findViewById(R.id.result);

        del.setOnClickListener(this);

        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);

        c.setOnClickListener(this);
        opnbrc.setOnClickListener(this);
        clsbrc.setOnClickListener(this);
        div.setOnClickListener(this);
        mul.setOnClickListener(this);
        sub.setOnClickListener(this);
        add.setOnClickListener(this);
        exp.setOnClickListener(this);
        eql.setOnClickListener(this);
        dot.setOnClickListener(this);

        c.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
                return false;
            }
        });

        eql.setOnTouchListener(new View.OnTouchListener() {
            GestureDetector gestureDetector=new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener(){

                @Override
                public void onLongPress(MotionEvent e) {
                    startActivity(new Intent(getApplicationContext(), About.class));
                    super.onLongPress(e);
                }

                @Override
                public boolean onDoubleTap(MotionEvent e) {
                    if(!result.getText().toString().equalsIgnoreCase("") && !result.getText().toString().equalsIgnoreCase("Syntax Error"))
                        input.setText(result.getText().toString());

                    return super.onDoubleTap(e);
                }
            });

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                gestureDetector.onTouchEvent(motionEvent);
                return false;
            }
        });

    }

    @Override
    public void onClick(View v) {

        String get, set="";

        switch (v.getId())
        {
            case R.id.zero :
                get=input.getText().toString();
                set=get.concat("0");
                input.setText(set);
                break;

            case R.id.one :
                get=input.getText().toString();
                set=get.concat("1");
                input.setText(set);
                break;

            case R.id.two :
                get=input.getText().toString();
                set=get.concat("2");
                input.setText(set);
                break;

            case R.id.three :
                get=input.getText().toString();
                set=get.concat("3");
                input.setText(set);
                break;

            case R.id.four :
                get=input.getText().toString();
                set=get.concat("4");
                input.setText(set);
                break;

            case R.id.five :
                get=input.getText().toString();
                set=get.concat("5");
                input.setText(set);
                break;

            case R.id.six :
                get=input.getText().toString();
                set=get.concat("6");
                input.setText(set);
                break;

            case R.id.seven :
                get=input.getText().toString();
                set=get.concat("7");
                input.setText(set);
                break;

            case R.id.eight :
                get=input.getText().toString();
                set=get.concat("8");
                input.setText(set);
                break;

            case R.id.nine :
                get=input.getText().toString();
                set=get.concat("9");
                input.setText(set);
                break;

            case R.id.opnBrc :
                get=input.getText().toString();
                set=get.concat("(");
                input.setText(set);
                break;

            case R.id.clsBrc :
                get=input.getText().toString();
                set=get.concat(")");
                input.setText(set);
                break;

            case R.id.div :
                get=input.getText().toString();
                set=get.concat("÷");
                input.setText(set);
                break;

            case R.id.mul :
                get=input.getText().toString();
                set=get.concat("×");
                input.setText(set);
                break;

            case R.id.sub :
                get=input.getText().toString();
                set=get.concat("-");
                input.setText(set);
                break;

            case R.id.add :
                get=input.getText().toString();
                set=get.concat("+");
                input.setText(set);
                break;

            case R.id.exp :
                get=input.getText().toString();
                set=get.concat("^");
                input.setText(set);
                break;

            case R.id.dot :
                get=input.getText().toString();
                set=get.concat(".");
                input.setText(set);
                break;

            case R.id.del :
                get=input.getText().toString();
                if(get.length()==0)
                    Toast.makeText(this, "Input is empty", Toast.LENGTH_SHORT).show();
                else
                    set=get.substring(0,get.length()-1);
                input.setText(set);
                break;

            case R.id.C :
                set="";
                input.setText(set);
                result.setText(set);
                break;

            case R.id.eql :
                get=input.getText().toString();
                if(get.length()==0) {
                    Toast.makeText(this, "Input is empty", Toast.LENGTH_SHORT).show();
                    break;
                }
                l.setter(get);
                l.run();
                set=l.getter();
                result.setText(set);
                break;
        }

    }
}