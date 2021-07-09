package indi.tuo.xiao.base.thread;

/**
 * ThreadUtils
 */
public class ThreadUtils {

  /**
   * sleep current thread in milliseconds
   *
   * @param millisecond millisecond
   */
  public static void sleep(long millisecond) {
    if (millisecond <= 0) {
      return;
    }

    try {
      Thread.sleep(millisecond);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * thread is running
   *
   * @param thread thread
   * @return running is true
   */
  public static boolean isRunning(AbstractThread thread) {
    if (thread == null) {
      return false;
    }
    return thread.isRunning();
  }

  /**
   * thread is suspend
   *
   * @param thread thread
   * @return suspend is true
   */
  public static boolean isSuspend(AbstractThread thread) {
    if (thread == null) {
      return false;
    }
    return thread.isSuspend();
  }

  /**
   * pause thread
   *
   * @param thread thread
   */
  public static void pauseThread(AbstractThread thread) {
    if (isRunning(thread) && !isSuspend(thread)) {
      thread.pauseThread();
    }
  }

  /**
   * continue thread
   *
   * @param thread thread
   */
  public static void continueThread(AbstractThread thread) {
    if (isRunning(thread) && isSuspend(thread)) {
      thread.continueThread();
    }
  }

  /**
   * stop thread
   *
   * @param thread thread
   */
  public static void stopThread(AbstractThread thread) {
    if (thread != null) {
      thread.stopThread();
    }
  }

  /**
   * interrupt thread
   *
   * @param thread thread
   */
  public static void interruptThread(AbstractThread thread) {
    if (thread != null && thread.isRunning()) {
      thread.interruptThread();
    }
  }

  /**
   * Block waiting for the thread to complete
   *
   * @param thread thread
   */
  public static void join(AbstractThread thread) {
    try {
      thread.join();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Block waiting for the thread to complete, with timeout
   *
   * @param thread thread
   * @param millis timeout in millisecond
   */
  public static void join(AbstractThread thread, long millis) {
    try {
      thread.join(millis);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
