package bank.managment.system;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class Transaction extends JFrame implements ActionListener{
    public static String btnsound = "src/icons/button.wav";
    private JLabel l1,l5;
    private JButton b1,b2,b3,b4,b5,b6,b7;
    private String pin;
    Transaction(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 960, 1080);
        add(l2);

        l1 = new JLabel("Please Select Your Transaction" );
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));


        /*l5 = new JLabel("Welcome "+"");
        l5.setForeground(Color.WHITE);
        l5.setFont(new Font("System", Font.BOLD, 16));
        l5.setBounds(235,350,700,35);
        l2.add(l5);*/



        b1 = new JButton("DEPOSIT");
        b2 = new JButton("CASH WITHDRAWL");
        b3 = new JButton("FAST CASH");
        b4 = new JButton("MINI STATEMENT");
        b5 = new JButton("PIN CHANGE");
        b6 = new JButton("BALANCE ENQUIRY");
        b7 = new JButton("EXIT");

        setLayout(null);

        l1.setBounds(235,400,700,35);
        l2.add(l1);

        b1.setBounds(170,499,150,35);
        l2.add(b1);

        b2.setBounds(390,499,150,35);
        l2.add(b2);

        b3.setBounds(170,543,150,35);
        l2.add(b3);

        b4.setBounds(390,543,150,35);
        l2.add(b4);

        b5.setBounds(170,588,150,35);
        l2.add(b5);

        b6.setBounds(390,588,150,35);
        l2.add(b6);

        b7.setBounds(390,633,150,35);
        l2.add(b7);


        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);


        setSize(960,1080);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);



    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            PlayMusic(btnsound);
            setVisible(false);
            new Deposit(pin).setVisible(true);
        }else if(ae.getSource()==b2){
            PlayMusic(btnsound);
            setVisible(false);
            new Withdrawl(pin).setVisible(true);
        }else if(ae.getSource()==b3){
            PlayMusic(btnsound);
            setVisible(false);
            new FastCash(pin).setVisible(true);
        }else if(ae.getSource()==b4){
            PlayMusic(btnsound);
            new MiniStatement(pin).setVisible(true);
        }else if(ae.getSource()==b5){
            PlayMusic(btnsound);
            setVisible(false);
            new PinChange(pin).setVisible(true);
        }else if(ae.getSource()==b6){
            PlayMusic(btnsound);
            this.setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        }else if(ae.getSource()==b7){
            PlayMusic(btnsound);
            System.exit(0);
        }
    }

    public static void PlayMusic(String Location) {
        try {
            File musicpath = new File(Location);

            if (musicpath.exists()){
                AudioInputStream audio = AudioSystem.getAudioInputStream(musicpath);
                Clip clip = AudioSystem.getClip();
                clip.open(audio);
                clip.start();
            }else {
                System.out.println("Can Not Find The File");
            }

        }catch (Exception er){
            System.out.println(er);
        }
    }
    public static void main(String[] args){
        new Transaction("").setVisible(true);

    }
}
