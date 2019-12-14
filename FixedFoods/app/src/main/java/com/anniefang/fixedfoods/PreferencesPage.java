package com.anniefang.fixedfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PreferencesPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private ListView lv;
    private ListView presets_lv;
    private ArrayList<String> customs_list = new ArrayList<>();
    private ArrayList<String> presets_list = new ArrayList<>();


    private SharedPreferences cust;
    private SharedPreferences pres;
    private Set customsSet;
    private Set presetsSet;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences_page);

        cust = getSharedPreferences("Custom", Context.MODE_PRIVATE);
        pres = getSharedPreferences("Presets", Context.MODE_PRIVATE);

        customsSet = cust.getStringSet("cust", null);

        if (customsSet == null)
            customsSet = new HashSet();

        presetsSet = pres.getStringSet("pres", null);

        if (presetsSet == null)
            presetsSet = new HashSet();

        lv = findViewById(R.id.customs_list);
        lv.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,customs_list));

        presets_lv = findViewById(R.id.presets_list);
        presets_lv.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,presets_list));

        loadPreferencesAndPresets();

        final ImageButton custom_button = findViewById(R.id.imageButton4);
        custom_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CustomPage.class);
                startActivity(intent);
            }
        });

        final ImageButton preset_button = findViewById(R.id.imageButton5);
        preset_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PresetPage.class);
                startActivity(intent);
            }
        });

        Spinner spinner = findViewById(R.id.change_user);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.users, R.layout.spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_layout);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    public void goToHomePage(View view) {
        // Go to home
        Intent intent = new Intent(getApplicationContext(), HomePage.class);
        startActivity(intent);
    }

    private void loadPreferencesAndPresets() {
        customs_list.clear();
        customs_list.addAll(customsSet);
        ((BaseAdapter) lv.getAdapter()).notifyDataSetChanged();

        presets_list.clear();
        presets_list.addAll(presetsSet);
        ((BaseAdapter) presets_lv.getAdapter()).notifyDataSetChanged();
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(resultCode == 0) {
//            customs_list.clear();
//            ArrayList<String> data_list = data.getStringArrayListExtra("data");
//            customs_list.addAll(data_list);
//            ((BaseAdapter) lv.getAdapter()).notifyDataSetChanged();
//        }else{
//            presets_list.clear();
//            ArrayList<String> data_list = data.getStringArrayListExtra("data");
//            presets_list.addAll(data_list);
//            ((BaseAdapter) presets_lv.getAdapter()).notifyDataSetChanged();
//        }
//    }

    @Override
    public void onItemSelected (AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
//        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

    }
}
