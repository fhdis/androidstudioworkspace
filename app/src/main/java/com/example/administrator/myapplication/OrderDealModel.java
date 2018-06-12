package com.example.administrator.myapplication;

public class OrderDealModel {
    private String order_id;
    private String order_time;
    private String order_name;
    private String bt_order_deal_status;

    public OrderDealModel(){

    }
    public OrderDealModel(String order_id,String order_time,String order_name,String bt_order_deal_status){
        this.order_id = order_id;
        this.order_time = order_time;
        this.order_name = order_name;
        this.bt_order_deal_status = bt_order_deal_status;
    }

    public String getOrder_id(){
        return order_id;
    }

    public String getOrder_time(){
       return order_time;
    }

    public String getOrder_name(){
      return order_name;
    }

    public String getBt_order_deal_status(){
        return bt_order_deal_status;
    }

    public void setOrder_id(String order_id){
       this.order_id = order_id;
    }

    public void setOrder_time(String order_time){
       this.order_time = order_time;
    }

    public void setOrder_name(String order_name){
      this.order_name = order_name;
    }

    public void setBt_order_deal_status(String order_deal_status){
      this.bt_order_deal_status = order_deal_status;
    }
}
