/*
 * Activity 4.9.3 and 4.9.4
 * A LakeObject class for the Fishing Game
 */
public abstract class LakeObject
{
  private int cost;
  private int weight;
 
  public LakeObject()
  {
    cost = (int) (Math.random() * 7) + 1;
    weight = (int) (Math.random() * 15) + 1;
  }

  public int getCost()
  {
    return cost;
  }

  public int getWeight()
  {
    return weight;
  }

  public void setCost(int cost)
  {
    this.cost = cost;
  }

  public String say()
  {
    return "You have collected a LakeObject!";
  }

  public boolean wasCaught(Hook h)
  {
    if (h.getStrength() >= weight)
      return true;
    return false;
  }

  public String getObjectName()
  {
    return this.getClass().getName();
  }
}