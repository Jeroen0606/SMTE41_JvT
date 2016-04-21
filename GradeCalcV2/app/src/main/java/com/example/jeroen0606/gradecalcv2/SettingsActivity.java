package com.example.jeroen0606.gradecalcv2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;

public class SettingsActivity extends AppCompatActivity {

    private RadioButton rbtn1;
    private RadioButton rbtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        rbtn1 = (RadioButton) findViewById(R.id.radioButton1);
        rbtn2 = (RadioButton) findViewById(R.id.radioButton2);

        SharedPreferences preferenceSettings = getSharedPreferences("preferences",MODE_PRIVATE);

        if(preferenceSettings.getInt("formula", 0) == 1) {
            rbtn1.setChecked(true);
        }
        if(preferenceSettings.getInt("formula", 0) == 2) {
            rbtn2.setChecked(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_settings, menu);
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
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void saveFormula(View view) {
        int formula = 0;
        if(rbtn1.isChecked()) {
            formula = 1;
        }
        if(rbtn2.isChecked()) {
            formula = 2;
        }

        SharedPreferences preferenceSettings = getSharedPreferences("preferences", MODE_PRIVATE);
        SharedPreferences.Editor preferenceEditor = preferenceSettings.edit();

        preferenceEditor.putInt("formula", formula);
        preferenceEditor.commit();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
