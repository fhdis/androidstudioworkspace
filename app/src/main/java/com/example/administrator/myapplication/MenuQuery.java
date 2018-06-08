package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MenuQuery extends Fragment implements View.OnClickListener{
    private TextView txt_all_order;
    private TextView txt_ongoing_order;
    private TextView txt_finish_order;
    private TextView  txt_cancel_order;

    private FrameLayout ly_content;

    private Button btn_recent;
    private Button btn_oneday;

    //private AllOrder f1;
    private AllOrder allOrder;
    private SecondFragment f2;
    private ThirdFragment f3;
    private FouthFragment f4;

    public  MenuQuery(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_query,container,false);
        txt_all_order = (TextView)view.findViewById(R.id.txt_all_order);
        txt_ongoing_order = (TextView)view.findViewById(R.id.txt_ongoing_order);
        txt_finish_order = (TextView)view.findViewById(R.id.txt_finish_order);
        txt_cancel_order = (TextView)view.findViewById(R.id.txt_cancel_order);
        ly_content = (FrameLayout)view.findViewById(R.id.fragment_container);
        btn_recent = (Button)view.findViewById(R.id.btn_recent);
        btn_oneday = (Button)view.findViewById(R.id.btn_oneday);
        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bindView();
        FragmentTransaction transaction1 =getChildFragmentManager().beginTransaction();
        if(allOrder==null) {
            allOrder = new AllOrder();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction1.add(R.id.fragment_container, allOrder);
        }else {
            transaction1.show(allOrder);
        }
        transaction1.commit();
    }

    //UI组件初始化与事件绑定
    private void bindView() {
        txt_all_order.setOnClickListener(this);
        txt_ongoing_order.setOnClickListener(this);
        txt_finish_order.setOnClickListener(this);
        txt_cancel_order.setOnClickListener(this);
    }

    //隐藏所有Fragment
    public void hideAllFragment(FragmentTransaction transaction){
        if(allOrder!=null){
            transaction.hide(allOrder);
        }
        if(f2!=null){
            transaction.hide(f2);
        }
        if(f3!=null){
            transaction.hide(f3);
        }
        if(f4!=null){
            transaction.hide(f4);
        }
    }

    //重置所有文本的选中状态
    public void selected(){
        txt_all_order.setSelected(false);
        txt_ongoing_order.setSelected(false);
        txt_finish_order.setSelected(false);
        txt_cancel_order.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction transaction =getChildFragmentManager().beginTransaction();
        hideAllFragment(transaction);
     switch (v.getId()){
         case R.id.btn_recent:
             //传入今天和昨天的日期和，类似用户名的参数，获取订单信息
             switch (v.getId()){
                 case R.id.txt_all_order:
                     selected();
                     txt_all_order.setSelected(true);
                     if(allOrder==null){
                         allOrder = new AllOrder();
                         transaction.add(R.id.fragment_container,allOrder);
                     }else{
                         transaction.show(allOrder);
                     }
                     break;
                 case R.id.txt_ongoing_order:
                     break;
                 case R.id.txt_finish_order:
                     break;
                 case R.id.txt_cancel_order:
                     break;
             }
             break;
         case R.id.btn_oneday:
             //传入指定的日期和，类似用户名的参数，获取订单信息
             switch (v.getId()){
                 case R.id.txt_all_order:
                     break;
                 case R.id.txt_ongoing_order:
                     break;
                 case R.id.txt_finish_order:
                     break;
                 case R.id.txt_cancel_order:
                     break;
             }
             break;
     }
    }

}
