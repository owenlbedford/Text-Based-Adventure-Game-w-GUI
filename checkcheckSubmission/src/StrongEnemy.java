
/**
 * StrongEnemy class is a subclass to Enemy (and a grandchild to PlayerTemplate) and the purpose of this class is to add additional instance variables which
 further adds variety when players fight enemies. This class overrides methods to further add variety with how different types of enemies behave.
 * @author Owen Bedford
 * @studentid 200348014
 * @version 1
 */
import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
final public class StrongEnemy extends Enemy implements Serializable
{
    private Item bossWeapon;
    private String bossName;
    private String bossMagicAffinity;

    public StrongEnemy(int health, int attack)
    {
        super(health, attack);
        ArrayList<String> possibleNames = new ArrayList<>();
        possibleNames.add("Golem");
        possibleNames.add("Assassin");
        possibleNames.add("Bandit");
        ArrayList<String> possibleMagicAffinity = new ArrayList<>();
        possibleMagicAffinity.add("Fire");
        possibleMagicAffinity.add("Ice");
        possibleMagicAffinity.add("Earth");
        
        Random random = new Random();
        bossName = possibleNames.get(random.nextInt(possibleNames.size()));
        bossMagicAffinity = possibleMagicAffinity.get(random.nextInt(possibleMagicAffinity.size()));
        int itemNum = random.nextInt(3);
        bossWeapon = new Item(itemNum);
        setAttack(bossWeapon.getAttack());
        
        if(bossWeapon.getItemMagicType().equals(bossMagicAffinity))
        {
            setAttack(bossWeapon.getAttack() + (int) (15 * (1+(1/getLuckStat()))));
        }
        
        else
        {
            setAttack(bossWeapon.getAttack());
        }
    }
    
    //Returns an integer which is used to deal damage to the players
    //
    @Override
    public int moveAttack(JTextArea jTextArea)
    {
        if(Math.random() > 0.5)
        {
            return getAttack(jTextArea);
        }
        
        else
        {
            return move2(jTextArea);
        }
    }
    
    //Overrides getAttack to add different returned results based on chance and conditions
    //
    public int getAttack(JTextArea jTextArea)
    {
        if(Math.random() < 0.25 && bossWeapon.getItemMagicType().equals(bossMagicAffinity))
        {
            jTextArea.append(bossName + " resonates with its weapon and deals critical magic damage with a basic attack \n");
            return (int) (super.getAttack(jTextArea) * 1.5);
        }
        
        else if(Math.random() < 0.25)
        {
            jTextArea.append((bossName + " deals critical basic attack \n"));
            return (int) (super.getAttack(jTextArea) * 1.25);
        }
        
        else
        {
            jTextArea.append(bossName + " uses basic attack! \n");
            return super.getAttack(jTextArea);
        }
    }
    
    //The second move which increases weapon attack damage
    //
    @Override
    public int move2(JTextArea jTextArea)
    {
        jTextArea.append(bossName + " used weapon enchant, their base damage has increased! \n");
        setAttack(super.getAttack(jTextArea) + (int) ((5 * (1+(1/getLuckStat())))));
        return 0;
    }
}
