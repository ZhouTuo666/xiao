package indi.tuo.xiao.base.exception;

import indi.tuo.xiao.base.protocol.IResponse;
import lombok.Getter;

@Getter
public class ResponseException extends BaseException {

  protected IResponse response;

  public ResponseException(String message, IResponse response) {
    super(message);
    this.response = response;
  }

  public ResponseException(String message, Throwable cause, IResponse response) {
    super(message, cause);
    this.response = response;
  }

  public ResponseException(String message) {
    super(message);
  }
}
