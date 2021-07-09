package indi.tuo.xiao.base.assertion;

import indi.tuo.xiao.base.protocol.IResponse;

/**
 * Assertion
 */
public interface IAssertion {

  /**
   * Assert the response matches
   *
   * @param response response object
   * @return Returns true if it matches, otherwise false
   */
  boolean check(IResponse response);

  /**
   * Assertion name
   *
   * @return Assertion name
   */
  String name();

  /**
   * Get assertion expression
   *
   * @return assertion expression
   */
  String getExpression();

  /**
   * Get the field name of response
   *
   * @return field name of response
   */
  String getFieldName();
}
