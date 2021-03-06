package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.PopupWindow;
import java.util.Calendar;

public class CalendarPopWindow extends PopupWindow {
    //上下文
    private Context mContext;
    // PopupWindow中控件点击事件回调接口
    private IPopuWindowListener mOnClickListener;
    //PopupWindow布局文件中的Button
    private Button alarm_pop_btn;
    /**
     * @description 构造方法
     * @author ldm
     * @time  2016/9/30 9:14
     * @param
     */
    public CalendarPopWindow(Context mContext, int width, int height, IPopuWindowListener listener) {
        super(mContext);
        this.mContext = mContext;
        this.mOnClickListener = listener;
        //获取布局文件
        View mContentView = LayoutInflater.from(mContext).inflate(R.layout.calendar_popwindow, null);
        //设置布局
        setContentView(mContentView);
        // 设置弹窗的宽度和高度
        setWidth(width);
        setHeight(height);
        //设置能否获取到焦点
        setFocusable(false);
        //设置PopupWindow进入和退出时的动画效果
        setAnimationStyle(R.style.popwindow_exit_anim_style);
        setTouchable(true); // 默认是true，设置为false，所有touch事件无响应，而被PopupWindow覆盖的Activity部分会响应点击
        // 设置弹窗外可点击,此时点击PopupWindow外的范围，Popupwindow不会消失
        setOutsideTouchable(false);
        //外部是否可以点击，设置Drawable原因可以参考：http://blog.csdn.net/harvic880925/article/details/49278705
        setBackgroundDrawable(new BitmapDrawable());
        // 设置弹窗的布局界面
        //initUI();
    }


    /**
     * 显示弹窗列表界面
     */
    public void show(View view) {
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        //Gravity.BOTTOM设置在view下方，还可以根据location来设置PopupWindowj显示的位置
        showAtLocation(view, Gravity.BOTTOM, 0, 0);
    }

    /**
     * @param
     * @author ldm
     * @description 点击事件回调处理接口
     * @time 2016/7/29 15:30
     */
    public interface IPopuWindowListener {
        void dispose();
    }

}
