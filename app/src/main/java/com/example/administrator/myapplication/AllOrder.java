package com.example.administrator.myapplication;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.util.Log;
import android.app.AlertDialog;

public class AllOrder extends Fragment implements View.OnClickListener{
    private String today;
    private String yesterday;
    private Context thiscontext;

    private TextView tv_yesterday;
    private TextView tv_today;

    private Button btn_order_product_details;
    private Button btn_order_express_progress;

    private Dialog allMsg;
    // Dialog的布局View
    private View allMsgView;

    public  AllOrder(){

    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            // dialog的图片取消button
            case R.id.dialog_pre_entry_close:
                allMsg.dismiss();
                break;
            default:
                break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.all_order,container,false);
        thiscontext = view.getContext();
        tv_yesterday = (TextView)view.findViewById(R.id.tv_yesterday);
        tv_today = (TextView)view.findViewById(R.id.tv_today);
        btn_order_product_details = (Button)view.findViewById(R.id.btn_order_product_details);
        btn_order_express_progress = (Button)view.findViewById(R.id.btn_order_express_progress);
        init();
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        //tv_yesterday.setText(yesterday);
        //tv_today.setText(today);
        btn_order_express_progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show(view);
            }
        });

        btn_order_product_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show(view);
            }
        });
    }


    private void init()
    {
        // 通过LayoutInflater找到改布局
        allMsgView = (RelativeLayout) LayoutInflater.from(thiscontext).inflate(R.layout.dialog_express, null);
        // 创建Dialog
        allMsg = new AlertDialog.Builder(thiscontext).create();
        // 设置点击外边缘不消失，2.x的应该是默认不消失的
        allMsg.setCanceledOnTouchOutside(false);

        // findView布局里的控件
        ImageButton imgBtn_dialog = (ImageButton) allMsgView.findViewById(R.id.dialog_pre_entry_close);
        imgBtn_dialog.setOnClickListener(this);
        ListView listview = (ListView)allMsgView.findViewById(R.id.list_product);
        String[] strDatas = new String[] {
                "6月8日9：00已接单", "6月8日9：30已接单", "6月8日10：00已接单", "6月8日10：30已接单", "6月9日11：30已接单"};
        listview.setAdapter(new ArrayAdapter<String>(thiscontext,
                android.R.layout.simple_list_item_1, strDatas));
    }

    public void show(View v)
    {
        // 两句的顺序不能调换
        allMsg.show();
        allMsg.getWindow().setContentView((RelativeLayout) allMsgView);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        if( resultCode != Activity.RESULT_OK)
            return ;
        if( requestCode == MenuQuery.requestCode)
        {
            Bundle bundle = data.getExtras();
            today = bundle.getString("today");
            yesterday =  bundle.getString("yesterday");
            Log.d("AAAAA","11111today="+today);
            Log.d("AAAAA","22222today="+yesterday);
        }
    }
}
