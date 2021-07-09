package indi.tuo.xiao.base.response;

import lombok.Getter;

/**
 * response code
 **/
@Getter
public enum ResponseCode {
  /**
   * success
   */
  SUCCESS(10000, "success"),
  /**
   * processing
   */
  PROCESSING(10001, "processing"),
  /**
   * invalid token
   */
  TOKEN_INVALID(40001, "Token is null or invalid"),
  /**
   * access denied
   */
  ACCESS_DENIED(40003, "Access denied"),
  /**
   * Resources does not exist
   */
  RESOURCES_NOT_EXIST(40004, "Resources does not exist"),
  /**
   * scene run error
   */
  SCENE_ERROR(40005, "Scene can not %s, current state is %s"),
  /**
   * service error
   */
  SERVICE_ERROR(50000, "Service exception");

  /**
   * status code
   */
  private final int code;
  /**
   * message
   */
  private final String message;

  ResponseCode(int code, String msg) {
    this.code = code;
    this.message = msg;
  }
}
