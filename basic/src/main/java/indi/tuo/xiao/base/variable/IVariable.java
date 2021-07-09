package indi.tuo.xiao.base.variable;

import indi.tuo.xiao.base.exception.VariableException;

/**
 * variable interface
 */
public interface IVariable {

  /**
   * get variable name
   *
   * @return variable name
   */
  String getName();

  /**
   * set variable name
   */
  void setName(String name);

  String getId();

  void setId(String id);

  /**
   * get next value of variable
   *
   * @return The next value of the variable, maybe array
   * @throws VariableException VariableException
   */
  String[] next() throws VariableException;

  /**
   * get variable scope
   *
   * @return variable scope
   */
  int getScope();

  /**
   * deep clone variable
   *
   * @return cloned variable
   */
  IVariable deepClone();

  /**
   * variable cache time
   *
   * @return cache time
   */
  long getCacheTime();

  /**
   * get local data pool
   *
   * @return local data pool
   */
  IDataPool getDataPool();

  /**
   * set local data pool
   *
   * @param dataPool local data pool
   */
  void setDataPool(IDataPool dataPool);
}
