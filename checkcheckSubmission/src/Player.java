/**
 * Player class is a subclass of PlayerTemplate which provides behaviours players can perform such as moves the player can use to attack
 and also instance variables releveant to a player such as inventory and playerMoney.
 * @author Owen Bedford
 * @studentid 200348014
 * @version 1
 */

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
public class Player extends PlayerTemplate implements Serializable
{
    private Item item;
    private ArrayList<Item> inventory;
    private int playerMoney;
    private int playerPosition;
    private  boolean canMoveStatus;
    private boolean gameCompleteStatus;

    public Player(int health, int attack)
    {
        super(health, attack);
        canMoveStatus = true;
        inventory = new ArrayList<>();
        inventory.add(new Item(0));
        item = inventory.get(0);
        gameCompleteStatus = false;
        setAttack(item.getAttack());
    }

    //Sets whether a game has been completed or not
    //
    public void setGameCompleteStatus(boolean status)
    {
        gameCompleteStatus = status;
    }

    //Returns true if a game has been completed, false if it hasn't
    //
    public boolean getGameCompleteStatus()
    {
        return gameCompleteStatus;
    }

    //Sets canMoveStatus
    //
    public void setCanMoveStatus(Boolean status)
    {
        canMoveStatus = status;
    }

    //Returns true or false which determines if a player can change level if true, and not change rooms if false
    //
    public boolean getCanMoveStatus()
    {
        return canMoveStatus;
    }

    //Returns player position
    //
    public int getPlayerPosition()
    {
        return playerPosition;
    }

    //Increments player position
    //
    public void incrementPlayerPosition()
    {
        playerPosition = playerPosition + 1;
    }

    //Decrements player position
    //
    public void decrementPlayerPosition()
    {
        playerPosition = playerPosition - 1;
    }
    
    //Overriden method which allows the player to do critical damage which results in a damage bonus
    //
    @Override
    public int getAttack(JTextArea jTextArea)
    {
        if(Math.random() < 0.25)
        {
            jTextArea.append("You manage to perform a critical attack with basic attack! \n");
            return super.getAttack(jTextArea) * 2;
        }
        
        else
        {
            jTextArea.append("You land a basic attack! \n");
            return super.getAttack(jTextArea);
        }
    }

    //Returns either 0 or an integer which is the player's attack + 25 (Overrides the abstract method in super class)
    //
    @Override
    public int move2(JTextArea jTextArea)
    {
        if(Math.random() < 0.25)
        {
            jTextArea.append("Your heavy attack was exhausting your attack missed! \n");
            return 0;
        }
        
        else
        {
            jTextArea.append("You use heavy attack! \n");
            return super.getAttack(jTextArea) + 25;
        }
    }

    //Increases the players armour
    //
    public int move3(JTextArea jTextArea)
    {
        jTextArea.append("You use heal, your health has increased! \n");
        incrementHealth(40);
        return 0;
    }


    //Overridden method which based on chance results in damaging being taken or not
    //
    @Override
    public void takeDamage(int attack, JTextArea jTextArea)
    {
        if(Math.random() < 0.10)
        {
            jTextArea.append("You dodged the attack! You took no damage! \n");
        }
        
        else
        {
            jTextArea.append("You took " + attack + " damage! \n");
            super.takeDamage(attack, jTextArea);
        }
    }

    //Changes current equipped weapon and sets a new attack
    //
    public void equipItem(int id)
    {
        item = new Item(id);
        setAttack(item.getAttack());
        for(Item item: inventory)
        {
            if(checkHasItem(id))
            {
                item = new Item(id);
                setAttack(item.getAttack());
                return;
            }
        }
    }

    //Increments players money
    //
    public void incrementPlayerMoney(int money)
    {
        playerMoney = playerMoney + money;
    }

    //Adds an item to players inventory
    //
    public void addItem(int id)
    {
        if(!checkHasItem(id))
        {
            inventory.add(new Item(id));
        }
    }

    //Returns the players current money
    //
    public int getMoney()
    {
        return playerMoney;
    }
    

    //Checks that the player has a certain item in inventory and returns true or false based on this
    //
    public boolean checkHasItem(int id)
    {
        for(int i=0; i<inventory.size(); i++)
        {
            if(inventory.get(i).getItemID()==id)
            {
                return true;
            }
        }
        return false;
    }



}
