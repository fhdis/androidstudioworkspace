package com.example.administrator.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class OrderDealAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<OrderDealModel> mDatas;

    public OrderDealAdapter(Context context, List<OrderDealModel> datas) {
                 mInflater = LayoutInflater.from(context);
                 mDatas = datas;
    }

    @Override
     public int getCount() {
        return mDatas.size();
     }

    @Override
     public Object getItem(int position) {
        return mDatas.get(position);
     }

    @Override
    public long getItemId(int position) {
                 return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.order_deal_lits_item, parent, false); //加载布局
            holder = new ViewHolder();
            holder.order_xuhao = (TextView)convertView.findViewById(R.id.order_xuhao);
            holder.order_time = (TextView)convertView.findViewById(R.id.order_time);
            holder.order_name = (TextView)convertView.findViewById(R.id.order_name);
            holder.bt_order_deal_status = (Button)convertView.findViewById(R.id.bt_order_deal_status);
            convertView.setTag(holder);
            } else {   //else里面说明，convertView已经被复用了，说明convertView中已经设置过tag了，即holder
                holder = (ViewHolder) convertView.getTag();
        }

        OrderDealModel bean = mDatas.get(position);
        holder.order_xuhao.setText(bean.getOrder_id());
        holder.order_time.setText(bean.getOrder_time());
        holder.order_name.setText(bean.getOrder_name());
        holder.bt_order_deal_status.setText(bean.getBt_order_deal_status());

        return convertView;
    }

    private class ViewHolder {
         TextView order_xuhao;
         TextView order_time;
         TextView order_name;
         Button bt_order_deal_status;
     }
}
