package com.example.adin.ka;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class teorijaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teorija);
    }

    public void otvoriUvod(View v) {
        Intent i = new Intent(this, uvodActivity.class);
        startActivity(i);
    }
}