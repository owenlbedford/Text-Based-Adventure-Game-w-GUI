/**
 * GameCompletedPanel Class is a class which extends JPanel and when a game is lost the current panel for the GUI changes to the contents this panel has
 * @author Owen Bedford
 * @studentid 200348014
 * @version 1
 */

import javax.swing.*;
import java.awt.*;

public class GameLostPanel extends JPanel {

    public GameLostPanel()
    {
        setBackground(Color.gray);
        JLabel completedMessage = new JLabel("You've been defeated!");
        add(completedMessage);
    }
}
