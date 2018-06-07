package com.example.administrator.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class ThirdFragment extends Fragment implements View.OnTouchListener{
   // private ViewFlipper viewFlipper;
    private ViewFlipper flipperBanner;
    private int[] imagsList = {R.mipmap.gundong_1,R.mipmap.gundong_2,R.mipmap.gundong_3,R.mipmap.gundong_4};
    private LinearLayout linearLayout;
    private float x1 = 0;
    private Context  thiscontext;

    private TextView product;
    private TextView appraisal;
    private TextView wallet;
    private TextView store;
    public  ThirdFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.third_fragment,container,false);
        thiscontext = view.getContext();
        //viewFlipper = ((ViewFlipper)view.findViewById(R.id.viewFlipper));
        flipperBanner = ((ViewFlipper)view.findViewById(R.id.vf_banner));
        linearLayout = ((LinearLayout)view.findViewById(R.id.point));
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //这里我建了个Ness类  模拟从网络上获取数据 并展示
        /*final List<News> newsList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            News news = new News();
            news.setFirstNews("我是第一行第" + i + "条数据");
            news.setTwoNews("我是第二行第" + i + "条数据");
            newsList.add(news);
        }

        for (News news : newsList) {
            //创建试图
            LinearLayout linearLayout = new LinearLayout(thiscontext);
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            linearLayout.setPadding(10,10,10,10);
            TextView textView1 = new TextView(thiscontext);
            TextView textView2 = new TextView(thiscontext);
            textView1.setText(news.getFirstNews());
            textView2.setText(news.getTwoNews());
            linearLayout.addView(textView1);
            linearLayout.addView(textView2);
            //通过addView将试图添加进去(有几个试图就必须添加几个，否则无法展示)
            viewFlipper.addView(linearLayout);
        }*/


        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20,20);
        params.leftMargin = 10;
        //图片资源
        int[] imagsList = {R.mipmap.gundong_1,R.mipmap.gundong_2,R.mipmap.gundong_3,R.mipmap.gundong_4};

        //循环添加试图并创建圆点
        for (int i : imagsList) {
            ImageView imageView = new ImageView(thiscontext);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(i);
            //将试图添加进去
            flipperBanner.addView(imageView);
            //创建圆点（有几张图片创建几个）
            TextView textView = new TextView(thiscontext);
            //设置选择器
            textView.setBackgroundResource(R.drawable.choose_circle);
            textView.setLayoutParams(params);
            //添加圆点
            linearLayout.addView(textView);
        }
        linearLayout.getChildAt(0).setSelected(true);


        //添加动画
        flipperBanner.setInAnimation(thiscontext,R.anim.in_left);
        flipperBanner.setOutAnimation(thiscontext,R.anim.out_left);
        //设置监听事件
        flipperBanner.getOutAnimation().setAnimationListener(animationListener);

        flipperBanner.setOnTouchListener(this);

    }

    Animation.AnimationListener animationListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            point();
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };

    private void point() {
        for (int i = 0; i < imagsList.length; i++) {
            if (i == flipperBanner.getDisplayedChild()) {
                linearLayout.getChildAt(flipperBanner.getDisplayedChild()).setSelected(true);
            }else {
                linearLayout.getChildAt(i).setSelected(false);
            }
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = motionEvent.getX();
                break;
            case MotionEvent.ACTION_UP:
                if(x1 - motionEvent.getX() > 20){
                    flipperBanner.showNext();
                }else if (x1 - motionEvent.getX() < -20){
                    flipperBanner.showPrevious();
                }else {
                    Toast.makeText(thiscontext,String.valueOf(flipperBanner.getDisplayedChild()),Toast.LENGTH_SHORT).show();
                }
                point();
                break;
        }
        return true;
    }
}

