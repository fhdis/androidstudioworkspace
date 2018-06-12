package com.example.administrator.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LeftAdapter extends BaseAdapter {

    private Context context;
    String data[] = {"蔬菜1", "水果1", "姓氏1", "蔬菜2", "水果2", "姓氏2",
            "蔬菜3", "水果3", "姓氏3", "蔬菜4", "水果4", "姓氏4","蔬菜5", "水果5", "姓氏5"};
    private double mSelect;

    public LeftAdapter(Context context) {
        super();
        this.context = context;
    }


    public void changeSelected(int positon){ //刷新方法
        if(positon != mSelect){
            mSelect = positon;
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder ;
        if (convertView==null){
            convertView = View.inflate(context, R.layout.item_left, null);
            viewHolder = new ViewHolder();
            viewHolder.llBc = (LinearLayout) convertView.findViewById(R.id.ll_bc);
            viewHolder.tvLeft = (TextView) convertView.findViewById(R.id.tv_left);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.tvLeft.setText(data[position]);
        if(mSelect ==position){
            viewHolder.llBc.setBackgroundResource(R.color.white);  //选中项背景
        }else{
            viewHolder.llBc.setBackgroundResource(R.color.green_dark);  //其他项背景
        }
        return convertView;
    }


    class ViewHolder{
       // @Bind(R.id.ll_bc)
       // LinearLayout llBc;
      //  @Bind(R.id.tv_left)
       // TextView tvLeft;
       LinearLayout llBc;
       TextView tvLeft;
    }

}
