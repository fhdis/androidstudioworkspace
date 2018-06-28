package com.example.administrator.myapplication;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.util.Log;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
   // private TextView topBar;
    private TextView tabDeal;
    private TextView tabPoi;
    private TextView tabMore;
    private TextView tabUser;

    private FrameLayout ly_content;

   // private FirstFragment f1;
    private MenuDeal f1;
    //private MenuQuery f2;
    private MenuQueryUpdate f2;
    private ThirdFragment f3;
    private FouthFragment f4;

    private FragmentManager fragmentManager;
    //private FragmentTransaction transaction = getFragmentManager().beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linearlayout_exam);
        bindView();

        FragmentTransaction transaction1 =getSupportFragmentManager().beginTransaction();
        if(f1==null) {
            tabDeal.setSelected(true);
            f1 = new MenuDeal();
            //FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction1.add(R.id.fragment_container, f1);
        }else {
            transaction1.show(f1);
        }
        Log.d("BBBB","MainActivity="+"onCreate");
       transaction1.commit();
       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    //UI组件初始化与事件绑定
    private void bindView() {
       // topBar = (TextView)this.findViewById(R.id.txt_top);
        tabDeal = (TextView)this.findViewById(R.id.txt_deal);
        tabPoi = (TextView)this.findViewById(R.id.txt_poi);
        tabUser = (TextView)this.findViewById(R.id.txt_user);
        tabMore = (TextView)this.findViewById(R.id.txt_more);
        ly_content = (FrameLayout) findViewById(R.id.fragment_container);

        tabDeal.setOnClickListener(this);
        tabMore.setOnClickListener(this);
        tabUser.setOnClickListener(this);
        tabPoi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        hideAllFragment(transaction);
        switch(v.getId()){
            case R.id.txt_deal:
                selected();
                tabDeal.setSelected(true);
                if(f1==null){
                   // f1 = new FirstFragment();
                    f1 = new MenuDeal();
                    transaction.add(R.id.fragment_container,f1);
                }else{
                    transaction.show(f1);
                }
                break;

            case R.id.txt_more:
                selected();
                tabMore.setSelected(true);
                if(f4==null){
                    f4 = new FouthFragment();
                    transaction.add(R.id.fragment_container,f4);
                }else{
                    transaction.show(f4);
                }
                break;

            case R.id.txt_poi:
                selected();
                tabPoi.setSelected(true);
                if(f2==null){
                    //f2 = new MenuQuery();
                    f2 = new MenuQueryUpdate();
                    transaction.add(R.id.fragment_container,f2);
                }else{
                    transaction.show(f2);
                }
                break;

            case R.id.txt_user:
                selected();
                tabUser.setSelected(true);
                if(f3==null){
                    f3 = new ThirdFragment();
                    transaction.add(R.id.fragment_container,f3);
                }else{
                    transaction.show(f3);
                }
                break;
        }
        transaction.commit();
    }


    //重置所有文本的选中状态
    public void selected(){
        tabDeal.setSelected(false);
        tabMore.setSelected(false);
        tabPoi.setSelected(false);
        tabUser.setSelected(false);
    }

    //隐藏所有Fragment
    public void hideAllFragment(FragmentTransaction transaction){
        if(f1!=null){
            transaction.hide(f1);
        }
        if(f2!=null){
            transaction.hide(f2);
        }
        if(f3!=null){
            transaction.hide(f3);
        }
        if(f4!=null){
            transaction.hide(f4);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }
}
