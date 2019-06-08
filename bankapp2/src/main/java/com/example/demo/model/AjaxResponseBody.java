package com.example.demo.model;

import com.example.demo.model.GoldenCow;

public class AjaxResponseBody {

    public AjaxResponseBody() {
        this.msg = msg;
        this.cow = cow;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public GoldenCow getCow() {
        return cow;
    }

    public void setCow(GoldenCow cow) {
        this.cow = cow;
    }


    private String msg;
    private GoldenCow cow;
}
