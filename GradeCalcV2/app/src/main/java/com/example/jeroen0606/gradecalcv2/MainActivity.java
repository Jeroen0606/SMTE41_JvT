package com.example.jeroen0606.gradecalcv2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String number = "";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView =(TextView)findViewById(R.id.textView);
    }

    public void nextActivity(View view) {
        if(!(number.equals("")  || number.equals("0"))) {
            SharedPreferences preferenceSettings = getSharedPreferences("preferences", MODE_PRIVATE);
            SharedPreferences.Editor preferenceEditor = preferenceSettings.edit();

            preferenceEditor.putString("totalAmount", number);
            preferenceEditor.commit();
            Intent calculatorActivity = new Intent(this, CalculatorActivity.class);
            startActivity(calculatorActivity);
        }
        else {
            textView.setText("ERROR");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.settings:
                Intent settingsActivity = new Intent(this, SettingsActivity.class);
                startActivity(settingsActivity);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void click1(View view) {
        if(number.length() < 6) {
            number += "1";
        }
        textView.setText(number);
    }
    public void click2(View view) {
        if(number.length() < 6) {
            number += "2";
        }
        textView.setText(number);
    }
    public void click3(View view) {
        if(number.length() < 6) {
            number += "3";
        }
        textView.setText(number);
    }
    public void click4(View view) {
        if(number.length() < 6) {
            number += "4";
        }
        textView.setText(number);
    }
    public void click5(View view) {
        if(number.length() < 6) {
            number += "5";
        }
        textView.setText(number);
    }
    public void click6(View view) {
        if(number.length() < 6) {
            number += "6";
        }
        textView.setText(number);
    }
    public void click7(View view) {
        if(number.length() < 6) {
            number += "7";
        }
        textView.setText(number);
    }
    public void click8(View view) {
        if(number.length() < 6) {
            number += "8";
        }
        textView.setText(number);
    }
    public void click9(View view) {
        if(number.length() < 6) {
            number += "9";
        }
        textView.setText(number);
    }
    public void click0(View view) {
        if(number.length() < 6) {
            number += "0";
        }
        textView.setText(number);
    }
    public void clickC(View view) {
        number="";
        textView.setText(number);
    }
}
