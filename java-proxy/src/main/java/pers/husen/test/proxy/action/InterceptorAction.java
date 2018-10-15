package pers.husen.test.proxy.action;

/**
 * 拦截前后的操作
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年10月16日 上午12:41:45
 */
public class InterceptorAction {
  // 在 action 之前调用
  public void before() {
    System.out.println("在拦截器 InterceptorClass 中调用方法: before()");
  }

  // 在 action 之后调用
  public void after() {
    System.out.println("在拦截器 InterceptorClass 中调用方法: after()");
  }
}
