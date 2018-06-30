package com.example.administrator.myapplication;

import android.support.v7.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.othershe.calendarview.bean.DateBean;
import com.othershe.calendarview.listener.OnPagerChangeListener;
import com.othershe.calendarview.listener.OnSingleChooseListener;
import com.othershe.calendarview.utils.CalendarUtil;
import com.othershe.calendarview.weiget.CalendarView;

public class CalendarUI extends AlertDialog implements View.OnClickListener {

    private CalendarView calendarView;

    private int[] cDate = CalendarUtil.getCurrentDate();
    private int lastMonth = 3;
    private int nextMonth = 3;

    private Context thiscontext;
    private OnEditInputFinishedListener mListener; //接口

    protected CalendarUI(Context context, OnEditInputFinishedListener mListener) {
        super(context);
        //thiscontext = context;
        this.mListener = mListener;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.calendar);
        //WindowManager m = getWindowManager();
        WindowManager m = (WindowManager) getContext().getApplicationContext()
                .getSystemService(Context.WINDOW_SERVICE);
        Display d = m.getDefaultDisplay();  //为获取屏幕宽、高
        WindowManager.LayoutParams p = getWindow().getAttributes();  //获取对话框当前的参数值
        p.height = (int) (d.getHeight() * 0.6);   //高度设置为屏幕的1.0
        p.width = (int) (d.getWidth() );    //宽度设置为屏幕的0.8
        p.alpha = 1.0f;      //设置本身透明度
        // p.dimAmount = 0.0f;      //设置黑暗度
        getWindow().setAttributes(p);
        final TextView title = (TextView) findViewById(R.id.title);

        calendarView = (CalendarView) findViewById(R.id.calendar);
        calendarView
                .setStartEndDate("2018.4", "2018.9")
                .setInitDate(cDate[0] + "." + cDate[1])
                .setSingleDate(cDate[0] + "." + cDate[1] + "." + cDate[2])
                .init();


        title.setText(cDate[0] + "年" + cDate[1] + "月");
        //chooseDate.setText("当前选中的日期：" + cDate[0] + "年" + cDate[1] + "月" + cDate[2] + "日");

        calendarView.setOnPagerChangeListener(new OnPagerChangeListener() {
            @Override
            public void onPagerChanged(int[] date) {
                title.setText(date[0] + "年" + date[1] + "月");
            }
        });

        calendarView.setOnSingleChooseListener(new OnSingleChooseListener() {
            @Override
            public void onSingleChoose(View view, DateBean date) {
                title.setText(date.getSolar()[0] + "年" + date.getSolar()[1] + "月");
                Log.d("test","choose"+date.getSolar()[0] + date.getSolar()[1] +date.getSolar()[2]);
                if (mListener != null) {
                    String choosetime = ""+date.getSolar()[0] + " "+date.getSolar()[1] +" "+date.getSolar()[2];
                    mListener.editInputFinished(choosetime);
                }
                dismiss();
            }
        });
    }

    public void lastMonth(View view) {
        if(lastMonth==0){
            return;
        }
        calendarView.lastMonth();
        lastMonth--;
    }

    public void nextMonth(View view) {
        if(nextMonth==0){
            return;
        }
        calendarView.nextMonth();
        nextMonth--;
    }

    @Override
    public void onClick(View v) {

    }

    public interface OnEditInputFinishedListener{
        void editInputFinished(String password);
    }
}

