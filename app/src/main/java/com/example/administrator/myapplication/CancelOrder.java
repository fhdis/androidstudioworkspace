package com.example.administrator.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CancelOrder extends Fragment {
    private ListView list_order_deal;
    private List<OrderDealModel> mDatas;
    private OrderDealAdapter  orderDealAdapter;
    private Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //无订单显示页面
        //View view = inflater.inflate(R.layout.new_order,container,false);
        //有订单显示界面
        View view = inflater.inflate(R.layout.order_deal_list,container,false);
        list_order_deal = (ListView)view.findViewById(R.id.list_order_deal);
        context = view.getContext();
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    //方法；初始化Data
    private void initData() {
        mDatas = new ArrayList<OrderDealModel>();

        //将数据装到集合中去
        OrderDealModel bean = new OrderDealModel("1", "建议14：07前出餐", "顾客：赵先生(先生)", "取消订单");
        mDatas.add(bean);


        bean = new OrderDealModel("4", "建议15：25前出餐", "顾客：胡小姐(女士)", "取消订单");
        mDatas.add(bean);

        //为数据绑定适配器
        orderDealAdapter = new OrderDealAdapter(context,mDatas);
        list_order_deal.setAdapter(orderDealAdapter);
    }
}