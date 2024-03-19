/**
 * GUI Class is a key class inorder to allow for the adventure game to have a graphical user interface
 * @author Owen Bedford
 * @studentid 200348014
 * @version 1
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class GUI extends JFrame implements ActionListener {

    private JPanel mainPanel;
    private CardLayout cardLayout;
    private ArrayList<Level> levelArrayList;
    private Player player;
    private JButton nextLevelButton;

    public GUI() {
        super("Adventure Game");
        setSize(500, 500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel = new JPanel();
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);

        nextLevelButton = new JButton("Next Level");
        nextLevelButton.addActionListener(this);

        JPanel titlePanel = new TitlePanel();
        JPanel gameCompletedPanel = new GameCompletedPanel();
        JPanel gameLostPanel = new GameLostPanel();

        JButton loadGame = new JButton("Load Game");
        loadGame.addActionListener(this);
        titlePanel.add(loadGame);
        JButton newGame = new JButton("New Game");
        newGame.addActionListener(this);
        titlePanel.add(newGame);


        mainPanel.add(titlePanel, "titlePanel");
        mainPanel.add(gameCompletedPanel, "gameCompletedPanel");
        mainPanel.add(gameLostPanel, "gameLostPanel");
        add(mainPanel, BorderLayout.CENTER);
        cardLayout.show(mainPanel, "titlePanel");
        setVisible(true);
    }

    //When called this method performs a series of assignments for variables critical to the game running as intended
    public void startUpNewGame()
    {
        player = new Player(500, 0);
        generateArrayList();
    }

    //Adds objects to the arraylist
    public void generateArrayList() {
        final int NUMOFLEVELS = 10;
        levelArrayList = new ArrayList<>();

        for (int i=0; i < NUMOFLEVELS; i++) //Substitution principle within body
        {
            if (Math.random() > 0.70) {
                BattleLevel battleLevel = new BattleLevel(player, i);
                levelArrayList.add(battleLevel);
                mainPanel.add(battleLevel, "" + i);
            } else if (Math.random() < 0.40) {
                MerchantLevel merchantLevel = new MerchantLevel(player, i);
                levelArrayList.add(merchantLevel);
                mainPanel.add(merchantLevel, "" + i);
            } else {
                ChestLevel chestLevel = new ChestLevel(player, i);
                levelArrayList.add(chestLevel);
                mainPanel.add(chestLevel, "" + i);
            }
        }
    }

    //Loads the game if any previous save exists
    public void loadGame() {
        try {
        FileInputStream fileInputStream = new FileInputStream("adventureGameSave.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        player = (Player) objectInputStream.readObject();
        generateArrayList();
        } catch(IOException | ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, "You don't have a save file currently, you'll start from the beginning.");
            startUpNewGame();
        }
    }


    //Handles events when triggered
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Load Game"))
        {
            loadGame();
            GameInformationPanel gameInformationPanel = new GameInformationPanel(player, mainPanel, nextLevelButton);
            add(gameInformationPanel, "North");
            player.setCanMoveStatus(true);
            nextLevelButton.doClick();
            add(nextLevelButton, "East");
        }

        if(e.getActionCommand().equals("New Game"))
        {
            startUpNewGame();
            GameInformationPanel gameInformationPanel = new GameInformationPanel(player, mainPanel, nextLevelButton);
            add(gameInformationPanel, "North");
            nextLevelButton.doClick();
            add(nextLevelButton, "East");
        }

        if(e.getActionCommand().equals("Next Level") && player.getCanMoveStatus() && player.getHealth() > 0)
        {
            try {
                levelArrayList.get(player.getPlayerPosition()).runLevel(mainPanel); //Dynamic binding
                new GameSaveThread(player).start();
                player.incrementPlayerPosition();
            }
            catch (IndexOutOfBoundsException exception)
            {
                remove(nextLevelButton);
                player.setGameCompleteStatus(true);
                cardLayout.show(mainPanel, "gameCompletedPanel");
            }
        }

        else if(e.getActionCommand().equals("Next Level") && !player.getCanMoveStatus())
        {
            JOptionPane.showMessageDialog(null, "You must first clear the room before you can continue to the next level.");
        }
    }
}
