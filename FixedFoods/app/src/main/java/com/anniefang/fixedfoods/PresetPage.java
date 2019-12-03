package com.anniefang.fixedfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.TextView;
import android.util.SparseBooleanArray;
import java.util.ArrayList;

public class PresetPage  extends AppCompatActivity {

    private ListView presets_lv;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preset_page);


        String s[] = new String[]{"Alkaline Diet", "Dairy Free Diet", "Gluten Free Diet", "Detox Diet",
                "Keto Diet", "High Protein Diet", "Juice Diet"};
        presets_lv = findViewById(R.id.presets);
        presets_lv.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_multiple_choice,s));
        presets_lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        presets_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                ListView lv = (ListView) arg0;
                TextView tv = (TextView) lv.getChildAt(arg2);
                String s = tv.getText().toString();
                //TODO: Do something after selection?
            }
        });

    }

    public void Save(View view) {
        // TODO: Save the selections?

        // Go to home
        Intent intent = new Intent(getApplicationContext(), PreferencesPage.class);
        startActivity(intent);
    }

}
