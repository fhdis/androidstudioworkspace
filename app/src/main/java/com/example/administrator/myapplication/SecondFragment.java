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

public class SecondFragment extends Fragment {
    //private String context;
    //private TextView mTextView;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Fragment[] mFragmentArrays = new Fragment[5];
    private String[] mTabTitles = new String[5];
    private android.support.v4.app.FragmentManager  fragmentManager;
    public  SecondFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_fragment,container,false);
        //mTextView = (TextView)view.findViewById(R.id.txt_content);
        //mTextView = (TextView)getActivity().findViewById(R.id.txt_content);
        //mTextView.setText(context);
        tabLayout = (TabLayout) view.findViewById(R.id.tablayout);
        viewPager = (ViewPager) view.findViewById(R.id.tab_viewpager);


        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }


    private void initView() {
        mTabTitles[0] = "全部";
        mTabTitles[1] = "进行中";
        mTabTitles[2] = "已完成";
        mTabTitles[3] = "已取消/退单";
        mTabTitles[4] = "索赔";
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        //设置tablayout距离上下左右的距离
        //tab_title.setPadding(20,20,20,20);
        mFragmentArrays[0] = SecondTabFragment.newInstance();
        mFragmentArrays[1] = SecondTabFragment.newInstance();
        mFragmentArrays[2] = SecondTabFragment.newInstance();
        mFragmentArrays[3] = SecondTabFragment.newInstance();
        mFragmentArrays[4] = SecondTabFragment.newInstance();
        fragmentManager = getChildFragmentManager();
        PagerAdapter pagerAdapter = new SecondFragment.MyViewPagerAdapter(fragmentManager);
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

