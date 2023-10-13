package com.example.deliverynow.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.deliverynow.Adapter.CartListAdapter;
import com.example.deliverynow.Helper.ManagementCart;
import com.example.deliverynow.Interface.ChangeNumberItemsListener;
import com.example.deliverynow.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CardListActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private ManagementCart managementCart;
    private TextView totalFeeTxt, taxTxt, deliveryTxt, totalTxt, emptyTxt;
    private double iva;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);

        managementCart = new ManagementCart(this);

        initView();
        initList();
        calculateCard();
        bottomNavigation();


        TextView buyButton = findViewById(R.id.textView16);
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSuccessMessage();
            }
        });
    }

    private void bottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.card_btn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(CardListActivity.this, ShowDetailActivity.class));
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirige a la actividad principal
                startActivity(new Intent(CardListActivity.this, MainActivity.class));
            }
        });
    }

    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        adapter = new CartListAdapter(managementCart.getListCard(), this, new ChangeNumberItemsListener() {
            @Override
            public void changed() {
                calculateCard();
            }
        });

        recyclerViewList.setAdapter(adapter);
        if (managementCart.getListCard().isEmpty()) {
            emptyTxt.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        } else {
            emptyTxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }
    }

    private void calculateCard() {
        double percentIva = 0.19;
        double delivery = 3500;

        iva = Math.round((managementCart.getTotalFee() * percentIva));
        double total = Math.round((managementCart.getTotalFee() + iva + delivery));
        double itemTotal = Math.round(managementCart.getTotalFee());

        totalFeeTxt.setText("$" + itemTotal);
        taxTxt.setText("$" + iva);
        deliveryTxt.setText("$" + delivery);
        totalTxt.setText("$" + total);
    }

    private void initView() {
        recyclerViewList = findViewById(R.id.recyclerview);
        totalFeeTxt = findViewById(R.id.totalFeeTxt);
        taxTxt = findViewById(R.id.taxTxt);
        deliveryTxt = findViewById(R.id.deliveryTxt);
        totalTxt = findViewById(R.id.totalTxt);
        emptyTxt = findViewById(R.id.emptyTxt);
        scrollView = findViewById(R.id.scrollView4);
    }


    private void showSuccessMessage() {
        Toast.makeText(this, "¡Compra exitosa!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(CardListActivity.this, MainActivity.class);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(CardListActivity.this, MainActivity.class);


                startActivity(intent);
            }
        }, 1000);
    }
}