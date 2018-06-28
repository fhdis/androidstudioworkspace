package com.example.administrator.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FouthFragment extends Fragment {
    //private String context;
    //private TextView mTextView;
    private com.example.administrator.myapplication.ClickableListItem tx_dayinji;
    private com.example.administrator.myapplication.ClickableListItem tx_hujiaokefu;
    private com.example.administrator.myapplication.ClickableListItem tx_guizezhongxin;
    private com.example.administrator.myapplication.ClickableListItem tx_aboutus;

    private Dialog allMsg;
    // Dialog的布局View
    private View allMsgView;

    public  FouthFragment(){
        //this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.four_fragment,container,false);
        //mTextView = (TextView)view.findViewById(R.id.txt_content);
        //mTextView = (TextView)getActivity().findViewById(R.id.txt_content);
        //mTextView.setText(context);
        tx_dayinji = (com.example.administrator.myapplication.ClickableListItem)view.findViewById(R.id.tx_dayinji);
        tx_hujiaokefu = (com.example.administrator.myapplication.ClickableListItem)view.findViewById(R.id.tx_hujiaokefu);
        tx_guizezhongxin = (com.example.administrator.myapplication.ClickableListItem)view.findViewById(R.id.tx_guizezhongxin);
        tx_aboutus = (com.example.administrator.myapplication.ClickableListItem)view.findViewById(R.id.tx_aboutus);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
          tx_dayinji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),PrinterSetting.class);
                // intent.setAction("com.google.product");
                startActivity(intent);
            }
        });

      tx_hujiaokefu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show(view);
            }
        });

        tx_guizezhongxin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),RulesCenter.class);
                // intent.setAction("com.google.product");
                startActivity(intent);
            }
        });

        tx_aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),AboutUs.class);
                // intent.setAction("com.google.product");
                startActivity(intent);
            }
        });
    }

    private void init()
    {
        // 通过LayoutInflater找到改布局
        allMsgView = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.call_customer_service_item, null);
        // 创建Dialog
        allMsg = new AlertDialog.Builder(getContext()).create();
        // 设置点击外边缘不消失，2.x的应该是默认不消失的
        allMsg.setCanceledOnTouchOutside(false);
        //Window win = allMsg.getWindow();
        //WindowManager.LayoutParams wmParams = new WindowManager.LayoutParams();
       /* LayoutParams params = new LayoutParams(0,0);
        params.x = -80;//设置x坐标
        params.y = -60;//设置y坐标*/
       // wmParams.x = -80;// 以屏幕左上角为原点，设置x、y初始值
       // wmParams.y = -60;
        //win.setAttributes(wmParams);
    }
    public void show(View v)
    {
        // 两句的顺序不能调换
        allMsg.show();
        allMsg.getWindow().setContentView((RelativeLayout) allMsgView);
    }
}

