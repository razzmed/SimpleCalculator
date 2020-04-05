package com.example.simplecalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView result;
    Double firstValues, secondValues, result_op;
    String operation;
    Double num1;
    Double num2;
    String oper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result_field);
        if (savedInstanceState != null){
            num1 = savedInstanceState.getDouble("num1");
            num2 = savedInstanceState.getDouble("num2");
            oper = savedInstanceState.getString("oper");
            firstValues = num1;
            secondValues = num2;
            operation = oper;
        }
        Log.d("scalc", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("scalc", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("scalc", "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("scalc", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("scalc", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("scalc", "onDestroy");
    }

    public void onNumberClick(View view) {

        switch (view.getId()) {
            case R.id.seven:
                result.append("7");
                break;
            case R.id.eight:
                result.append("8");
                break;
            case R.id.nine:
                result.append("9");
                break;
            case R.id.four:
                result.append("4");
                break;
            case R.id.five:
                result.append("5");
                break;
            case R.id.six:
                result.append("6");
                break;
            case R.id.one:
                result.append("1");
                break;
            case R.id.two:
                result.append("2");
                break;
            case R.id.three:
                result.append("3");
                break;
            case R.id.zero:
                result.append("0");
                break;
            case R.id.clear:
                result.setText("");
                break;
            case R.id.dot:
                String string = (result.getText().toString().trim());
                if (string.length() > 0) {
                    result.setText(string + ".");
                    break;
                }
        }
    }

    public void onOperationClick(View view) {
        switch (view.getId()) {
            case R.id.plus:
                firstValues = Double.valueOf(result.getText().toString());
                result.setText(firstValues + "+");
                operation = "+";
                break;
            case R.id.division:
                firstValues = Double.valueOf(result.getText().toString());
                result.setText(firstValues + "/");
                operation = "/";
                break;
            case R.id.minus:
                firstValues = Double.valueOf(result.getText().toString());
                result.setText(firstValues + "-");
                operation = "-";
                break;
            case R.id.multiplication:
                firstValues = Double.valueOf(result.getText().toString());
                result.setText(firstValues + "*");
                operation = "*";
                break;
            case R.id.equally:
                if (operation != null) {
                    String two = result.getText().toString().replace(firstValues.toString() + operation, "");
                    secondValues = Double.valueOf(two);
                    switch (operation) {
                        case "+":
                            plusOperation();
                            break;
                        case "/":
                            divisionOperation();
                            break;
                        case "-":
                            minusOperation();
                            break;
                        case "*":
                            multiplicationOperation();
                            break;
                    }
                }

        }
    }

    public void plusOperation() {
        result_op = firstValues + secondValues;
        result.setText(result_op.toString());
    }

    public void divisionOperation() {
        result_op = firstValues / secondValues;
        result.setText(result_op.toString());

    }

    public void minusOperation() {
        result_op = firstValues - secondValues;
        result.setText(result_op.toString());
    }

    public void multiplicationOperation() {
        result_op = firstValues * secondValues;
        result.setText(result_op.toString());
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (firstValues != null){
            outState.putDouble("num1", firstValues);
            }
        if (secondValues != null){
           outState.putDouble("num2", secondValues);

        }
        if (operation != null){
           outState.putString("oper", operation);
        }

    }
}