package indi.tuo.xiao.base.model.core;

import java.util.List;
import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * script, contains samples
 */
@Getter
@NoArgsConstructor
public class Script {

  /**
   * script name
   */
  @NonNull
  private String name;

  /**
   * sample list
   */
  @NonNull
  private List<Sample> samples;

  /**
   * Set of variable IDs
   */
  private Set<String> variableIds;

  /**
   * Set of associated variable IDs
   */
  private Set<String> refVariableIds;
}
