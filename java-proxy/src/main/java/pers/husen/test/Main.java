package pers.husen.test;

import pers.husen.test.business.BusinessOperImpl;
import pers.husen.test.business.intf.BusinessOper;
import pers.husen.test.proxy.DynamicProxyHandler;

public class Main {
  public static void main(String args[]) {
    // 创建动态代理处理工具
    DynamicProxyHandler handler = new DynamicProxyHandler();

    // 创建业务组件对象
    BusinessOper business = new BusinessOperImpl();

    // 创建业务组件对象，并用动态代理绑定代理类
    BusinessOper businessProxy = (BusinessOper) handler.bind(business);

    // 调用业务组件中的方法，演示拦截器效果
    businessProxy.doSomething();
  }
}
