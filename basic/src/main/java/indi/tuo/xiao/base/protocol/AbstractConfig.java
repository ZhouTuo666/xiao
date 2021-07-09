package indi.tuo.xiao.base.protocol;


import lombok.Getter;

/**
 * AbstractConfig
 */
public abstract class AbstractConfig implements IConfig {

  /**
   * use in Deserialization
   */
  @Getter
  private final String _type = this.getClass().getName();

}
