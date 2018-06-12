package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
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
import android.util.Log;

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
    private OngoingOrder ongoingOrder;
    private FinishOrder finishOrder;
    private HaveCanceledOrder  haveCanceledOrder;

    private String today;
    private String yesterday;

    private PopupWindow popupWindow;
    private View popview;
    private DatePicker datePicker;
    public static int requestCode = 0;
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
            //FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction1.add(R.id.fragment_container, allOrder);
        }
        transaction1.commit();
        btn_recent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                Calendar c = Calendar.getInstance();
                today = sf.format(c.getTime());
                Log.d("AAAAA","today="+today);
                System.out.println("当前日期：               "+sf.format(c.getTime()));
                c.add(Calendar.DAY_OF_MONTH,-1);
                yesterday = sf.format(c.getTime());
                Log.d("AAAAA","yesterday="+yesterday);
                System.out.println("增加一天后日期 ：  "+sf.format(c.getTime()));
                }
        });

        btn_oneday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showWindow(view);
            }
        });
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
        if(ongoingOrder!=null){
            transaction.hide(ongoingOrder);
        }
        if(finishOrder!=null){
            transaction.hide(finishOrder);
        }
        if(haveCanceledOrder!=null){
            transaction.hide(haveCanceledOrder);
        }
    }

    //重置所有文本的选中状态
    public void selected(){
        txt_all_order.setSelected(false);
        txt_ongoing_order.setSelected(false);
        txt_finish_order.setSelected(false);
        txt_cancel_order.setSelected(false);
    }
   /* public void selected() {
        tvTest.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线
        tvTest.getPaint().setAntiAlias(true);//抗锯齿
    }*/
   public void cancelFlags(){
       txt_all_order.getPaint().setFlags(0);
       txt_ongoing_order.getPaint().setFlags(0);
       txt_finish_order.getPaint().setFlags(0);
       txt_cancel_order.getPaint().setFlags(0);
   }

    public void setFlags(TextView textview){
        textview.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG|Paint.ANTI_ALIAS_FLAG);
    }
    @Override
    public void onClick(View v) {
        FragmentTransaction transaction =getChildFragmentManager().beginTransaction();
        hideAllFragment(transaction);
     switch (v.getId()){
        /* case R.id.btn_recent:
             break;
         case R.id.btn_oneday:
             //showWindow(v);
             break;*/
         case R.id.txt_all_order:
             selected();
             cancelFlags();
             txt_all_order.setSelected(true);
             setFlags(txt_all_order);
             if(allOrder==null){
                 // f1 = new FirstFragment();
                 allOrder = new AllOrder();
                /* Intent intent = new Intent();
                 Bundle bundle = new Bundle();
                 bundle.putString("today",today);
                 bundle.putString("yesterday",yesterday);
                 getTargetFragment().onActivityResult(requestCode, Activity.RESULT_OK, intent);*/
                 transaction.add(R.id.fragment_container,allOrder);
             }else{
                 transaction.show(allOrder);
                 Intent intent = new Intent();
                 Bundle bundle = new Bundle();
                 bundle.putString("today",today);
                 bundle.putString("yesterday",yesterday);
                 intent.putExtras(bundle);
                // getTargetFragment().onActivityResult(requestCode, Activity.RESULT_OK, intent);

             }
             break;
         case R.id.txt_ongoing_order:
             selected();
             cancelFlags();
             txt_ongoing_order.setSelected(true);
             setFlags(txt_ongoing_order);
             if(ongoingOrder==null){
                 // f1 = new FirstFragment();
                 ongoingOrder = new OngoingOrder();
                 transaction.add(R.id.fragment_container,ongoingOrder);
             }else{
                 transaction.show(ongoingOrder);
             }
             break;
         case R.id.txt_finish_order:
             selected();
             cancelFlags();
             txt_finish_order.setSelected(true);
             setFlags(txt_finish_order);
             if(finishOrder==null){
                 // f1 = new FirstFragment();
                 finishOrder = new FinishOrder();
                 transaction.add(R.id.fragment_container,finishOrder);
             }else{
                 transaction.show(finishOrder);
             }
             break;
         case R.id.txt_cancel_order:
             selected();
             cancelFlags();
             txt_cancel_order.setSelected(true);
             setFlags(txt_cancel_order);
             if(haveCanceledOrder==null){
                 // f1 = new FirstFragment();
                 haveCanceledOrder = new HaveCanceledOrder();
                 transaction.add(R.id.fragment_container,haveCanceledOrder);
             }else{
                 transaction.show(haveCanceledOrder);
             }
             break;
     }
        transaction.commit();
    }

    private void showWindow(View parent) {
            //popupWindow = new PopupWindow();
            LayoutInflater layoutInflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            popview = layoutInflater.inflate(R.layout.calendar_popwindow, null);
           // datePicker = (DatePicker)parent.findViewById(R.id.calendar);
            //datePicker.init(2018, 6, 9,null);
       /* datePicker.init(2016, 6, 12, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(i, i1, i2);
                SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日  HH:mm");
                //Toast.makeText(parent.getContext(), format.format(calendar.getTime()), Toast.LENGTH_SHORT).show();
            }
        });*/
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
           popupWindow = new PopupWindow(popview, 500, 350);
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

           //popupWindow.showAsDropDown(parent, xPos, 0);
             popupWindow.showAsDropDown(popview);
    }
}
