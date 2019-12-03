package com.anniefang.fixedfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class PreferencesPage extends AppCompatActivity {

    private ListView lv;
    private ListView presets_lv;
    private ArrayList<String> customs_list = new ArrayList<>();
    private ArrayList<String> presets_list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences_page);

        lv = findViewById(R.id.customs_list);
        lv.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,customs_list));

        presets_lv = findViewById(R.id.presets_list);
        presets_lv.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,presets_list));

        final ImageButton custom_button = findViewById(R.id.imageButton4);
        custom_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CustomPage.class);
                startActivityForResult(intent, 0);
            }
        });

        final ImageButton preset_button = findViewById(R.id.imageButton5);
        preset_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PresetPage.class);
                startActivityForResult(intent, 0);
            }
        });
    }

    public void goToHomePage(View view) {
        // Go to home
        Intent intent = new Intent(getApplicationContext(), HomePage.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 0) {
            customs_list.clear();
            ArrayList<String> data_list = data.getStringArrayListExtra("data");
            customs_list.addAll(data_list);
            ((BaseAdapter) lv.getAdapter()).notifyDataSetChanged();
        }else{
            presets_list.clear();
            ArrayList<String> data_list = data.getStringArrayListExtra("data");
            presets_list.addAll(data_list);
            ((BaseAdapter) presets_lv.getAdapter()).notifyDataSetChanged();
        }
    }
}
