package com.anniefang.fixedfoods;

import androidx.appcompat.app.AppCompatActivity;

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

public class CustomPage  extends AppCompatActivity {

    private ListView lv;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Set preferencesSet;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_page);

        pref = getSharedPreferences("CustomPrefs", Context.MODE_PRIVATE);
        editor = pref.edit();

        preferencesSet = pref.getStringSet("pref", null);

        if (preferencesSet == null)
            preferencesSet = new HashSet();


        String s[] = new String[]{"Apple", "Bananas", "Avocados", "Nuts", "Asparagus", "Broccoli", "Strawberries", "Grapes"};
        lv = findViewById(R.id.customs);
        lv.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_multiple_choice,s));
        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        loadPreferences(preferencesSet);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {

                TextView tv = (TextView) lv.getChildAt(arg2);

                if (lv.isItemChecked(arg2)) {
                    // Add it to our shared preferencesSet
                    preferencesSet.add(tv.getText().toString());
                } else {
                    preferencesSet.remove(tv.getText().toString());
                }

//                ListView lv = (ListView) arg0;
//                TextView tv = (TextView) lv.getChildAt(arg2);
//                String s = tv.getText().toString();
                //TODO: Do something after selection?
            }
        });

    }

    private void loadPreferences(Set preferencesSet) {

        ArrayAdapter a = (ArrayAdapter) lv.getAdapter();

        for (int i = 0; i < a.getCount(); i++) {
            String s = (String) a.getItem(i);

            if (preferencesSet.contains(s)){
                lv.setItemChecked(i, true);
            }
        }
    }

    public void Save(View view) {
        // TODO: Save the selections?
        SparseBooleanArray sp = lv.getCheckedItemPositions();
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<sp.size();i++){
            if(sp.valueAt(i)==true){
                String s = ((TextView) lv.getChildAt(sp.keyAt(i))).getText().toString();
                list.add(s);
            }
        }

        editor.putStringSet("pref", preferencesSet);
        editor.commit();

        // Go to home
        Intent intent = new Intent(getApplicationContext(), PreferencesPage.class);
        intent.putExtra("data", list);
        setResult(0, intent);
        finish();
    }

}
