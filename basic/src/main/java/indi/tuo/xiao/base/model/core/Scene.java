package indi.tuo.xiao.base.model.core;

import indi.tuo.xiao.base.variable.IVariable;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * Scene, contains scene item
 */
public class Scene {

  /**
   * loop type: time
   */
  public static final int LOOP_TYPE_ALL_TIME = 0;
  /**
   * loop type: count per user
   */
  public static final int LOOP_TYPE_USER_COUNT = 1;

  /**
   * scene id
   */
  @Nonnull
  private String id;

  /**
   * scene name
   */
  @Nonnull
  private String name;

  /**
   * loop type
   */
  @Nonnull
  private Integer loopType;

  /**
   * loop count
   */
  @Nonnull
  private Long loopCount;

  /**
   * start interval, in milliseconds
   */
  @Nonnull
  private Integer startInterval;

  /**
   * start user count
   */
  @Nonnull
  private Integer startCount;

  /**
   * stop interval, in milliseconds
   */
  @Nonnull
  private Integer stopInterval;

  /**
   * stop user count
   */
  @Nonnull
  private Integer stopCount;

  /**
   * keep stable QPS
   */
  private boolean stableQps;

  /**
   * scene item list
   */
  @Nonnull
  private List<SceneItem> sceneItems;

  /**
   * pre scene item list
   */
  private List<SceneItem> preSceneItems;

  /**
   * post scene item list
   */
  private List<SceneItem> postSceneItems;

  /**
   * list of all variables in the scene
   */
  @Nonnull
  private List<IVariable> variableList;
}
