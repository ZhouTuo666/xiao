package indi.tuo.xiao.base.assertion;

import indi.tuo.xiao.base.protocol.IResponse;
import lombok.Getter;

public abstract class AbstractAssertion implements IAssertion {

  /**
   * Assertion of field names
   */
  private String fieldName;
  /**
   * Expressions for the assertion
   */
  private String expression;

  @Getter
  private final String _type = this.getClass().getName();

  public AbstractAssertion(String expression, String fieldName) {
    this.expression = expression;
    this.fieldName = fieldName;
  }

  protected AbstractAssertion() {
    this("", "");
  }

  /**
   * Assert the content is legal
   *
   * @param content    content
   * @param expression expression
   * @return pass return true
   */
  protected abstract boolean internalCheck(String content, String expression);

  /**
   * Get the content of the response assertion field
   *
   * @param response response
   * @return the content
   */
  protected abstract String getFieldContent(IResponse response);

  @Override
  public boolean check(IResponse response) {
    return internalCheck(getFieldContent(response), expression);
  }

  @Override
  public String toString() {
    return name() + " assertion " + expression;
  }

  @Override
  public String getExpression() {
    return expression;
  }

  @Override
  public String getFieldName() {
    return fieldName;
  }
}
