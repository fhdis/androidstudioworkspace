package com.example.administrator.myapplication;

public class DoubleListBean {
    private String name;
    private int type;// 类型 后边要根据类型显示标题
    private String title;

    public DoubleListBean(String name, int type, String title) {
        super();
        this.name = name;
        this.type = type;
        this.title = title;
    }

    public DoubleListBean() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
