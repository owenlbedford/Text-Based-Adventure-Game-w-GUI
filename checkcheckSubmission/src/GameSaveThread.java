/**
 * GameCompletedPanel Class is a class which extends Thread and implements Runnable, this class is used to create a new Thread within the GUI class
 and this thread will then handle game saving
 * @author Owen Bedford
 * @studentid 200348014
 * @version 1
 */

import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GameSaveThread extends Thread implements Runnable {

    private Player player;

    public GameSaveThread(Player player)
    {
        this.player = player;
    }

    //Saves the current game
    public void run()
    {
        player.decrementPlayerPosition();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("adventureGameSave.txt");
            ObjectOutputStream gameData = new ObjectOutputStream(fileOutputStream);
            gameData.writeObject(player);
            gameData.close();
            }
        catch (IOException exception) {
            JOptionPane.showMessageDialog(null, "There was an issue with saving the game");

        }
        player.incrementPlayerPosition();
    }
}
