package indi.tuo.xiao.base.exception;


public class BaseException extends Exception {

  public BaseException() {
  }

  public BaseException(String message) {
    super(message);
  }

  public BaseException(String message, Throwable cause) {
    super(message, cause);
  }

  public BaseException(Throwable cause) {
    super(cause);
  }
}
