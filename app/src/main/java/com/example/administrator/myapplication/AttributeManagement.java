package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class AttributeManagement extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attribute_management);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("新建商品            保存");
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorText));
        toolbar.setNavigationIcon(R.mipmap.ic_menu_arrow_left);
    }
}
