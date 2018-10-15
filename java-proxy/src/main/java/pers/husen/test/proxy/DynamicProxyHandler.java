package pers.husen.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import pers.husen.test.proxy.action.InterceptorAction;

public class DynamicProxyHandler implements InvocationHandler {
  // 声明被代理对象
  private Object targetProxyObj;

  // 创建拦截器
  private InterceptorAction interceptor;

  /**
   * 动态生成一个代理类对象，并绑定被代理类和代理处理器。
   *
   * @param business
   * @return 代理类对象
   */
  public Object bind(Object targetProxyObj) {
    this.targetProxyObj = targetProxyObj;
    interceptor = new InterceptorAction();

    /**
     * Proxy.newProxyInstance(参数1, 参数2, 参数3)
     *
     * <p>参数1, 表示被代理类的 ClassLoader 参数2, 表示被代理的接口 参数3, 表示代理处理器对象
     *
     * <p>该方法，返回代理实例
     */
    return Proxy.newProxyInstance(
        targetProxyObj.getClass().getClassLoader(),
        targetProxyObj.getClass().getInterfaces(),
        this);
  }

  /**
   * 代理需要调用的方法，并在该方法调用前后，先调用连接器的方法。
   *
   * @param proxy 代理类对象
   * @param method 被代理的接口方法
   * @param args 被代理接口方法的参数
   * @return 方法调用返回的结果
   * @throws Throwable
   */
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    Object result = null;

    interceptor.before();
    result = method.invoke(targetProxyObj, args);
    interceptor.after();

    return result;
  }
}
