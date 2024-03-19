/**
 * GameInformationPanel is Class which extends JPanel which is used to allow for a player to change to
 panels to their inventory and display key information such as player health and player money through the use of Timer and TimerTask
 * @author Owen Bedford
 * @studentid 200348014
 * @version 1
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class GameInformationPanel extends JPanel implements ActionListener {

    private JPanel mainPanel;
    private InventoryPanel inventoryPanel;
    private JLabel playerHealthJLabel;
    private JLabel playerMoneyJLabel;
    private JButton nextLevelButton;

    public GameInformationPanel(Player player, JPanel mainPanel, JButton nextLevelButton)
    {
        this.nextLevelButton = nextLevelButton;
        this.mainPanel = mainPanel;
        setLayout(new FlowLayout());
        playerHealthJLabel = new JLabel("Player health: "+player.getHealth());
        playerMoneyJLabel = new JLabel("Player money: "+player.getMoney());
        JButton inventoryButton = new JButton("Inventory");
        inventoryButton.addActionListener(this);
        inventoryPanel = new InventoryPanel(player, mainPanel, nextLevelButton, inventoryButton);
        mainPanel.add(inventoryPanel, "inventoryPanel");

        //Used to schedule a task which repeats at a fixed rate
        java.util.Timer timer = new java.util.Timer();
        TimerTask timerTask = new TimerTask() {
            public void run() {
                playerHealthJLabel.setText("Player health: "+player.getHealth());
                playerMoneyJLabel.setText("Player money: "+player.getMoney());

                //If the player's health goes below 0, panel automatically changes to the lost game panel
                if(player.getHealth() <= 0)
                {
                    CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                    cardLayout.show(mainPanel, "gameLostPanel");
                    nextLevelButton.setVisible(false);
                    inventoryButton.setVisible(false);
                }

                if(player.getGameCompleteStatus())
                {
                    inventoryButton.setVisible(false);
                }
            }
        };

        timer.scheduleAtFixedRate(timerTask, 0, 100);


        add(playerHealthJLabel);
        add(playerMoneyJLabel);
        add(inventoryButton);
    }

    //Handles events
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Inventory"))
        {
            JButton jButton = new JButton("Refresh");
            jButton.addActionListener(inventoryPanel);
            jButton.doClick();
            nextLevelButton.setVisible(false);
            CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
            cardLayout.show(mainPanel, "inventoryPanel");
        }

    }
}
