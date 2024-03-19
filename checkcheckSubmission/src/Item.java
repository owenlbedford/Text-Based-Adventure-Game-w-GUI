import java.io.Serializable;

/**
 * Item class allows for objects of the type Item to be created which have asssociated instance variables such as attack and also associated instance methods which is used throughout the program
 * @author Owen Bedford
 * @studentid 200348014
 * @version 1
 */
public class Item implements Serializable
{
    private int itemid;
    private int sellprice;
    private int attack;
    private String magicType;
    private String itemname;

    public Item(int itemid)
    {
        this.itemid = itemid;
        setItemDetails(itemid);

    }

    public String toString()
    {
        return "Item name: " + itemname + "\n Item attack: " + attack;
    }

    //Sets the item instance variables based on passed itemid
    //
    private void setItemDetails(int itemid)
    {
        if(itemid==0)
        {
            itemname = "Tome";
            magicType = "Fire";
            sellprice = 0;
            attack = 30;
        }

        else if(itemid==1)
        {
            itemname = "Katana";
            magicType = "Ice";
            sellprice = 40;
            attack = 40;
        }

        else

        {
            itemname = "Claymore";
            magicType = "Earth";
            sellprice = 50;
            attack = 50;
        }
    }

    //Returns the items id
    //
    public int getItemID()
    {
        return itemid;
    }
    
    //Returns the items name
    //
    public String getItemName()
    {
        return itemname;
    }

    //Returns the items sell price
    //
    public int getItemSellPrice()
    {
        return sellprice;
    }

    //Returns items attack
    //
    public int getAttack()
    {
        return attack;
    }
    
    //Returns items magic type
    //
    public String getItemMagicType()
    {
        return magicType;
    }


}
