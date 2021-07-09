package indi.tuo.xiao.base.protocol;

import java.util.Map;
import lombok.Getter;

/**
 * Wrong output, the collector parses the error according to the object
 */
@Getter
public class ErrorResponse implements IResponse {

  private String type;

  private String stackTrace;

  public ErrorResponse(String type, String stackTrace) {
    this.type = type;
    this.stackTrace = stackTrace;
  }

  public ErrorResponse() {
    this("", "");
  }

  @Override
  public String type() {
    return type;
  }

  @Override
  public Map<String, String> toMap() {
    return null;
  }

  @Override
  public int getTime() {
    return -1;
  }

  @Override
  public void setTime(int time) {
  }
}
