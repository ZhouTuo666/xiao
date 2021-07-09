package indi.tuo.xiao.base.variable;

import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

public abstract class AbstractVariable implements IVariable {

  @Getter
  @Setter
  protected String name;

  @Getter
  @Setter
  protected String id;

  @Getter
  protected int scope;

  @Getter
  protected long cacheTime;

  @Getter
  @Setter
  protected transient IDataPool dataPool;

  @Getter
  private final String _type = this.getClass().getName();

  public AbstractVariable(String name, String id, int scope, long cacheTime) {
    this.name = name;
    this.id = id;
    this.scope = scope;
    this.cacheTime = cacheTime;
  }

  protected AbstractVariable() {
  }

  @Override
  public IVariable deepClone() {
    IVariable variable = this.copy();
    variable.setDataPool(getDataPool());
    return variable;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbstractVariable that = (AbstractVariable) o;
    return name.equals(that.name) &&
        id.equals(that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, id);
  }

  protected abstract IVariable copy();
}