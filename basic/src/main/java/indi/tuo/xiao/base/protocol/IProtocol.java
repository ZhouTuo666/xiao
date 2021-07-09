package indi.tuo.xiao.base.protocol;

/**
 * protocol
 */
public interface IProtocol {

  /**
   * get request class
   *
   * @return request call
   */
  Class<? extends IRequest<?>> getRequestClass();

  /**
   * get response class
   *
   * @return response class
   */
  Class<? extends IResponse> getResponseClass();

  /**
   * get config class
   *
   * @return config class
   */
  Class<? extends IConfig> getConfigClass();
}
