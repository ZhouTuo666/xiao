package indi.tuo.xiao.base.assertion.impl;

import indi.tuo.xiao.base.assertion.AbstractAssertion;
import indi.tuo.xiao.base.protocol.IResponse;

public class ContainAssertion extends AbstractAssertion {

  @Override
  protected boolean internalCheck(String content, String expression) {
    return false;
  }

  @Override
  protected String getFieldContent(IResponse response) {
    return null;
  }

  @Override
  public String name() {
    return "contain";
  }
}
