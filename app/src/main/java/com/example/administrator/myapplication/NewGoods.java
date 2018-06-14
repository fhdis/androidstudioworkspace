package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class NewGoods  extends AppCompatActivity {
    private TextView tv_dianneifenlei;
    private TextView tv_shangpinbiaoqian;
    private TextView tv_taocan;
    private TextView tv_guige;
    private TextView tv_shuxing;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newgoods);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("新建商品            保存");
        tv_dianneifenlei = (TextView)findViewById(R.id.tv_dianneifenlei);
        tv_shangpinbiaoqian = (TextView)findViewById(R.id.tv_shangpinbiaoqian);
        tv_taocan = (TextView)findViewById(R.id.tv_taocan);
        tv_guige = (TextView)findViewById(R.id.tv_guige);
        tv_shuxing = (TextView)findViewById(R.id.tv_shuxing);
        tv_dianneifenlei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewGoods.this,SelectionClassification.class);
                // intent.setAction("com.google.product");
                startActivity(intent);
            }
        });

        tv_shangpinbiaoqian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewGoods.this,GoodsLabel.class);
                // intent.setAction("com.google.product");
                startActivity(intent);
            }
        });

        tv_taocan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewGoods.this,PackageSettings.class);
                // intent.setAction("com.google.product");
                startActivity(intent);
            }
        });
        tv_guige.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewGoods.this,AddSpecification.class);
                // intent.setAction("com.google.product");
                startActivity(intent);
            }
        });

        tv_shuxing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewGoods.this,AttributeManagement.class);
                // intent.setAction("com.google.product");
                startActivity(intent);
            }
        });

    }
}
