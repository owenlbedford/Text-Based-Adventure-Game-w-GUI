/**
 * This class contains the main method which creates an instance of the GUI,
 this class also contains some basic helper methods.
 * @author Owen Bedford
 * @studentid 200348014
 * @version 1
 */

import java.util.Scanner;

public class Main {

    public static void main(String [] args)
    {
        new GUI();
    }

    public static String inputString(String message)
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int inputInt(String message)
    {
        return Integer.parseInt(inputString(message));
    }
}
