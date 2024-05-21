package bank.managment.system;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class BalanceEnquiry  extends JFrame implements ActionListener {

        JTextField t1, t2;
        JButton b1, b2, b3;
        JLabel l1, l2, l3;
        String pin;

        BalanceEnquiry(String pin) {
            this.pin = pin;

            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
            Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel l3 = new JLabel(i3);
            l3.setBounds(0, 0, 960, 1080);
            add(l3);

            l1 = new JLabel();
            l1.setForeground(Color.WHITE);
            l1.setFont(new Font("System", Font.BOLD, 16));

            b1 = new JButton("BACK");

            setLayout(null);

            l1.setBounds(190, 350, 400, 35);
            l3.add(l1);

            b1.setBounds(390, 633, 150, 35);
            l3.add(b1);
            int balance = BalanceEnquiry.getbalence(pin);

            l1.setText("Your Current Account Balance is Rs "+balance);

            b1.addActionListener(this);

            setSize(960, 1080);
            setUndecorated(true);
            setLocation(500, 0);
            setVisible(true);
        }

        static int getbalence(String pin){
            int balance = 0;
            try {
                Connect c = new Connect();
                ResultSet rs = c.stmt.executeQuery("select * from bank where pin = '"+pin+"'");

                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));

                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));

                    }
                }

            }catch (Exception err){
                System.out.println(err);
            }
            return balance;}

        public void actionPerformed(ActionEvent ae) {
            Transaction.PlayMusic(Transaction.btnsound);
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }

        public static void main(String[] args) {
            new BalanceEnquiry("").setVisible(true);
        }

}
