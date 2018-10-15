package pers.husen.test.business;

import pers.husen.test.business.intf.BusinessOper;

/**
 * 业务实现类
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年10月16日 上午12:40:09
 */
public class BusinessOperImpl implements BusinessOper {

  @Override
  public String doSomething() {
    System.out.println("======== 调用业务方法   ================");

    return "业务调用成功";
  }
}
