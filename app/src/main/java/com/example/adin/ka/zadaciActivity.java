package com.example.adin.ka;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class zadaciActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zadaci);
    }

    public void rjesenje1(View v) {
        findViewById(R.id.rjesenje1).setVisibility(View.VISIBLE);
        findViewById(R.id.button1).setVisibility(View.GONE);

    }

    public void rjesenje2(View v) {
        findViewById(R.id.rjesenje2).setVisibility(View.VISIBLE);
        findViewById(R.id.button2).setVisibility(View.GONE);

    }

    public void rjesenje3(View v) {
        findViewById(R.id.rjesenje3).setVisibility(View.VISIBLE);
        findViewById(R.id.button3).setVisibility(View.GONE);

    }

    public void rjesenje4(View v) {
        findViewById(R.id.rjesenje4).setVisibility(View.VISIBLE);
        findViewById(R.id.button4).setVisibility(View.GONE);

    }

    public void rjesenje5(View v) {
        findViewById(R.id.rjesenje5).setVisibility(View.VISIBLE);
        findViewById(R.id.button5).setVisibility(View.GONE);

    }
}