package com.jiubao.rxjavasample.model;

/**
 * Created by Administrator on 2017/12/4.
 */

public class FakeToken {
    public String token;
    public boolean expired;

    public FakeToken(){
    }

    public FakeToken(boolean expired){
        this.expired = expired;
    }
}
