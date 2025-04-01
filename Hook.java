/**
 * Activity 4.9.3
 */
public class Hook extends LakeObject
{
  private int strength = 45;

  public int getStrength()
  {
    return strength;
  }

  @Override
  public String say()
  {
    return "You now have a hook!";
  }
}
