
/**
 * Enemy class is a subclass to PlayerTemplate and the purpose of this class is to add behaviours an enemy can perform such as being able to use different attacks to damage a player
 and having a chance of dodging an attack. Furthermore this class also contains relevant instance variables such as dropCurrency and luckStat which is used in the program.
 * @author Owen Bedford
 * @studentid 200348014
 * @version 1
 */
import javax.swing.*;
import java.io.Serializable;
import java.util.Random;

public class Enemy extends PlayerTemplate implements Serializable
{
    private int dropCurrency;
    private double luckStat;
    
   public Enemy(int health, int attack)
   {
       super(health, attack);
       Random random = new Random();
       luckStat = random.nextInt(9) + 1;
       dropCurrency = (int) (100 * (1+(1/luckStat)));
   }
   
   //Based on chance this method decides if the enemy takes damage or not (Overrides takeDamage in the superclass)
   //
    @Override
   public void takeDamage(int attack, JTextArea jTextArea)
   {
       if(Math.random() < 0.15)
       {
           jTextArea.append("Enemy dodged the attack! \n");
       }
       
       else
       {
           jTextArea.append("Enemy took " + attack + " damage! \n");
           super.takeDamage(attack, jTextArea);
       }
   }
   
   //Randomly returns a number which is used to represent damage from the result of method calls (Overrides moveAttack abstract method in the superclass)
   //
   public int moveAttack(JTextArea jTextArea)
   {   
       if(Math.random() > 0.5)
       {
           jTextArea.append("Enemy has used basic attack! \n");
           return getAttack(jTextArea);
       }
       
       else if(Math.random() < 0.3)
       {
           return move2(jTextArea);
           
       }
       
       else
       {
           return move3(jTextArea);
       }
       
   }
   
   //The second move which returns an increased amount for attack (Overrides move2 abstract method in super class)
   //
    @Override
   public int move2(JTextArea jTextArea)
   {
       jTextArea.append("Enemy has used critical attack! \n");
       return (int) (getAttack(jTextArea) * (1+(1/getLuckStat())));
   }
   
   //The third move which increments the health of the Enemy
   //
   private int move3(JTextArea jTextArea)
   {
       jTextArea.append("Enemy has used heal! \n");
       incrementHealth((int) (20 * (1+(1/getLuckStat()))));
       return 0;
   }
   
   //Returns the currency this instance of Enemy has
   //
   public int getDropCurrency()
   {
       return dropCurrency;
   }
   
   //Returns the luckStat
   //
   public double getLuckStat()
   {
       return luckStat;
   }
}