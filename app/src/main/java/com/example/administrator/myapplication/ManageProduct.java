package com.example.administrator.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

public class ManageProduct extends AppCompatActivity {
    private Button bt_manage_classify;
    private Button bt_manage_sort;
    private Button bt_mamage_new;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_product);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("全部商品");
        //setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_menu_back);
        bt_manage_classify = (Button)findViewById(R.id.bt_manage_classify);
        bt_manage_sort = (Button)findViewById(R.id.bt_manage_sort);
        bt_mamage_new = (Button)findViewById(R.id.bt_mamage_new);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }
}
