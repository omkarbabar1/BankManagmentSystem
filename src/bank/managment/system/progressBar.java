package bank.managment.system;

import javax.swing.*;

public class progressBar extends JFrame {
    private JProgressBar jp ;
    String pin;
    progressBar(String pin){
        this.pin = pin;
        jp = new JProgressBar();
        jp.setStringPainted(true);
        add(jp);
        setSize(960,50);
        setLocation(300,400);
        setVisible(true);
        progres();

    }

    public void progres(){

        int counter = 0;
        Transaction.PlayMusic("src/icons/withdroe.wav");
        while (counter<=100){
            jp.setValue(counter);
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println(e);
            }
            counter+=10;
            if (counter==100){
                setVisible(false);
                dispose();
            }
        }

    }

    public static void main(String[] args) {
        new progressBar("");
    }


}
