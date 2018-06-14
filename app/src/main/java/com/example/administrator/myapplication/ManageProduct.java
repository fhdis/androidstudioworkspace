package com.example.administrator.myapplication;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ManageProduct extends AppCompatActivity {
    private Button bt_manage_classify;
    private Button bt_manage_sort;
    private Button bt_mamage_new;
    private ListView  lvLeft;
    private PinnedHeaderListview  lvRight;

    private ArrayList<DoubleListBean> lists;
    private int position;
    private LeftAdapter leftAdapter;


    String titles[] = {"蔬菜1", "水果1", "姓氏1", "蔬菜2", "水果2", "姓氏2", "蔬菜3",
            "水果3", "姓氏3", "蔬菜4", "水果4", "姓氏4", "蔬菜5", "水果5", "姓氏5"};
    String name1[] = {"萝卜", "大葱", "茄子", "大蒜", "生姜", "萝卜", "大葱", "茄子",
            "大蒜", "生姜", "萝卜", "大葱"};
    String name2[] = {"苹果", "梨", "香蕉", "西瓜", "橘子", "大枣", "菠萝", "红提", "葡萄",
            "樱桃", "椰子"};
    String name3[] = {"郑", "王", "伊", "荆", "汤", "王", "孙", "李", "钱", "赵",
            "祁", "韦", "宏"};;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_product);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("全部商品");
        //setSupportActionBar(toolbar);https://blog.csdn.net/zhaozhuzi/article/details/76280627
        toolbar.setNavigationIcon(R.mipmap.ic_menu_back);
        bt_manage_classify = (Button)findViewById(R.id.bt_manage_classify);
        bt_manage_sort = (Button)findViewById(R.id.bt_manage_sort);
        bt_mamage_new = (Button)findViewById(R.id.bt_mamage_new);
        lvLeft = (ListView)findViewById(R.id.lv_left);
        lvRight = (PinnedHeaderListview)findViewById(R.id.lv_Right);

        initData();
        initView();
        initListener();
        bt_manage_classify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManageProduct.this,ManagementClassification.class);
                // intent.setAction("com.google.product");
                startActivity(intent);
            }
        });

        bt_manage_sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManageProduct.this,ManagementClassification.class);
                // intent.setAction("com.google.product");
                startActivity(intent);
            }
        });

        bt_mamage_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManageProduct.this,NewGoods.class);
                // intent.setAction("com.google.product");
                startActivity(intent);
            }
        });
    }

    private void initData() {
        //弄点数据
        lists = new ArrayList<>();
        for (int i = 0; i < name1.length; i++) {
            lists.add(new DoubleListBean(name1[i] + 1, i, titles[0]));
        }
        for (int i = 0; i < name2.length; i++) {
            lists.add(new DoubleListBean(name2[i] + 1, i, titles[1]));
        }
        for (int i = 0; i < name3.length; i++) {
            lists.add(new DoubleListBean(name3[i] + 1, i, titles[2]));
        }
        for (int i = 0; i < name1.length; i++) {
            lists.add(new DoubleListBean(name1[i] + 2, i, titles[3]));
        }
        for (int i = 0; i < name2.length; i++) {
            lists.add(new DoubleListBean(name2[i] + 2, i, titles[4]));
        }
        for (int i = 0; i < name3.length; i++) {
            lists.add(new DoubleListBean(name3[i] + 2, i, titles[5]));
        }
        for (int i = 0; i < name1.length; i++) {
            lists.add(new DoubleListBean(name1[i] + 3, i, titles[6]));
        }
        for (int i = 0; i < name2.length; i++) {
            lists.add(new DoubleListBean(name2[i] + 3, i, titles[7]));
        }
        for (int i = 0; i < name3.length; i++) {
            lists.add(new DoubleListBean(name3[i] + 3, i, titles[8]));
        }
        for (int i = 0; i < name1.length; i++) {
            lists.add(new DoubleListBean(name1[i] + 4, i, titles[9]));
        }
        for (int i = 0; i < name2.length; i++) {
            lists.add(new DoubleListBean(name2[i] + 4, i, titles[10]));
        }
        for (int i = 0; i < name3.length; i++) {
            lists.add(new DoubleListBean(name3[i] + 4, i, titles[11]));
        }
        for (int i = 0; i < name1.length; i++) {
            lists.add(new DoubleListBean(name1[i] + 5, i, titles[12]));
        }
        for (int i = 0; i < name2.length; i++) {
            lists.add(new DoubleListBean(name2[i] + 5, i, titles[13]));
        }
        for (int i = 0; i < name3.length; i++) {
            lists.add(new DoubleListBean(name3[i] + 5, i, titles[14]));
        }
    }


    private void initView() {
        //左边
        leftAdapter = new LeftAdapter(this);
        lvLeft.setAdapter(leftAdapter);
        //右边
        PinnedAdapter rightAdapter = new PinnedAdapter(this);
        // 将数据源传递给Listview
        rightAdapter.updateData(lists);
        lvRight.setAdapter(rightAdapter);
        //设置头部的条目
        lvRight.setPinnedHeaderView(getHeaderView());
    }

    private View getHeaderView() {
        //头部是个TextView，不能用view.inflate加载布局,会测量不出宽高
        TextView itemView = new TextView(this);
        itemView.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                70));
        itemView.setGravity(Gravity.CENTER);
        itemView.setBackgroundColor(getResources().getColor(R.color.green));
        itemView.setTextSize(18);
        itemView.setTextColor(Color.BLACK);
        itemView.setPadding(0, 0, 0, itemView.getPaddingBottom());
        return itemView;
    }

    private void initListener() {
        //右边是滚动监听
        lvRight.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }
            @Override
            public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                //滚动确定替换条目
                lvRight.configureHeaderView(firstVisibleItem);
                //获取到第一个条目的类型
                String title = lists.get(firstVisibleItem).getTitle();
                //遍历左边列表数据集合，获取到当前类型的索引
                for (int i = 0; i < titles.length; i++) {
                    if (titles[i] == title) {
                        position = i;
                    }
                }
                //左边滚动到条目
                lvLeft.smoothScrollToPosition(position);
                //改变选择的颜色和背景
                leftAdapter.changeSelected(position);
            }
        });
        //左边的点击监听
        lvLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                for (int j = 0; j < lists.size(); j++) {
                    //左边当前标题和右边标题相同时，获取右边的索引
                    if (titles[i] == lists.get(j).getTitle()) {
                        position = j;
                        break;
                    }

                }
                //右边listview选择当前条目
                lvRight.setSelection(position);
                //左边文字的颜色和背景
                leftAdapter.changeSelected(position);
            }
        });

    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }
}
