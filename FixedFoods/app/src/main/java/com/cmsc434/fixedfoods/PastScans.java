package com.cmsc434.fixedfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class PastScans extends AppCompatActivity {

    ListView past_scans_list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_scans);

        past_scans_list = (ListView) findViewById(R.id.past_scans_list);
        ArrayList<String> arrayItems = new ArrayList<>();
        arrayItems.addAll(Arrays.asList(getResources().getStringArray(R.array.past_scans)));

        adapter = new ArrayAdapter<String>(PastScans.this, android.R.layout.simple_list_item_1, arrayItems);

        past_scans_list.setAdapter(adapter);
    }

    public void goToHomePage(View view) {
        Intent intent = new Intent(getApplicationContext(), HomePage.class);
        startActivity(intent);
    }
}
