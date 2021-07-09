package indi.tuo.xiao.base.response;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Rest response
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestResponse implements Serializable {

  private int code;

  private String message;

  private Object data;

  public static RestResponse success() {
    RestResponse restResponse = new RestResponse();
    restResponse.setResponseCode(ResponseCode.SUCCESS);
    return restResponse;
  }

  public static RestResponse success(String message) {
    RestResponse restResponse = new RestResponse();
    restResponse.setCode(ResponseCode.SUCCESS.getCode());
    restResponse.setMessage(message);
    return restResponse;
  }

  public static RestResponse success(Object data) {
    RestResponse restResponse = new RestResponse();
    restResponse.setResponseCode(ResponseCode.SUCCESS);
    restResponse.setData(data);
    return restResponse;
  }

  public static RestResponse resourcesNotExist() {
    RestResponse restResponse = new RestResponse();
    restResponse.setResponseCode(ResponseCode.RESOURCES_NOT_EXIST);
    return restResponse;
  }

  public static RestResponse processing() {
    RestResponse restResponse = new RestResponse();
    restResponse.setResponseCode(ResponseCode.PROCESSING);
    return restResponse;
  }

  private void setResponseCode(ResponseCode responseCode) {
    this.code = responseCode.getCode();
    this.message = responseCode.getMessage();
  }
}
