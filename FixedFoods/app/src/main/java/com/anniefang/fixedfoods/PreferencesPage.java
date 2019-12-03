package com.anniefang.fixedfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class PreferencesPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences_page);

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
    }
}
