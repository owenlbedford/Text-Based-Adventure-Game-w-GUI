/**
 * GameCompletedPanel Class is a class which extends JPanel and when a game is completed the current panel for the GUI changes to the contents this panel has
 * @author Owen Bedford
 * @studentid 200348014
 * @version 1
 */

import javax.swing.*;
import java.awt.*;

public class GameCompletedPanel extends JPanel {

    public GameCompletedPanel()
    {
        setBackground(Color.gray);
        JLabel completedMessage = new JLabel("Well done you've successfully completed the game!");
        add(completedMessage);
    }
}
