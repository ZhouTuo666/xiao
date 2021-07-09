package indi.tuo.xiao.base.model.core;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Test case, contains multiple scripts
 */
@Getter
@NoArgsConstructor
public class Case {

  /**
   * case name
   */
  @NonNull
  private String name;

  /**
   * protocol class name
   */
  @NonNull
  private String protocolClass;

  /**
   * setup scripts
   */
  @NonNull
  private List<Script> setup;

  /**
   * loop scripts
   */
  @NonNull
  private List<Script> action;

  /**
   * teardown scripts
   */
  @NonNull
  private List<Script> teardown;
}
