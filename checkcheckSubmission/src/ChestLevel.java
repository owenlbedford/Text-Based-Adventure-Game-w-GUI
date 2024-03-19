/**
 * ChestLevelClass allows for a player to randomly receive an item to gear up
 * @author Owen Bedford
 * @studentid 200348014
 * @version 1
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

class ChestLevel extends Level {
    private JLabel levelInformation;
    private int itemID;
    private Player player;

    public ChestLevel(Player player, int index)
    {
        super(index);
        setBackground(Color.gray);
        levelInformation = new JLabel();
        itemID = new Random().nextInt(3);
        add(levelInformation);
        this.player = player;
    }

    //Randomly adds an item to a players inventory if they don't have that item
    @Override
    public void runLevel(JPanel mainPanel) {
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        cardLayout.show(mainPanel, "" + getIndex());
        Item item = new Item(itemID);

        if(!player.checkHasItem(itemID))
        {
            player.addItem(itemID);
            levelInformation.setText(item.getItemName() + " item has been added to your inventory!");
        }

        else
        {
            levelInformation.setText("You found a chest which contains " + item.getItemName() + " but you already have this item!");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
