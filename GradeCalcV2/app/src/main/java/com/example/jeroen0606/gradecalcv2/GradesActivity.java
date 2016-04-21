package com.example.jeroen0606.gradecalcv2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class GradesActivity extends AppCompatActivity {

    int formula = 1;
    String totalAmount = "";
    TextView tvNumberLeft;
    TextView tvNumberRight;
    TextView tvGradeLeft;
    TextView tvGradeRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades);

        tvNumberLeft = (TextView) findViewById(R.id.tvNumberLeft);
        tvNumberRight = (TextView) findViewById(R.id.tvNumberRight);
        tvGradeLeft = (TextView) findViewById(R.id.tvGradeLeft);
        tvGradeRight = (TextView) findViewById(R.id.tvGradeRight);

        SharedPreferences preferenceSettings = getSharedPreferences("preferences", MODE_PRIVATE);
        totalAmount = preferenceSettings.getString("totalAmount", "10");

        for(int x = 0; x <= Integer.parseInt(totalAmount); x++) {
            if(x < (Integer.parseInt(totalAmount)/2)) {
                tvNumberLeft.append(x + "\n");
                tvGradeLeft.append("|| " + (calculateGrade((double) x, formula) / 10) + "\n");
            }
            else {
                tvNumberRight.append(x + "\n");
                tvGradeRight.append("|| " + (calculateGrade((double) x, formula) / 10) + "\n");
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_grades, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.close:
                Intent settingsActivity = new Intent(this, CalculatorActivity.class);
                startActivity(settingsActivity);
                return true;
            default:
                return super.onOptionsItemSelected(item);
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
