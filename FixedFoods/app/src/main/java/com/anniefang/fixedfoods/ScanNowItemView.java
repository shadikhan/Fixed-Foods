package com.anniefang.fixedfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ScanNowItemView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_now_item_view);
    }


    public void goToScanningInterface(View view) {
        Intent intent = new Intent(getApplicationContext(), ScanningInterface.class);
        startActivity(intent);
    }
}
