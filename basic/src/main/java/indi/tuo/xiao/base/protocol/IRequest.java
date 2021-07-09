package indi.tuo.xiao.base.protocol;

import indi.tuo.xiao.base.exception.RequestException;
import indi.tuo.xiao.base.exception.ResponseException;
import java.util.Map;

/**
 * request interface
 *
 * @param <C> config class
 */
public interface IRequest<C extends IConfig> {

  /**
   * Replace variable value into request
   *
   * @param variableValues variable values
   */
  void replaceVariable(Map<String, String> variableValues);

  /**
   * send object
   *
   * @param config protocol name
   * @return response
   */
  IResponse send(C config) throws RequestException, ResponseException;

  /**
   * deep clone request
   *
   * @return request clone
   */
  IRequest<?> deepClone();
}
