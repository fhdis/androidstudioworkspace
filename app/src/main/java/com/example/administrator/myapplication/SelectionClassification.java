package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class SelectionClassification extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_classification);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("选择商品分类");
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorText));
        toolbar.setNavigationIcon(R.mipmap.ic_menu_arrow_left);
    }
}
