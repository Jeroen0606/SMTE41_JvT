package com.example.jeroen0606.gradecalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final EditText et = (EditText) findViewById(R.id.editText);
        final TextView t1 = (TextView) findViewById(R.id.tv1);
        final TextView t2 = (TextView) findViewById(R.id.tv2);
        final TextView t3 = (TextView) findViewById(R.id.tv3);


        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String temp = "";
                int totaal = 0;
                if (!et.getText().toString().equals("")) {
                    if(et.getText().length() < 4) {
                        totaal = Integer.parseInt(et.getText().toString());
                        for (int x = 0; x <= totaal; x++) {
                            double cijfer = Math.round(calcCijfer(x, totaal) * 10);
                            cijfer = cijfer / 10;
                            if (x < 10) {
                                temp += x + "   || " + cijfer + "\n";
                            } else {
                                temp += x + " || " + cijfer + "\n";
                            }
                            if (x == (totaal / 3)) {
                                t1.setText(temp);
                                temp = "";
                            }
                            if (x == (totaal / 3) * 2) {
                                t2.setText(temp);
                                temp = "";
                            }
                        }
                        t3.setText(temp);
                    }
                }
                else {
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public double calcCijfer(double x, double totaal) {
        return ((x/totaal) * 9) + 1;
    }
}
