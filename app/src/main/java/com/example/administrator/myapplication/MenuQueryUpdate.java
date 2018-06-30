package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import org.greenrobot.eventbus.EventBus;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MenuQueryUpdate extends Fragment {
    private GroupButtonView gbv_day;
    private Button bt_person_setting;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private MyFragmentPagerAdapter myFragmentPagerAdapter;

    private TabLayout.Tab one;
    private TabLayout.Tab two;
    private TabLayout.Tab three;
    private TabLayout.Tab four;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_query_update, container, false);
        gbv_day = (GroupButtonView)view.findViewById(R.id.gbv_day);
        mViewPager= (ViewPager)view.findViewById(R.id.mViewPager);
        mTabLayout = (TabLayout)view.findViewById(R.id.mTabLayout);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(myFragmentPagerAdapter);
        //将TabLayout与ViewPager绑定在一起
        mTabLayout.setupWithViewPager(mViewPager);
        //指定Tab的位置
        one = mTabLayout.getTabAt(0);
        two = mTabLayout.getTabAt(1);
        three = mTabLayout.getTabAt(2);
        four = mTabLayout.getTabAt(3);

        String today;
        String yesterday;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        today = (calendar.get(Calendar.MONTH)+1) + "月"//从0计算
                + calendar.get(Calendar.DAY_OF_MONTH) + "日";
        //yesterday = getOldDate(1);
        //EventBus.getDefault().post(new MessageEvent(today, yesterday));
        gbv_day.setOnGroupBtnClickListener(new GroupButtonView.OnGroupBtnClickListener() {
            @Override
            public void groupBtnClick(String code) {
                if(code.equals("type_otherday")){
                    Intent intent  = new Intent();
                    intent.setClass(MenuQueryUpdate.this.getContext(), CalendarUI.class);
                    startActivity(intent);
                }
               /* if(code.equals("type_today")){
                    String today;
                    String yesterday;
                    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                    Calendar calendar = Calendar.getInstance();
                    today = (calendar.get(Calendar.MONTH)+1) + "月"//从0计算
                            + calendar.get(Calendar.DAY_OF_MONTH) + "日";
                    yesterday = getOldDate(1);
                    EventBus.getDefault().post(new MessageEvent(today, yesterday));
                }*/
            }
        });

        gbv_day.mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup rg, int i) {
                //RadioButton rb = (RadioButton)rg.findViewById(i);
                /*if (rb.isChecked()) {

                }*/
                if(i==1){
                    final RadioButton rb = (RadioButton)rg.findViewById(1);
                    /*Intent intent  = new Intent();
                    intent.setClass(MenuQueryUpdate.this.getContext(), CalendarUI.class);
                    startActivity(intent);*/
                    CalendarUI dialog = new CalendarUI(getContext(), new CalendarUI.OnEditInputFinishedListener(){
                        @Override
                        public void editInputFinished(String password) {
                            //tvPasswordResul.setText(password);
                            rb.setText(password);
                        }
                    });

                    dialog.setView(new EditText(getContext()));  //若对话框无法弹出输入法，加上这句话
                    dialog.show();
                }
            }
        });
    }



}
