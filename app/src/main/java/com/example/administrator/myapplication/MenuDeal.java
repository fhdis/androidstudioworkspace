package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MenuDeal extends Fragment implements View.OnClickListener{
    private TextView txt_new_deal;
    private TextView txt_cancel_order;
    private TextView txt_service_order;
    private FrameLayout ly_content;

    private NewOrder f1;
    private CancelOrder f2;
    private ServiceOrder f3;

    public  MenuDeal(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_deal,container,false);
        txt_new_deal = (TextView)view.findViewById(R.id.txt_new_deal);
        txt_cancel_order = (TextView)view.findViewById(R.id.txt_cancel_order);
        txt_service_order = (TextView)view.findViewById(R.id.txt_service_order);
        ly_content = (FrameLayout)view.findViewById(R.id.fragment_container);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bindView();
        FragmentTransaction transaction1 =getChildFragmentManager().beginTransaction();
        if(f1==null) {
            f1 = new NewOrder();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction1.add(R.id.fragment_container, f1);
        }else {
            transaction1.show(f1);
        }
        transaction1.commit();
    }

    //UI组件初始化与事件绑定
    private void bindView() {
        txt_new_deal.setOnClickListener(this);
        txt_cancel_order.setOnClickListener(this);
        txt_service_order.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction transaction =getChildFragmentManager().beginTransaction();
        hideAllFragment(transaction);
        switch(v.getId()){
            case R.id.txt_new_deal:
                selected();
                txt_new_deal.setSelected(true);
                if(f1==null){
                    f1 = new NewOrder();
                    transaction.add(R.id.fragment_container,f1);
                }else{
                    transaction.show(f1);
                }
                break;

            case R.id.txt_cancel_order:
                selected();
                txt_cancel_order.setSelected(true);
                if(f2==null){
                    f2 = new CancelOrder();
                    transaction.add(R.id.fragment_container,f2);
                }else{
                    transaction.show(f2);
                }
                break;

            case R.id.txt_service_order:
                selected();
                txt_service_order.setSelected(true);
                if(f3==null){
                    f3 = new ServiceOrder();
                    transaction.add(R.id.fragment_container,f3);
                }else{
                    transaction.show(f3);
                }
                break;
        }
        transaction.commit();
    }

    //隐藏所有Fragment
    public void hideAllFragment(FragmentTransaction transaction){
        if(f1!=null){
            transaction.hide(f1);
        }
        if(f2!=null){
            transaction.hide(f2);
        }
        if(f3!=null){
            transaction.hide(f3);
        }
    }

    //重置所有文本的选中状态
    public void selected(){
        txt_new_deal.setSelected(false);
        txt_cancel_order.setSelected(false);
        txt_service_order.setSelected(false);
    }
}
