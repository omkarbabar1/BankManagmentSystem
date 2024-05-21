package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    JTextField amount;
    JButton button1,button2;
    String pin ;

    Deposit(String pin){
        this.pin=pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 960, 1080);
        add(image);

        JLabel text = new JLabel ("Enter the amount you want to deposit");
        text.setForeground (Color. WHITE) ;
        text.setFont (new Font ("System", Font. BOLD, 16));
        text.setBounds (170, 350, 400, 20) ;
        image.add(text);

        amount = new JTextField();
        amount. setFont (new Font ("Raleway", Font. BOLD, 22));
        amount.setBounds(170,400,320,25);
        image.add(amount);

        button1 =new  JButton("Deposit");
        Transaction.PlayMusic(Transaction.btnsound);
        button1.setBounds(355,485,150,40);
        button1.addActionListener(this);
        image.add(button1);


        button2 =new  JButton("Back");
        Transaction.PlayMusic(Transaction.btnsound);
        button2.setBounds(355,540,150,40);
        button2.addActionListener(this);
        image.add(button2);




        setSize(960,1080);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== button1){
            String number = amount.getText();
            Date date = new Date();
            Transaction.PlayMusic(Transaction.btnsound);
            if (number.equals("")){
                JOptionPane.showMessageDialog(null,"Enter Amount Please..");

                }else if (Integer.parseInt(amount.getText().trim())<100) {
                JOptionPane.showMessageDialog(null, "Minimum Deposit Is 100.");
            }else {
                try {
                    Connect c = new Connect();

                    //String query = "create table bank(pin varchar(10),date varchar(50),type varchar(20),amount varchar(20))";

                    String query = "insert into bank values('" + pin + "','" + date + "','Deposit','" + number + "')";

                    c.stmt.executeUpdate(query);
                    System.out.println("......Deposit Rs.  ONE ROW INSRTED IN DATABASE ......");

                    JOptionPane.showMessageDialog(null, "Rs." + number + "Deposit Successfully..");

                    setVisible(false);
                    new Transaction(pin).setVisible(true);

                } catch (Exception ae) {
                    System.out.println(ae);
                }
            }


        } else if (e.getSource()==button2) {
            Transaction.PlayMusic(Transaction.btnsound);
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
