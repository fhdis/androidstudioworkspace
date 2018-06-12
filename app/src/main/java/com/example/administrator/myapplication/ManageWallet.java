package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ManageWallet extends AppCompatActivity {
    private TextView tv_yinhangka;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_wallet);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("商家钱包");
        tv_yinhangka = (TextView)findViewById(R.id.yinhangka);
        tv_yinhangka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManageWallet.this,ManageYinhangka.class);
                // intent.setAction("com.google.product");
                startActivity(intent);
            }
        });
    }
}
