package com.cmsc434.fixedfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ScanningInterface extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanning_interface);
    }

    public void goToHomePage(View view) {
        Intent intent = new Intent(getApplicationContext(), HomePage.class);
        startActivity(intent);
    }
}