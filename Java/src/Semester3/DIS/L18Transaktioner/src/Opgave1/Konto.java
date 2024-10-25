package Opgave1;

import java.sql.Connection;
import java.sql.DriverManager;

public class Konto {
    public static void main(String[] args) {
        try {
            Connection minConnection;
            minConnection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost;databaseName=Transaktioner;user=sa;password=reallyStrongPwd123;");


        } catch (Exception e){

        }
    }
}
