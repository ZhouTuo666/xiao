package indi.tuo.xiao.base.model.result;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * user group result
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GroupResult {

  @NonNull
  private String recordId;
  /**
   * register name
   */
  @NonNull
  private String registerName;
  /**
   * user count of group
   */
  @NonNull
  private Integer userCount;
  /**
   * user count of initial
   */
  @NonNull
  private Integer initialUsers;
  /**
   * online users
   */
  @NonNull
  private Integer onlineUsers;
  /**
   * active users
   */
  @NonNull
  private Integer activeUsers;
  /**
   * finish users
   */
  @NonNull
  private Integer finishUsers;
  /**
   * reduce users
   */
  @NonNull
  private Integer reduceUsers;
  /**
   * Whether to start
   */
  private boolean userStarted;
  /**
   * timestamp
   */
  @NonNull
  private Instant ts;

}
