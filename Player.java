/*
 * Activity 4.9.3 and 4.9.4
 * A Player class for the Fishing Game
 */
import java.util.ArrayList;

public class Player
{
  private ArrayList<LakeObject> inventory;
  private int maxInventory;
  private int cash;
  private String currentLocation;

  public Player()
  {
    cash = 50;
    inventory = new ArrayList<LakeObject>();
    inventory.add(new Wallet());
    inventory.get(0).setCost(cash);
    inventory.add(new Hook());
    inventory.add(new Bait());
    maxInventory = 16;
    currentLocation = "forest";
  }

  public int getWallet()
  {
    return cash;
  }

  public ArrayList<LakeObject> getInventory()
  {
    return inventory;
  }

  public String getCurrentLocation()
  {
    return currentLocation;
  }

  public void updateWallet(int cash)
  {
    this.cash += cash;
    inventory.get(0).setCost(this.cash);
  }

  public void setCurrentLocation(String location)
  {
    currentLocation = location;
  }

  public boolean hasHook()
  {
    for (LakeObject item : inventory)
    {
      if (item != null && item.getClass().getName().equals("Hook"))
        return true;
    }
    return false;
  }

  public boolean hasBait()
  {
    for(LakeObject item : inventory)
    {
      if (item != null && item.getClass().getName().equals("Bait"))
        return true;
    }
    return false;
  }

  public Hook getStrongestHook()
  {
    Hook strongestHook = null;
    if (hasHook())
    {
      for (LakeObject item : inventory)
      {
        if (item.getClass().getName().equals("Hook"))
          strongestHook = (Hook)item;
      }
    }
    return strongestHook;
  }
   
  public void updateInventory(LakeObject newItem, boolean toAdd)
  {
    if (inventory.size() <= maxInventory && toAdd)
    {
      if (inventory.size() < maxInventory)
      {
        inventory.add(newItem);
        if (newItem.getClass().getName().equals("Fish"))
        {
          loseItem("Bait");
        }
      }
    }
    else
    {
      loseItem("Hook");
    }
  }

  public void loseItem(String itemType)
  {
    for (int i = 0; i < inventory.size(); i++)
    {
      if (inventory.get(i).getClass().getName().equals(itemType))
      {
        inventory.remove(i);
        break;
      }
    }
  }

  public boolean loseItem(String itemType, int location, boolean sold)
  {
    if (sold && (location > 0) && inventory.get(location-1).getClass().getName().equals(itemType))
    {
      updateWallet(inventory.get(location-1).getCost());
      inventory.remove(location-1);
      return true;
    }
    return false;
  }

  public boolean roomInInventory() {
    return inventory.size() < maxInventory;
  }
}