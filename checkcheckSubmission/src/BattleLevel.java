/**
 * BattleLevel class allows for a player to fight enemies.
 * @author Owen Bedford
 * @studentid 200348014
 * @version 1
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BattleLevel extends Level {

    private Enemy enemy;
    private Player player;
    private Choice combatChoice;
    private JTextArea combatInformation;

    public BattleLevel(Player player, int index)
    {
        super(index);
        this.player = player;
        setBackground(Color.gray);
        setLayout(new FlowLayout());

        enemy = Math.random() > 0.5? new StrongEnemy(100, 30) : new Enemy(50, 20); //Substitution Principle
        combatChoice = new Choice();
        combatChoice.addItem("Basic Attack");
        combatChoice.addItem("Heavy Attack");
        combatChoice.addItem("Heal Move");
        JButton confirmAttack = new JButton("Confirm Choice");
        confirmAttack.addActionListener(this);
        combatInformation = new JTextArea();
        combatInformation.setEditable(false);
        JScrollPane combatScrollPane = new JScrollPane(combatInformation, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        combatScrollPane.setPreferredSize(new Dimension(350, 200));
        add(confirmAttack);
        add(combatChoice);
        add(combatScrollPane, "Center");
    }

    //Sets the current visible panel to be this current BattleLevel panel also stops the player proceeding to the next level until enemy is defeated
    @Override
    public void runLevel(JPanel mainPanel) {
        player.setCanMoveStatus(false);
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        cardLayout.show(mainPanel, ""+getIndex());
    }

    //Handles events such as buttons being clicked
    @Override
    public void actionPerformed(ActionEvent e)  {
        if(enemy.getHealth() < 0 && !player.getCanMoveStatus())
        {
            int money = enemy.getDropCurrency();
            combatInformation.setText("You've defeated the enemy and can proceed to the next room! You received " + money + " money from the enemy");
            player.incrementPlayerMoney(money);
            player.setCanMoveStatus(true);
        }

        if(e.getActionCommand().equals("Confirm Choice") && !player.getCanMoveStatus())
        {
            if(combatChoice.getSelectedItem().equals("Basic Attack"))
            {
                enemy.takeDamage(player.getAttack(combatInformation), combatInformation);
                player.takeDamage(enemy.moveAttack(combatInformation), combatInformation); //Dynamic binding
            }

            if(combatChoice.getSelectedItem().equals("Heavy Attack"))
            {
                enemy.takeDamage(player.move2(combatInformation), combatInformation);
                player.takeDamage(enemy.moveAttack(combatInformation), combatInformation); //Dynamic binding
            }

            if(combatChoice.getSelectedItem().equals("Heal Move"))
            {
                enemy.takeDamage(player.move3(combatInformation), combatInformation);
                player.takeDamage(enemy.moveAttack(combatInformation), combatInformation); //Dynamic binding
            }
        }

    }
}
