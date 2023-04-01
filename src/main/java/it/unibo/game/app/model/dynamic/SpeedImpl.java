package it.unibo.game.app.model.dynamic;

import it.unibo.game.app.api.Speed;

/**
 * class that contains informations about objects' speed.
 */
public class SpeedImpl implements Speed {

  private double x;
  private double y;

  /**
   * constructor of the class.
   * 
   * @param x coordinate x of speed
   * @param y coordinate y of speed
   */
  public SpeedImpl(final double x, final double y) {
    this.x = x;
    this.y = y;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public double getX() {
    return this.x;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public double getY() {
    return this.y;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void sum(final Speed vel) {
    this.x = this.x + vel.getX();
    this.y = this.y + vel.getY();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void mul(final double num) {
    this.x = this.x * num;
    this.y = this.y * num;
  }

  /**
   * {@inheritDoc}
   */
  @SuppressWarnings("rawtypes")
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Speed other = (Speed) obj;
    if (other.getX() == x && other.getY() == y) {
      return true;
    }
    return false;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "[" + this.x + "," + this.y + "]";
  }

}
