package com.anniefang.fixedfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RestaurantItemView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_item_view);
    }

    public void goToSearchNow(View view) {
        Intent intent = new Intent(getApplicationContext(), SearchNow.class);
        startActivity(intent);
    }
}
