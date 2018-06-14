package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ManagementClassification extends AppCompatActivity {
    private TextView bianyione;
    private TextView bianyitwo;
    private TextView bianyithress;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.management_classification);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("管理分类");
        bianyione = (TextView)findViewById(R.id.bianyione);
        bianyitwo = (TextView)findViewById(R.id.bianyitwo);
        bianyithress = (TextView)findViewById(R.id.bianyithress);
        bianyione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManagementClassification.this,EditingClassification.class);
                // intent.setAction("com.google.product");
                startActivity(intent);
            }
        });
        bianyitwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManagementClassification.this,EditingClassification.class);
                // intent.setAction("com.google.product");
                startActivity(intent);
            }
        });
        bianyithress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManagementClassification.this,EditingClassification.class);
                // intent.setAction("com.google.product");
                startActivity(intent);
            }
        });
    }

}
