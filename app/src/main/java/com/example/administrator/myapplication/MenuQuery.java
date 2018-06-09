package com.example.administrator.myapplication;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.text.SimpleDateFormat;

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

    private PopupWindow popupWindow;
    private View popview;
    private DatePicker datePicker;
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
             /*switch (v.getId()){
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
             }*/
             break;
         case R.id.btn_oneday:
             showWindow(v);
             //传入指定的日期和，类似用户名的参数，获取订单信息
             /*switch (v.getId()){
                 case R.id.txt_all_order:
                     break;
                 case R.id.txt_ongoing_order:
                     break;
                 case R.id.txt_finish_order:
                     break;
                 case R.id.txt_cancel_order:
                     break;
             }*/
             break;
     }
    }

    private void showWindow(View parent) {
            //popupWindow = new PopupWindow();
            LayoutInflater layoutInflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            popview = layoutInflater.inflate(R.layout.calendar_popwindow, null);
            datePicker = (DatePicker)parent.findViewById(R.id.calendar);
            datePicker.init(2018, 6, 9,null);
            /*datePicker.init(2013, 8, 20, new OnDateChangedListener(){
                @Override
                public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    // 获取一个日历对象，并初始化为当前选中的时间
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(year, monthOfYear, dayOfMonth);
                    SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日  HH:mm");
                    Toast.makeText(view.getContext(), format.format(calendar.getTime()), Toast.LENGTH_SHORT).show();
                }

            });*/
           popupWindow = new PopupWindow(popview, 300, 350);
        // 使其聚集
            popupWindow.setFocusable(true);
            // 设置允许在外点击消失
            popupWindow.setOutsideTouchable(true);

            // 这个是为了点击“返回Back”也能使其消失，并且并不会影响你的背景
            popupWindow.setBackgroundDrawable(new BitmapDrawable());
            WindowManager windowManager = (WindowManager) parent.getContext().getSystemService(Context.WINDOW_SERVICE);
            // 显示的位置为:屏幕的宽度的一半-PopupWindow的高度的一半
            int xPos = windowManager.getDefaultDisplay().getWidth() / 2
                    - popupWindow.getWidth() / 2;
            Log.i("coder", "xPos:" + xPos);

            popupWindow.showAsDropDown(parent, xPos, 0);

    }
}
