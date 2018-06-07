package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FirstFragment extends Fragment {
    //private String context;
    //private TextView mTextView;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Fragment[] mFragmentArrays = new Fragment[5];
    private String[] mTabTitles = new String[5];
    private android.support.v4.app.FragmentManager  fragmentManager;
    public  FirstFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment,container,false);
        //mTextView = (TextView)view.findViewById(R.id.txt_content);
        //mTextView = (TextView)getActivity().findViewById(R.id.txt_content);
        //mTextView.setText(context);
        tabLayout = (TabLayout) view.findViewById(R.id.tablayout);
        viewPager = (ViewPager) view.findViewById(R.id.tab_viewpager);

        //initView();
        return view;
    }

    //initView() 放在onActivityCreated方法中
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }
    private void initView() {
        mTabTitles[0] = "新订单";
        mTabTitles[1] = "配送异常";
        mTabTitles[2] = "催单";
        mTabTitles[3] = "取消订单";
        mTabTitles[4] = "售后退款";
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        //设置tablayout距离上下左右的距离
        //tab_title.setPadding(20,20,20,20);
        mFragmentArrays[0] = TabFragment.newInstance();
        mFragmentArrays[1] = TabFragment.newInstance();
        mFragmentArrays[2] = TabFragment.newInstance();
        mFragmentArrays[3] = TabFragment.newInstance();
        mFragmentArrays[4] = TabFragment.newInstance();
        fragmentManager = getChildFragmentManager();
        PagerAdapter pagerAdapter = new MyViewPagerAdapter(fragmentManager);
        viewPager.setAdapter(pagerAdapter);
        //将ViewPager和TabLayout绑定
        tabLayout.setupWithViewPager(viewPager);
    }

    final class MyViewPagerAdapter extends FragmentPagerAdapter {
        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentArrays[position];
        }


        @Override
        public int getCount() {
            return mFragmentArrays.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTabTitles[position];

        }
    }
}

