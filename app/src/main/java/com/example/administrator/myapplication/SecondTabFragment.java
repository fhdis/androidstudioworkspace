package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

public class SecondTabFragment extends Fragment {
    private CalendarView calendarView;

    public static Fragment newInstance() {
        SecondTabFragment fragment = new SecondTabFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tab_order_query, container, false);
        //calendarView = (CalendarView) rootView.findViewById(R.id.calendarViewId);

        return rootView;
    }





}
