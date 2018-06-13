package com.example.administrator.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import android.util.Log;

public class ThirdFragment extends Fragment implements View.OnTouchListener {
   // private ViewFlipper viewFlipper;
    private ViewFlipper flipperBanner;
    private int[] imagsList = {R.mipmap.gundong_1,R.mipmap.gundong_2,R.mipmap.gundong_3,R.mipmap.gundong_4};
    private LinearLayout linearLayout;
    private float x1 = 0;
    private Context  thiscontext;

    private Button product;
    private Button wallet;
    private Button store;

    private Context context;
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
        product = view.findViewById(R.id.product);
        wallet = view.findViewById(R.id.wallet);
        store = view.findViewById(R.id.store);
        context = view.getContext();
        Log.d("BBBB","ThirdFragment="+"onCreateView");
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("BBBB","ThirdFragment="+"onActivityCreated");
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
        product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,ManageProduct.class);
               // intent.setAction("com.google.product");
                startActivity(intent);
            }
        });
        wallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,ManageWallet.class);
                // intent.setAction("com.google.product");
                startActivity(intent);
            }
        });
        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,ManageStore.class);
                // intent.setAction("com.google.product");
                startActivity(intent);
            }
        });
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

