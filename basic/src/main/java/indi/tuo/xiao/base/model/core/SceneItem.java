package indi.tuo.xiao.base.model.core;

import indi.tuo.xiao.base.protocol.IConfig;
import java.util.Map;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * 场景项
 */
public class SceneItem {
  /**
   * 场景项的id，用来区分不同的场景项
   */
  @NonNull
  private String id;
  /**
   * 场景项名称，与实际用户名一致
   */
  @NonNull
  private String name;

  /**
   * 场景项对应的用例
   */
  @NonNull
  private Case caze;

  /**
   * 并发用户数
   */
  @Setter
  private int userCount;

  /**
   * 步长起点
   */
  private Integer stepStart;

  /**
   * 步长终点
   */
  private Integer stepEnd;

  /**
   * 设置的QPS，非稳定QPS时为预估的QPS
   */
  @Setter
  private double qps;

  /**
   * 动态调整的策略，key为距离场景开始的时长（毫秒），value为调整的用户数（可以为负值）
   */
  @NonNull
  @Getter
  private Map<Integer, Integer> adjustStrategy;

  /**
   * 协议配置
   */
  @NonNull
  private IConfig config;

  /**
   * 成功百分比
   */
  private double successPct;

  /**
   * 最大平均响应时间
   */
  private int maxAvgLatency;
}
