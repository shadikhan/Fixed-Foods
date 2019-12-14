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
    private SharedPreferences cust;
    private SharedPreferences.Editor editor;
    private Set customsSet;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_page);

        cust = getSharedPreferences("Custom", Context.MODE_PRIVATE);
        editor = cust.edit();

        customsSet = cust.getStringSet("cust", null);

        if (customsSet == null)
            customsSet = new HashSet();


        String s[] = new String[]{"Apple", "Avocado", "Banana", "Cashews", "Carrots", "Chocolate", "Coconuts", "Grapes", "Nuts", "Peanuts", "Pork", "Shrimp", "Strawberries"};
        lv = findViewById(R.id.customs);
        lv.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_multiple_choice,s));
        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        loadCustoms();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {

                TextView tv = (TextView) lv.getChildAt(arg2);

                if (lv.isItemChecked(arg2)) {
                    // Add it to our shared customsSet
                    customsSet.add(tv.getText().toString());
                } else {
                    customsSet.remove(tv.getText().toString());
                }

//                ListView lv = (ListView) arg0;
//                TextView tv = (TextView) lv.getChildAt(arg2);
//                String s = tv.getText().toString();
                //TODO: Do something after selection?
            }
        });

    }

    private void loadCustoms() {

        ArrayAdapter a = (ArrayAdapter) lv.getAdapter();

        for (int i = 0; i < a.getCount(); i++) {
            String s = (String) a.getItem(i);

            if (customsSet.contains(s)){
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

        editor.putStringSet("cust", customsSet);
        editor.commit();

        // Go to home
        Intent intent = new Intent(getApplicationContext(), PreferencesPage.class);
        startActivity(intent);
//        intent.putExtra("data", list);
//        setResult(0, intent);
//        finish();
    }

}
