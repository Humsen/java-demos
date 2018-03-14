package cn.thinglin.dubbodemo.service.impl;


import cn.thinglin.dubbodemo.service.TestService;

/**
 * Created by mac on 2017/3/20.
 */
public class TestServiceImpl implements TestService {


    public void test() {
        System.out.println("---TestServiceImpl test()----服务被调用----------");
    }

    public String testString(String str) {
        System.out.println("---TestServiceImpl testString("+str+")----服务被调用----------");
        return "还给你："+str;
    }
}
