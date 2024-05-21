
package bank.managment.system;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.util.Random;


public class SignUpOne extends JFrame {
    

        private JButton signUpNext;
        private JTextField NameTextFill,FaTextFill,AdressTextFill,PinCodeTextFill,cityTextFill,EmailTextFill;
        private JRadioButton RadioMale,RadioFemale,RadioOther,RadioMarried,RadioUnMarried;

        JDateChooser JDateChoos;

     SignUpOne(){
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 1");
        setLayout(null);
        setSize(800,750);
        setVisible(true);
        setLocation(300,10);


        Random ran = new Random();
        long fno =Math.abs((ran.nextLong()%9000L)+1000L);

        JLabel lin1 =new JLabel("APPLICATION FORM NO. : "+fno);
        lin1.setBounds(100,50,700,40);
        lin1.setForeground(Color.black);
        lin1.setFont(new Font("raleway",Font.BOLD,38));
        add(lin1);

        JLabel persnoldetail =new JLabel("PAGE NO. 1 : PERSNOL DETAIL ");
        persnoldetail.setBounds(180,110,600,40);
        persnoldetail.setForeground(Color.black);
        persnoldetail.setFont(new Font("raleway",Font.BOLD,28));
        add(persnoldetail);

        JLabel name =new JLabel("Name :");
        name.setBounds(100,180,600,40);
        name.setForeground(Color.black);
        name.setFont(new Font("raleway",Font.BOLD,20));
        add(name);

        NameTextFill = new JTextField(15);
        NameTextFill.setBounds(260,190,350,25);
        NameTextFill.setBackground(Color.white);
        NameTextFill.setForeground(Color.black);
        NameTextFill.setFont(new Font("Arial",Font.BOLD,14));
        add(NameTextFill);

        JLabel Fname =new JLabel("Father's Name :");
        Fname.setBounds(100,230,600,40);
        Fname.setForeground(Color.black);
        Fname.setFont(new Font("raleway",Font.BOLD,20));
        add(Fname);

        FaTextFill = new JTextField();
        FaTextFill.setBounds(260,240,350,25);
        FaTextFill.setFont(new Font("Arial",Font.BOLD,14));
        FaTextFill.setForeground(Color.black);
        FaTextFill.setBackground(Color.white);
        add(FaTextFill);

        JLabel text1 =new JLabel("Date Of Birth :");
        text1.setBounds(100,280,600,40);
        text1.setForeground(Color.black);
        text1.setFont(new Font("raleway",Font.BOLD,20));
        add(text1);

        JDateChoos =new JDateChooser();
        JDateChoos.setBounds(260,290,350,30);
        JDateChoos.setForeground(Color.BLACK);
        add(JDateChoos);

        JLabel text2 =new JLabel("Gender :");
        text2.setBounds(100,330,600,40);
        text2.setForeground(Color.black);
        text2.setFont(new Font("raleway",Font.BOLD,20));
        add(text2);

        RadioMale = new JRadioButton("Male");
        RadioMale.setForeground(Color.black);
        RadioMale.setBounds(310,340,90,30);
        RadioMale.setFont(new Font("raleway",Font.BOLD,12));
        add(RadioMale);

        RadioFemale = new JRadioButton("Female");
        RadioFemale.setBounds(400,340,100,30);
        RadioFemale.setForeground(Color.black);
        RadioFemale.setFont(new Font("raleway",Font.BOLD,12));
        add(RadioFemale);

        RadioOther = new JRadioButton("Other");
        RadioFemale.setBounds(500,340,100,30);
        RadioFemale.setForeground(Color.black);
        RadioFemale.setFont(new Font("raleway",Font.BOLD,12));
        add(RadioFemale);

        ButtonGroup sgender =new ButtonGroup();
        sgender.add(RadioMale);
        sgender.add(RadioFemale);
        sgender.add(RadioOther);

        JLabel text3 =new JLabel("Email Address :");
        text3.setBounds(100,380,600,40);
        text3.setForeground(Color.black);
        text3.setFont(new Font("raleway",Font.BOLD,20));
        add(text3);

        EmailTextFill = new JTextField(15);
        EmailTextFill.setBounds(260,390,350,25);
        EmailTextFill.setFont(new Font("raleway",Font.BOLD,14));
        EmailTextFill.setForeground(Color.black);
        EmailTextFill.setBackground(Color.white);
        add(EmailTextFill);

        JLabel text4 =new JLabel("Marital Status :");
        text4.setBounds(100,430,600,40);
        text4.setForeground(Color.black);
        text4.setFont(new Font("raleway",Font.BOLD,20));
        add(text4);

        RadioMarried = new JRadioButton("Married");
        RadioMarried.setForeground(Color.black);
        RadioMarried.setBounds(310,440,120,30);
        RadioMarried.setFont(new Font("raleway",Font.BOLD,12));
        add(RadioMarried);

        RadioUnMarried = new JRadioButton("Un-Married");
        RadioUnMarried.setBounds(450,440,140,30);
        RadioUnMarried.setForeground(Color.black);
        RadioUnMarried.setFont(new Font("raleway",Font.BOLD,12));
        add(RadioUnMarried);

        ButtonGroup Married =new ButtonGroup();
        Married.add(RadioMarried);
        Married.add(RadioUnMarried);

        JLabel text5 =new JLabel("Address :");
        text5.setBounds(100,480,660,40);
        text5.setForeground(Color.black);
        text5.setFont(new Font("raleway",Font.BOLD,20));
        add(text5);

        AdressTextFill = new JTextField(15);
        AdressTextFill.setBounds(260,490,350,25);
        AdressTextFill.setFont(new Font("raleway",Font.BOLD,14));
        AdressTextFill.setForeground(Color.black);
        AdressTextFill.setBackground(Color.white);
        add(AdressTextFill);

        JLabel text6 =new JLabel("City :");
        text6.setBounds(100,530,720,40);
        text6.setForeground(Color.black);
        text6.setFont(new Font("raleway",Font.BOLD,20));
        add(text6);

        cityTextFill = new JTextField(15);
        cityTextFill.setBounds(260,540,350,25);
        cityTextFill.setFont(new Font("raleway",Font.BOLD,14));
        cityTextFill.setForeground(Color.black);
        cityTextFill.setBackground(Color.white);
        add(cityTextFill);

        JLabel text9  =new JLabel("Pincode :");
        text9.setBounds(100,580,600,40);
        text9.setForeground(Color.black);
        text9.setFont(new Font("raleway",Font.BOLD,20));
        add(text9);

        PinCodeTextFill = new JTextField(15);
        PinCodeTextFill.setBounds(260,590,350,25);
        PinCodeTextFill.setFont(new Font("raleway",Font.BOLD,14));
        PinCodeTextFill.setBackground(Color.white);
        PinCodeTextFill.setForeground(Color.black);
        add(PinCodeTextFill);

        signUpNext = new JButton("NEXT");
        signUpNext.setFont(new Font("raleway", Font.BOLD,14));
        signUpNext.setBounds(530,630,80,30);
        signUpNext.setForeground(Color.BLACK);
        signUpNext.setBackground(Color.BLACK);
        add(signUpNext);
        signUpNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name =NameTextFill.getText();
                String fathername = FaTextFill.getText();
                String Adress = AdressTextFill.getText();
                String pincode = PinCodeTextFill.getText();
                String city = cityTextFill.getText();
                String email = EmailTextFill.getText();
                String date= ((JTextField)JDateChoos.getDateEditor().getUiComponent()).getText();
                String gender = null ;
                if(RadioMale.isSelected()){
                    gender = "Male";
                }else if(RadioFemale.isSelected()){
                    gender = "Female";
                } else if (RadioOther.isSelected()) {
                    gender = "Other";
                }
                String married = null;
                if (RadioMarried.isSelected()){
                    married = "Married";
                } else if (RadioUnMarried.isSelected()) {
                    married = "UnMarried";
                }
                String formNo = "" + fno;

                try {
                    if (name.equals("")){
                        JOptionPane.showMessageDialog(null,"Name is Required");
                        if (fathername.equals("")) {
                            JOptionPane.showMessageDialog(null,"Father Name is Required");
                            if (Adress.equals("")) {
                                JOptionPane.showMessageDialog(null,"Adress is Required");
                                if (pincode.equals("")) {
                                    JOptionPane.showMessageDialog(null,"Pincode is Required");
                                    if (city.equals("")) {
                                        JOptionPane.showMessageDialog(null,"City is Required");
                                        if (email.equals("")) {
                                            JOptionPane.showMessageDialog(null,"email is Required");
                                            if (date.equals("")) {
                                                JOptionPane.showMessageDialog(null,"Date is Required");
                                                if (date.equals("")) {
                                                    JOptionPane.showMessageDialog(null,"Date is Required");
                                                    if (gender==null) {
                                                        JOptionPane.showMessageDialog(null, "Gender is Required");
                                                        if (married == null) {
                                                            JOptionPane.showMessageDialog(null, "Married Status is Required");
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }else {
                        Connect c = new Connect();
                        c.stmt.executeUpdate("insert into signup values('"+formNo+"','"+name+"','"+fathername+"','"+gender+"','"+date+"','"+email+"','"+Adress+"','"+city+"','"+pincode+"','"+married+"')");
                        System.out.println("One Row inserted......Sucesss...!!!!");
                        setVisible(false);
                        new SignUpTwo(formNo).setVisible(true);

                    }






                }catch (Exception er){
                    System.err.println(er);
                }

            }
        });



    }

    public static void main(String args[]){
        new SignUpOne();
    }
}
