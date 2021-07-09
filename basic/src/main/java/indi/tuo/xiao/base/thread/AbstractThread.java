package indi.tuo.xiao.base.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * AbstractThread
 */
@Slf4j
public abstract class AbstractThread extends Thread {

  /**
   * suspend flag
   */
  private boolean suspend;
  /**
   * started flag
   */
  private boolean started;
  /**
   * initialize flag
   */
  private boolean initialize;

  /**
   * Logic pause flag. Using this flag will not cause the thread state to change. For example, the
   * businessLogic method will still execute if the flag is set when the thread is in the running
   * state.
   */
  private volatile boolean pause = false;

  /**
   * Business processing cycle counter
   */
  private long loop = 0;

  /**
   * No parameter construction method, only for cloning
   */
  protected AbstractThread() {
  }

  /**
   * In order to clearly see which thread is operating in the log, the subclass must call the
   * constructor
   *
   * @param name thread name
   */
  protected AbstractThread(String name) {
    this(null, name);
  }

  private AbstractThread(ThreadGroup threadGroup, String name) {
    super(threadGroup, name);
    log.debug("Create thread [{}]", name);
  }

  /**
   * start thread
   */
  public synchronized void startThread() {
    start();
    log.debug("Start Thread [{}]", getName());
  }

  /**
   * stop thread
   */
  public synchronized void stopThread() {
    notifyAll();
    started = false;
  }

  /**
   * pause thread
   */
  public synchronized void pauseThread() {
    suspend = true;
    log.debug("Pause Thread [{}]", getName());
  }

  /**
   * continue thread
   */
  public synchronized void continueThread() {
    notifyAll();
    suspend = false;
    log.debug("Continue Thread [{}]", getName());
  }

  /**
   * interrupt current thread
   */
  public synchronized void interruptThread() {
    this.stopThread();
    this.interrupt();
  }

  @Override
  public void run() {
    this.started = true;
    this.suspend = false;
    this.setup();
    this.initialize = true;

    while (started) {
      try {
        synchronized (this) {
          while (suspend && started) {
            wait();
          }
        }
      } catch (InterruptedException e) {
        this.interrupt();
      }
      this.businessLogic();
      this.loop++;
    }

    this.teardown();
    log.debug("End Thread [{}]", getName());
  }

  /**
   * setup
   */
  protected abstract void setup();

  /**
   * business
   */
  protected abstract void businessLogic();


  /**
   * teardown
   */
  protected abstract void teardown();

  /**
   * thread is running
   */
  public boolean isRunning() {
    return started || isAlive();
  }

  /**
   * thread is new
   */
  public boolean isNew() {
    return getState() == State.NEW;
  }

  /**
   * thread is suspend
   */
  public boolean isSuspend() {
    return this.suspend;
  }

  public boolean isStarted() {
    return started;
  }

  public boolean isInitialize() {
    return this.initialize;
  }

  public boolean isPause() {
    return pause;
  }

  public void setPause(boolean pause) {
    this.pause = pause;
  }

  public final long getLoop() {
    return loop;
  }
}
