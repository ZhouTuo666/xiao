package indi.tuo.xiao.base.variable;

/**
 * data pool interface
 */
public interface IDataPool {

  /**
   * initialize variable data pool
   *
   * @param variable variable
   */
  void initialize(IVariable variable);

  /**
   * data for put data pool
   *
   * @param data data
   */
  void put(String[] data);

  /**
   * get data from data pool
   *
   * @return data, maybe null
   */
  String[] get();

  /**
   * pull data from redis
   */
  void pull();

  /**
   * put data to redis
   */
  void push();

  /**
   * data size in pool
   *
   * @return data size
   */
  int size();

  /**
   * Batch fetch from redis
   *
   * @param pullCount pull count
   * @return enough is true
   */
  boolean pullData(int pullCount);

  /**
   * increase QPS
   *
   * @param qps user QPS
   */
  void increaseQps(double qps);

  /**
   * decrease qps
   *
   * @param qps user QPS
   */
  void decreaseQps(double qps);

  /**
   * Eliminate a batch of data
   *
   * @param retainCount retain count
   */
  void eliminateData(int retainCount);

  /**
   * Delete expired key
   */
  void removeExpireKeys();

  /**
   * get redis key
   *
   * @return key
   */
  String getDataKey();

  /**
   * get data pool cache time
   *
   * @return cache time
   */
  long getCacheTime();

  /**
   * close data pool
   */
  void close();
}
