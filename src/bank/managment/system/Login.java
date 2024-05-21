
package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame {

    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        getContentPane ().setBackground (Color.WHITE) ;

        ImageIcon img1= new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i1 = img1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(i1);
        JLabel jl1 = new JLabel(img2);
        jl1.setBounds (620, 5, 100, 100) ;
        add(jl1);

        JLabel text = new JLabel ("Welcome to ATM");
        text.setFont (new Font ("Osward", Font. BOLD, 30)) ;
        text.setBounds (720, 35, 400, 40) ;
        add (text) ;
        ImageIcon img4= new ImageIcon(ClassLoader.getSystemResource("icons/ani.jpg"));

        //Image i2 = img4.getImage().getScaledInstance(120,800,Image.SCALE_DEFAULT);
        //ImageIcon img3 = new ImageIcon(i2);
        JLabel jl2 = new JLabel(img4);
        jl2.setBounds (0, 10, 600, 450) ;
        add(jl2);



        JLabel cardno = new JLabel ("Card No:") ;
        cardno.setBounds (620, 120, 400, 40) ; add (cardno) ;
        cardno.setFont (new Font ("Raleway", Font. BOLD, 19)) ;

        JTextField card_no = new JTextField();
        card_no.setBounds(620,160,250,40);
        card_no.setFont(new Font("Arial",Font.BOLD,14));
        add(card_no);

        JLabel pin = new JLabel ("PIN:") ;
        pin.setFont (new Font ("Raleway", Font. BOLD, 19)) ;
        pin.setBounds (620, 205, 400, 40) ;
        add (pin);

        JTextField card_pin = new JTextField();
        card_pin.setBounds(620,235,250,40);
        card_pin.setFont(new Font("Arial",Font.BOLD,14));
        add(card_pin);

        JButton sign_in_btn = new JButton("LOGIN");
        sign_in_btn.setBounds(640,290,150,40);
        add(sign_in_btn);
        sign_in_btn.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                String cardn = card_no.getText();
                String pin = card_pin.getText();

                if (cardn.equals("")){
                    JOptionPane.showMessageDialog(null,"Enter a Card Number Please");
                    if (pin.equals("")){
                        JOptionPane.showMessageDialog(null,"Enter PinChange Number Please");
                    }

                }else {
                    try {
                        Connect c = new Connect();
                        String qu = "Select * from login where cardnumber = '" + cardn + "'and pin = '" + pin + "'";
                        System.out.println("card no. and pin match successfully");

                        ResultSet rs = c.stmt.executeQuery(qu);

                        if (rs.next()) {
                            setVisible(false);
                            new Transaction(pin).setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Enter The Valid Card No. OR PinChange");
                            System.out.println("Faill to Find That User Card No :" + cardn + "pin :" + pin);

                        }

                    } catch (Exception ae) {
                        System.err.println(ae);
                    }


                }
            }
        });

        JButton clear = new JButton("CLEAR");
        clear.setBounds(800,290,150,40);
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card_no.setText("");
                card_pin.setText("");
            }
        });
        add(clear);

        JButton sign_up_btn = new JButton("SIGN-UP");
        sign_up_btn.setBounds(620,345,350,40);
        add(sign_up_btn);
        sign_up_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new SignUpOne();
            }
        });

        setSize(1000,450);
        setVisible(true);
        setLocation(280,200);

    }



    public static void main(String[] args) {
        new Login();
    }
}