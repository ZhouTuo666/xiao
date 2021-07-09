package indi.tuo.xiao.base.model.result;

import indi.tuo.xiao.base.protocol.IResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Sample Result
 */
@Getter
@NoArgsConstructor
public class SampleResult {

  /**
   * Response time, unit: milliseconds
   */
  private int time;

  /**
   * type of response
   */
  private String type;

  public SampleResult(IResponse response) {
    this.time = response.getTime();
    this.type = response.type();
  }
}
