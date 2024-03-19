/**
 * Level is an abstract class which provides the abstract method runLevel which all subclasses implement,
 furthermore this class implements ActionListener which all subclasses also implement.
 * @author Owen Bedford
 * @studentid 200348014
 * @version 1
 */

import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class Level extends JPanel implements ActionListener {
    private int index;

    public Level(int index)
    {
        this.index = index;
    }

    //Abstract method which subclasses implement to run a level
    public abstract void runLevel(JPanel mainPanel);

    //Returns the current index
    public int getIndex()
    {
        return index;
    }
}
