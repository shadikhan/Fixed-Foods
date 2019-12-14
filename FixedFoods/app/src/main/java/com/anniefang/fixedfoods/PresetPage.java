package com.anniefang.fixedfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.TextView;
import android.util.SparseBooleanArray;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PresetPage  extends AppCompatActivity {

    private ListView presets_lv;
    private SharedPreferences pres;
    private SharedPreferences.Editor editor;
    private Set presetsSet;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preset_page);

        pres = getSharedPreferences("Presets", Context.MODE_PRIVATE);
        editor = pres.edit();

        presetsSet = pres.getStringSet("pres", null);

        if (presetsSet == null)
            presetsSet = new HashSet();

        String s[] = new String[]{"Alkaline", "Dairy Free", "Detox", "Gluten Free", "Glycemic", "High Protein", "Keto", "Low Cholesterol", "Vegan", "Vegetarian"};
        presets_lv = findViewById(R.id.presets);
        presets_lv.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_multiple_choice,s));
        presets_lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        loadPreferences(presetsSet);

        presets_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {

                TextView tv = (TextView) presets_lv.getChildAt(arg2);

                if (presets_lv.isItemChecked(arg2)) {
                    // Add it to our shared preferencesSet
                    presetsSet.add(tv.getText().toString());
                } else {
                    presetsSet.remove(tv.getText().toString());
                }

//                ListView lv = (ListView) arg0;
//                TextView tv = (TextView) lv.getChildAt(arg2);
//                String s = tv.getText().toString();
                //TODO: Do something after selection?
            }
        });

    }

    private void loadPreferences(Set presetsSet) {

        ArrayAdapter a = (ArrayAdapter) presets_lv.getAdapter();

        for (int i = 0; i < a.getCount(); i++) {
            String s = (String) a.getItem(i);

            if (presetsSet.contains(s)){
                presets_lv.setItemChecked(i, true);
            }
        }
    }

    public void Save(View view) {
        // TODO: Save the selections?
        SparseBooleanArray sp = presets_lv.getCheckedItemPositions();
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<sp.size();i++){
            if(sp.valueAt(i)==true){
                String s = ((TextView) presets_lv.getChildAt(sp.keyAt(i))).getText().toString();
                list.add(s);
            }
        }

        editor.putStringSet("pres", presetsSet);
        editor.commit();

        // Go to home
        Intent intent = new Intent(getApplicationContext(), PreferencesPage.class);
        startActivity(intent);
//        intent.putExtra("data", list);
//        setResult(1, intent);
//        finish();
    }

}
