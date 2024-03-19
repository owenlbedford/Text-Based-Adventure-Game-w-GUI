/**
 * MerchantLevel class extends Level and allows for a player to purchase items which get added to their inventory if they have sufficient money
 * @author Owen Bedford
 * @studentid 200348014
 * @version 1
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MerchantLevel extends Level{
    private Choice purchaseChoice;
    private Player player;
    private JTextArea merchantInformation;

    public MerchantLevel(Player player, int index)
    {
        super(index);
        setBackground(Color.gray);
        purchaseChoice = new Choice();
        purchaseChoice.add("Tome");
        purchaseChoice.add("Katana");
        purchaseChoice.add("Claymore");
        JButton confirmPurchase = new JButton("Purchase");
        confirmPurchase.addActionListener(this);
        merchantInformation = new JTextArea();
        merchantInformation.setLineWrap(true);
        merchantInformation.setWrapStyleWord(true);
        merchantInformation.setEditable(false);
        JScrollPane merchantScrollPane = new JScrollPane(merchantInformation, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        merchantScrollPane.setPreferredSize(new Dimension(300, 200));
        this.player =player;
        add(confirmPurchase);
        add(purchaseChoice);
        add(merchantScrollPane);
    }

    //Makes the current panel visible and lists items a user can purchase
    @Override
    public void runLevel(JPanel mainPanel) {
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        cardLayout.show(mainPanel, ""+getIndex());
        MerchantLevelDisplayThread merchantLevelDisplayThread = new MerchantLevelDisplayThread(merchantInformation);
        merchantLevelDisplayThread.start();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Purchase"))
        {
            if(purchaseChoice.getSelectedItem().equals("Tome"))
            {
                if(player.getMoney() >= new Item(0).getItemSellPrice())
                {
                    if(player.checkHasItem(0))
                    {
                        merchantInformation.setText("Looks like you already have this item, purchase something else.");
                    }

                    else
                    {
                        player.addItem(0);
                        player.incrementPlayerMoney(-1 * new Item(0).getItemSellPrice());
                        merchantInformation.setText("Thanks for buying from me.");
                    }
                }

                else
                {
                    merchantInformation.setText("You can't afford this Tome, come back when you can.");
                }
            }

            if(purchaseChoice.getSelectedItem().equals("Katana"))
            {
                if(player.getMoney() >= new Item(1).getItemSellPrice())
                {
                    if(player.checkHasItem(1))
                    {
                        merchantInformation.setText("Looks like you already have this item, purchase something else.");

                    }

                    else
                    {
                        player.addItem(1);
                        player.incrementPlayerMoney(-1 * new Item(1).getItemSellPrice());
                        merchantInformation.setText("Thanks for buying from me.");
                    }
                }

                else
                {
                    merchantInformation.setText("You can't afford this Katana, come back when you can.");
                }

            }

            if(purchaseChoice.getSelectedItem().equals("Claymore"))
            {
                if(player.getMoney() >= new Item(1).getItemSellPrice())
                {
                    if(player.checkHasItem(2))
                    {
                        merchantInformation.setText("Look like you already have this item, purchase something else.");
                    }

                    else
                    {
                        player.addItem(2);
                        player.incrementPlayerMoney(-1 * new Item(2).getItemSellPrice());
                        merchantInformation.setText("Thanks for buying from me.");
                    }
                }

                else
                {
                    merchantInformation.setText("You can't afford this Claymore, come back when you can.");
                }
            }

        }

    }
}
