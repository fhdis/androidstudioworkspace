package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class RulesCenter extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rules_center);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("规则中心");
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorText));
        toolbar.setNavigationIcon(R.mipmap.ic_menu_arrow_left);
    }
}
