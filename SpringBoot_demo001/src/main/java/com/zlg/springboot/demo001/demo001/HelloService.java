package com.zlg.springboot.demo001.demo001;

public class HelloService {
    private String msg;

    public String sayHello(){
        return "Hello  "+ msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
