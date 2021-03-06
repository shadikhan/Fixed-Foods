package com.anniefang.fixedfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class SearchNow extends AppCompatActivity {

    ListView past_scans_list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_now);

        past_scans_list = (ListView) findViewById(R.id.past_scans_list);
        EditText theFilter = (EditText) findViewById(R.id.searchFilter);
        ArrayList<String> arrayItems = new ArrayList<>();

        arrayItems.add("McRib");
        arrayItems.add("McChicken");
        arrayItems.add("Aunt Jemima's Pancakes");
        arrayItems.add("Impossible Whopper");
        arrayItems.add("McNuggets");
        arrayItems.add("Popeyes Chicken Sandwich");
        arrayItems.add("McFlurry");
        arrayItems.add("Chipotle Chicken Burrito");
        arrayItems.add("Taco Bell Quesarito");


        adapter = new ArrayAdapter<String>(SearchNow.this, android.R.layout.simple_list_item_1, arrayItems);
        past_scans_list.setAdapter(adapter);

        past_scans_list.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String menuItem = (String) past_scans_list.getItemAtPosition(i);

                if (menuItem == "McRib") {
                    Intent intent = new Intent(getApplicationContext(), RestaurantItemView.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), menuItem, Toast.LENGTH_SHORT).show();
                }
            }
        });

        theFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void goToHomePage(View view) {
        Intent intent = new Intent(getApplicationContext(), HomePage.class);
        startActivity(intent);
    }
}
