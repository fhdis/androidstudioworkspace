package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ManageStore extends AppCompatActivity {
    private TextView tx_yingyeshezhi;
    private TextView tx_jibenxinxi;
    private TextView tx_renzhengzhongxin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_store);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("门店");
        tx_yingyeshezhi = (TextView)findViewById(R.id.tx_yingyeshezhi);
        tx_jibenxinxi = (TextView)findViewById(R.id.tx_jibenxinxi);
        tx_renzhengzhongxin = (TextView)findViewById(R.id.tx_renzhengzhongxin);
        tx_yingyeshezhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManageStore.this,ManageStoreSetting.class);
                // intent.setAction("com.google.product");
                startActivity(intent);
            }
        });
        tx_jibenxinxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManageStore.this,ManageStoreInfomation.class);
                // intent.setAction("com.google.product");
                startActivity(intent);
            }
        });
        tx_renzhengzhongxin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManageStore.this,ManageStoreCenter.class);
                // intent.setAction("com.google.product");
                startActivity(intent);
            }
        });
    }
}
