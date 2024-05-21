package bank.managment.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connect {

    Connection con;
    Statement stmt;
    Connect(){
        try {
            //MYSQL Database JDBC connectivity
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","root123");
            System.out.println("Connection Establisch");

            stmt=con.createStatement();

            stmt.execute("use bankmanagmentsystem");
            System.out.println("Using Bank Management System");

        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new Connect();

    }

}
