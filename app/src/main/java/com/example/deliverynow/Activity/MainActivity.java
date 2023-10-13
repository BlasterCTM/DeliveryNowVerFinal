package com.example.deliverynow.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.deliverynow.Adapter.CartListAdapter;
import com.example.deliverynow.Adapter.CategoryAdapter;
import com.example.deliverynow.Adapter.PopularAdapter;
import com.example.deliverynow.Domain.CategoryDomain;


import com.example.deliverynow.Domain.FoodDomain;
import com.example.deliverynow.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerViewCategory();
        recyclerViewPopular();
        bottomNavigation();
    }
    private void bottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.card_btn1);
        LinearLayout homeBtn = findViewById(R.id.home_btn1);




        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CardListActivity.class));
            }
        });


        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });
    }
    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodlist = new ArrayList<>();
        foodlist.add(new FoodDomain("Pepperoni pizza", "pizza1", "rebanadas de pepperoni, queso mozzarella, orégano fresco, pimienta negra molida, salsa para pizza", 6500.0));
        foodlist.add(new FoodDomain("Hamburguesa con queso", "burger", "ternera, Queso Gouda, Salsa especial, Lechuga, tomate", 8790.0));
        foodlist.add(new FoodDomain("Pizza vegetariana", "pizza3", "aceite de oliva, aceite vegetal, Kalamata deshuesado, tomates cherry, orégano fresco, albahaca", 9500.0));

        adapter2 = new PopularAdapter(foodlist);
        recyclerViewPopularList.setAdapter(adapter2);

    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);

        recyclerViewCategoryList = findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("","cat_1"));
        categoryList.add(new CategoryDomain("","cat_2"));
        categoryList.add(new CategoryDomain("","cat_3"));
        categoryList.add(new CategoryDomain("","cat_4"));
        categoryList.add(new CategoryDomain("","cat_5"));

        adapter = new CategoryAdapter(categoryList);
        recyclerViewCategoryList.setAdapter(adapter);
    }

    public void navigateToProfile(View view) {

        Intent intent = new Intent(this, ProfileActivity.class);


        startActivity(intent);
    }

}

