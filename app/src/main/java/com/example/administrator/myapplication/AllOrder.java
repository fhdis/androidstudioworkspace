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

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
        if(!EventBus.getDefault().isRegistered(this)){//加上判断
            EventBus.getDefault().register(this);
        }
        return view;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void userEventBus(MessageEvent messageEvent){
        tv_today.setText(messageEvent.today);
        tv_yesterday.setText(messageEvent.yesterday);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        //tv_yesterday.setText(yesterday);
        //tv_today.setText(today);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        today = (calendar.get(Calendar.MONTH)+1) + "月"//从0计算
                + calendar.get(Calendar.DAY_OF_MONTH) + "日";
        calendar.add( Calendar. DATE, -1);
        yesterday = (calendar.get(Calendar.MONTH)+1) + "月"//从0计算
                + calendar.get(Calendar.DAY_OF_MONTH) + "日";

        tv_today.setText(today);
        tv_yesterday.setText(yesterday);

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


    private void init() {
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

    public void show(View v) {
        // 两句的顺序不能调换
        allMsg.show();
        allMsg.getWindow().setContentView((RelativeLayout) allMsgView);
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        if (EventBus.getDefault().isRegistered(this))//加上判断
            EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
    }



}
