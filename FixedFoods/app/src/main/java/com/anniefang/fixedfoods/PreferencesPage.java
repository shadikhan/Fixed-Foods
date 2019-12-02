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

public class PreferencesPage extends AppCompatActivity {

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences_page);

        String s[] = new String[]{"Apple", "Bananas", "Avocados", "Nuts", "Asparagus", "Brocoli", "Strawberries", "Grapes"};
        lv = findViewById(R.id.preferences);
        lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,s));
        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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

    public void goToHomePage(View view) {
        // TODO: Keep selected items
        SparseBooleanArray sp = lv.getCheckedItemPositions();
        ArrayList<String> prefs = new ArrayList<>();
        for(int i=0;i<sp.size();i++){
            if(sp.valueAt(i)==true){
                String s = ((TextView) lv.getChildAt(i)).getText().toString();
                prefs.add(s);
            }
        }

        // Go to home
        Intent intent = new Intent(getApplicationContext(), HomePage.class);
        startActivity(intent);
    }
}
