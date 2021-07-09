package indi.tuo.xiao.base.protocol;

import java.util.Map;

/**
 * response interface
 */
public interface IResponse {

  /**
   * response type
   */
  String type();

  /**
   * Convert to map, disassemble the output into multiple parts
   */
  Map<String, String> toMap();

  /**
   * Get response time
   *
   * @return return -1 for failure
   */
  int getTime();

  /**
   * set response time
   */
  void setTime(int time);
}
