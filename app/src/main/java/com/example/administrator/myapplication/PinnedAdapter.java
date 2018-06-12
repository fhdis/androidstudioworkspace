package com.example.administrator.myapplication;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class PinnedAdapter extends BaseAdapter {
    //头部隐藏
    public static final int PINNED_HEADER_GONE = 0;
    //显示
    public static final int PINNED_HEADER_VISIBLE = 1;
    //上移
    public static final int PINNED_HEADER_PUSHED_UP = 2;
    private Context context;
    private ArrayList<DoubleListBean> data = new ArrayList<>();
    public PinnedAdapter(Context context) {
        super();
        this.context = context;
    }
    /**
     * 这个方法是用来更新数据源
     */
    public void updateData(ArrayList<DoubleListBean> lists) {
        data.clear();
        data.addAll(lists);
        this.notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return data.size();
    }
    @Override
    public Object getItem(int position) {
        return data.get(position);
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_right, null);
            vh = new ViewHolder();
            vh.tvRight = (TextView) convertView.findViewById(R.id.tv_right);
            vh.tvContent = (TextView) convertView.findViewById(R.id.tv_content);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        //内容
        vh.tvContent.setText(data.get(position).getName());
        if (position == 0) {//如果是第一个  需要显示标题
            vh.tvRight.setVisibility(View.VISIBLE);
            vh.tvRight.setText(data.get(position).getTitle());
            //如果这个标题和上一个不一样   也需要将标题显示出来
        } else if (!TextUtils.equals(data.get(position).getTitle(), data.get(position - 1).getTitle())) {
            vh.tvRight.setVisibility(View.VISIBLE);
            vh.tvRight.setText(data.get(position).getTitle());
        } else {
            vh.tvRight.setVisibility(View.GONE);
        }
        return convertView;
    }
    //获取HeaderView的状态
    public int getPinnedHeaderState(int position) {
        if (position < 0) {
            return PINNED_HEADER_GONE;
        }
        //当条目标题和上一个标题不同的时候，显示上移
        if (position!=0&&!TextUtils.equals(data.get(position).getTitle(), data.get(position +1).getTitle())) {
            return PINNED_HEADER_PUSHED_UP;
        }
        return PINNED_HEADER_VISIBLE;
    }
    //设置HeaderView的内容
    public void configurePinnedHeader(View header, int position) {
        DoubleListBean item = (DoubleListBean) getItem(position);
        if (item!=null) {
            if (header instanceof TextView) {
                ((TextView) header).setText(item.getTitle());
            }
        }
    }
    class ViewHolder{
       /* @Bind(R.id.tv_right)
        TextView tvRight;
        @Bind(R.id.tv_content)
        TextView tvContent;
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }*/
        TextView tvRight;
        TextView tvContent;
    }
}
