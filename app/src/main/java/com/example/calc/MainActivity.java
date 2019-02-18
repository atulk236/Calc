package com.example.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private enum OPERATOR {

        PLUS, SUBTRACT, MULTIPLY, DIVIDE, EQUAL

    }


    TextView ip;

    private String currentNumber;
    private String stringNumberAtLeft;
    private String stringNumberAtRight;
    private OPERATOR currentOperator;
    private int calculatiosResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentNumber = "";
        calculatiosResult = 0;

        ip = findViewById(R.id.input);
        findViewById(R.id.v1).setOnClickListener(MainActivity.this);
        findViewById(R.id.v2).setOnClickListener(MainActivity.this);
        findViewById(R.id.v3).setOnClickListener(MainActivity.this);
        findViewById(R.id.v4).setOnClickListener(MainActivity.this);
        findViewById(R.id.v5).setOnClickListener(MainActivity.this);
        findViewById(R.id.v6).setOnClickListener(MainActivity.this);
        findViewById(R.id.v7).setOnClickListener(MainActivity.this);
        findViewById(R.id.v8).setOnClickListener(MainActivity.this);
        findViewById(R.id.v9).setOnClickListener(MainActivity.this);
        findViewById(R.id.v0).setOnClickListener(MainActivity.this);
        findViewById(R.id.clear).setOnClickListener(MainActivity.this);
        findViewById(R.id.equal).setOnClickListener(MainActivity.this);
        findViewById(R.id.add).setOnClickListener(MainActivity.this);
        findViewById(R.id.sub).setOnClickListener(MainActivity.this);
        findViewById(R.id.multi).setOnClickListener(MainActivity.this);
        findViewById(R.id.div).setOnClickListener(MainActivity.this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.input:
                break;

            case R.id.v1:
                numberIsTapped(1);
                break;
            case R.id.v2:
                numberIsTapped(2);
                break;
            case R.id.v3:
                numberIsTapped(3);
                break;
            case R.id.v4:
                numberIsTapped(4);
                break;
            case R.id.v5:
                numberIsTapped(5);
                break;
            case R.id.v6:
                numberIsTapped(6);
                break;
            case R.id.v7:
                numberIsTapped(7);
                break;
            case R.id.v8:
                numberIsTapped(8);
                break;
            case R.id.v9:
                numberIsTapped(9);
                break;
            case R.id.v0:
                numberIsTapped(0);
                break;
            case R.id.add:

                operatorIsTapped(OPERATOR.PLUS);

                break;
            case R.id.sub:
                operatorIsTapped(OPERATOR.SUBTRACT);



                break;
            case R.id.div:
                operatorIsTapped(OPERATOR.DIVIDE);


                break;
            case R.id.multi:
                operatorIsTapped(OPERATOR.MULTIPLY);

                break;

            case R.id.clear:
                clearTapped();

                break;
            case R.id.equal:
                operatorIsTapped(OPERATOR.EQUAL);

                break;
        }


    }

    private void numberIsTapped(int tappedNumber) {

        currentNumber = currentNumber + String.valueOf(tappedNumber);
        ip.setText(currentNumber);



    }

    private void operatorIsTapped(OPERATOR tappedOperator) {

        if (currentOperator != null) {

            if (currentNumber != "") {


                stringNumberAtRight = currentNumber;
                currentNumber = "";

                switch (currentOperator) {


                    case PLUS:

                        calculatiosResult = Integer.parseInt(stringNumberAtLeft) +
                                Integer.parseInt(stringNumberAtRight);

                        break;

                    case SUBTRACT:

                        calculatiosResult = Integer.parseInt(stringNumberAtLeft) -
                                Integer.parseInt(stringNumberAtRight);

                        break;

                    case MULTIPLY:

                        calculatiosResult = Integer.parseInt(stringNumberAtLeft) *
                                Integer.parseInt(stringNumberAtRight);

                        break;
                    case DIVIDE:

                        calculatiosResult = Integer.parseInt(stringNumberAtLeft) /
                                Integer.parseInt(stringNumberAtRight);

                        break;


                }

                stringNumberAtLeft = String.valueOf(calculatiosResult);
                ip.setText(stringNumberAtLeft);

            }
        }

        else {

            stringNumberAtLeft = currentNumber;
            currentNumber = "";

        }

        currentOperator = tappedOperator;

    }

    private void clearTapped() {


        stringNumberAtLeft = "";
        stringNumberAtRight = "";
        calculatiosResult = 0;
        currentNumber = "";
        currentOperator = null;
        ip.setText("0");

    }

}
