package indi.tuo.xiao.base.model.core;

import indi.tuo.xiao.base.assertion.IAssertion;
import indi.tuo.xiao.base.protocol.IRequest;
import indi.tuo.xiao.base.protocol.IResponse;
import java.util.List;
import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Sample, contains one request and one response
 */
@Getter
@NoArgsConstructor
public class Sample {
  /**
   * sample name
   */
  @NonNull
  private String name;

  /**
   * request
   */
  @NonNull
  private IRequest request;

  /**
   * response
   */
  private IResponse response;

  /**
   * assertion list
   */
  @NonNull
  private List<IAssertion> assertions;
}
