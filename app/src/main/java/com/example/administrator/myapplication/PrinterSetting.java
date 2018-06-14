package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class PrinterSetting extends AppCompatActivity {
    private TextView tx_add_printer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.printer_setting);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("打印机设置");
        tx_add_printer = (TextView)findViewById(R.id.tx_add_printer);
        tx_add_printer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PrinterSetting.this,AddPrinter.class);
                // intent.setAction("com.google.product");
                startActivity(intent);
            }
        });
    }
}
