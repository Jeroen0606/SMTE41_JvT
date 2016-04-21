package com.example.jeroen0606.gradecalcv2;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {
    private String totalAmount = "";
    private String number = "";
    private String temp = "";
    private int total = 0;
    private int tempTotal = 0;
    private int formula = 1;
    private TextView textView;
    private TextView textViewGrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        SharedPreferences preferenceSettings = getSharedPreferences("preferences", MODE_PRIVATE);

        totalAmount = preferenceSettings.getString("totalAmount", "10");
        textView =(TextView)findViewById(R.id.textView);
        textViewGrade =(TextView)findViewById(R.id.textViewGrade);

        SharedPreferences.Editor preferenceEditor = preferenceSettings.edit();

        formula = preferenceSettings.getInt("formula", 0);

        if(formula == 0) {
            preferenceEditor.putInt("formula", 1);
            preferenceEditor.commit();
        }

        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(number != "" || tempTotal != 0) {
                    if((calculateGrade((double) total, formula) < 1000)) {
                        textViewGrade.setText((calculateGrade((double) total, formula) / 10) + "");
                    }
                }
                else {
                    textViewGrade.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.close:
                Intent settingsActivity = new Intent(this, MainActivity.class);
                startActivity(settingsActivity);
                return true;
            case R.id.list:
                Intent gradesActivity = new Intent(this, GradesActivity.class);
                startActivity(gradesActivity);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void click1(View view) {
        if(number.length() < 6) {
            number += "1";
        }
        controlTextView();
    }
    public void click2(View view) {
        if(number.length() < 6) {
            number += "2";
        }
        controlTextView();
    }
    public void click3(View view) {
        if(number.length() < 6) {
            number += "3";
        }
        controlTextView();
    }
    public void click4(View view) {
        if(number.length() < 6) {
            number += "4";
        }
        controlTextView();
    }
    public void click5(View view) {
        if(number.length() < 6) {
            number += "5";
        }
        controlTextView();
    }
    public void click6(View view) {
        if(number.length() < 6) {
            number += "6";
        }
        controlTextView();
    }
    public void click7(View view) {
        if(number.length() < 6) {
            number += "7";
        }
        controlTextView();
    }
    public void click8(View view) {
        if(number.length() < 6) {
            number += "8";
        }
        controlTextView();
    }
    public void click9(View view) {
        if(number.length() < 6) {
            number += "9";
        }
        controlTextView();
    }
    public void click0(View view) {
        if(number.length() < 6) {
            number += "0";
        }
        controlTextView();
    }
    public void clickC(View view) {
        if(number == "") {
            temp = "";
            tempTotal = 0;
            textView.setText("");
        }
        else {
            number = "";
            total = tempTotal;
            textView.setText(Integer.toString(tempTotal) + "(+)");
        }

    }
    public void clickAdd(View view) {
        if(number != "") {
            temp = number;
            tempTotal = total;
            textView.setText(total + "+");
            number = "";
        }
        else {

        }
    }

    public void controlTextView() {
        if(tempTotal + Integer.parseInt(number) > 999){
            //Do Nothing
        }
        else {
            if (temp == "") {
                total = Integer.parseInt(number);
                textView.setText(number);
            } else {
                total = tempTotal + Integer.parseInt(number);
                textView.setText(tempTotal + "+" + number + "=" + total);
            }
        }
    }

    public double calculateGrade(double points, int formula) {
        switch (formula) {
            case 1:
                return Math.round(((points / Integer.parseInt(totalAmount) * 9) + 1) * 10);
            case 2:
                return Math.round((points / Integer.parseInt(totalAmount) * 10) * 10);
        }
        return 0;
    }
}
