import javax.swing.*;

public class MerchantLevelDisplayThread extends Thread{

    private JTextArea merchantInformation;

    public MerchantLevelDisplayThread(JTextArea jTextArea)
    {
        this.merchantInformation = jTextArea;
    }

    public void run()
    {
        try {
            merchantInformation.append("Welcome to my shop, take a look at my stock!\n \n");
            Thread.sleep(1000);
            merchantInformation.append(new Item(0).toString() + "\n");
            Thread.sleep(1000);
            merchantInformation.append(new Item(1).toString() + "\n");
            Thread.sleep(1000);
            merchantInformation.append(new Item(2).toString() + "\n");
        }catch (InterruptedException exception)
        {

        }
    }


}
