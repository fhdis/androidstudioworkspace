package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class ManageStoreCenter extends AppCompatActivity {
    private TextView tx_yingyeshezhi;
    private TextView tx_jibenxinxi;
    private TextView tx_renzhengzhongxin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_store_center);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("认证中心");
    }
}
