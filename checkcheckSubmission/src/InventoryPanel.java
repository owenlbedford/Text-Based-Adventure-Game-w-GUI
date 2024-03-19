/**
 * InventoryPanel Class is a class which extends JPanel and when a button is clicked the current panel will then display the contents of this Panel
 this panel will allow a user to equip items which they have purchased or picked up along the way.
 * @author Owen Bedford
 * @studentid 200348014
 * @version 1
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryPanel extends JPanel implements ActionListener {
    private Player player;
    private Choice equipItemChoice;
    private JTextArea inventoryInformation;
    private JPanel mainPanel;
    private JButton nextLevelButton;
    private JButton inventoryButton;

    public InventoryPanel(Player player, JPanel mainPanel, JButton nextLevelButton, JButton inventoryButton)
    {
        this.player = player;
        this.mainPanel = mainPanel;
        this.inventoryButton = inventoryButton;
        this.nextLevelButton = nextLevelButton;
        setBackground(Color.LIGHT_GRAY);
        equipItemChoice = new Choice();
        JButton equipButton = new JButton("Equip");
        JButton closeInventory = new JButton("Close Inventory");
        closeInventory.addActionListener(this);
        equipButton.addActionListener(this);
        inventoryInformation = new JTextArea();
        inventoryInformation.setEditable(false);
        JScrollPane inventoryScrollPane = new JScrollPane(inventoryInformation, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        inventoryScrollPane.setPreferredSize(new Dimension(350, 200));
        add(inventoryScrollPane);
        add(equipItemChoice);
        add(equipButton);
        add(closeInventory);
    }

    //Handles events
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Close Inventory"))
        {
            nextLevelButton.setVisible(true);
            inventoryButton.setVisible(true);
            CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
            cardLayout.show(mainPanel, ""+(player.getPlayerPosition()-1));
        }

        if(e.getActionCommand().equals("Refresh"))
        {
            inventoryButton.setVisible(false);
            equipItemChoice.removeAll();
            if(player.checkHasItem(0))
            {
                equipItemChoice.addItem("Tome");
            }

            if(player.checkHasItem(1))
            {
                equipItemChoice.addItem("Katana");
            }

            if(player.checkHasItem(2))
            {
                equipItemChoice.addItem("Claymore");
            }

        }
        if(equipItemChoice.getSelectedItem().equals("Tome") && e.getActionCommand().equals("Equip"))
        {
            player.equipItem(0);
            inventoryInformation.setText("You've equipped a Tome which has the following information \n " + new Item(0));
        }

        if(equipItemChoice.getSelectedItem().equals("Katana") && e.getActionCommand().equals("Equip"))
        {
            player.equipItem(1);
            inventoryInformation.setText("You've equipped a Katana which has the following information \n " + new Item(1));
        }

        if(equipItemChoice.getSelectedItem().equals("Claymore") && e.getActionCommand().equals("Equip"))
        {
            player.equipItem(2);
            inventoryInformation.setText("You've equipped a Claymore which has the following information \n " + new Item(2));
        }


    }
}
