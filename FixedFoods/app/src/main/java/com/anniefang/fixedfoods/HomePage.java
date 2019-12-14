package com.anniefang.fixedfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }

    public void goToPreferences(View view) {
        Intent intent = new Intent(getApplicationContext(), PreferencesPage.class);
        startActivity(intent);
    }

    public void goToScanningInterface(View view) {
        Intent intent = new Intent(getApplicationContext(), ScanningInterface.class);
        startActivity(intent);
    }

    public void goToPastScans(View view) {
        Intent intent = new Intent(getApplicationContext(), SearchNow.class);
        startActivity(intent);
    }
}
