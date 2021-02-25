package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.ui.BaseActivity;

import static com.example.myapplication.LocaleManager.LANGUAGE_ENGLISH;
import static com.example.myapplication.LocaleManager.LANGUAGE_RUSSIAN;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    Button btnEnglish, btnRussian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews(){
        btnEnglish = findViewById(R.id.btnEnglish);
        btnRussian = findViewById(R.id.btnRussian);

        btnEnglish.setOnClickListener(this);
        btnRussian.setOnClickListener(this);
    }

    private void setNewLocale(String language, boolean restartProcess) {
        App.localeManager.setNewLocale(this, language);

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));

        if (restartProcess) {
            System.exit(0);
        } else {
            Toast.makeText(this, "Activity restarted", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnEnglish) {
            setNewLocale(LANGUAGE_ENGLISH, false);

        } else if (id == R.id.btnRussian) {
            setNewLocale(LANGUAGE_RUSSIAN, false);
        }
    }
}