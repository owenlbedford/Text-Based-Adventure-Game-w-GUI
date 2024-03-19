import javax.swing.*;
import java.io.Serializable;

/**
 * PlayerTemplate class is a super class which contains getters and setters
 for instance variables such as adjusting health when damage is taken
 * @author (your name) Owen Bedford
 * @studentid 200348014
 * @version 1 (a version number or a date)
 */
public abstract class PlayerTemplate implements Serializable
{
    private int health;
    private int attack;
    
    public PlayerTemplate(int health, int attack)
    {
        this.health = health;
        this.attack = attack;
    }
    
    //Abstract method used within every subclasses for a second move that can be performed
    //
    public abstract int move2(JTextArea jTextArea);
    
    //Sets health to a new value
    //
    public void takeDamage(int attack, JTextArea jTextArea)
    {
        health = health - attack;
    }
    
    //Returns current health
    //
    public int getHealth()
    {
        return health;
    }
    
    //Gets the current attack
    //
    public int getAttack(JTextArea jTextArea)
    {
        return attack;
    }
    
    //Sets attack
    //
    public void setAttack(int attack)
    {
        this.attack = attack;
    }
    
    //Increments health by healthpoint
    //
    public void incrementHealth(int healthpoint)
    {
        health =  health + healthpoint;
    }
}
