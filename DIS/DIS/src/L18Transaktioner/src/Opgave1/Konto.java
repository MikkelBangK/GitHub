package Opgave1;

import java.sql.*;
import java.util.Scanner;


public class Konto {
    public static void main(String[] args) {
        try {
            Connection minConnection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost;databaseName=Transaktioner;user=sa;password=reallyStrongPwd123;");

            Scanner input = new Scanner(System.in);

            System.out.print("Indtast fra konto nummer: ");
            String konto1 = input.nextLine();

            Statement stmt = minConnection.createStatement();
            //1234567
            ResultSet res = stmt.executeQuery("SELECT saldo FROM Konto WHERE ktoNr ="+konto1);

            double saldo1 = 0.0;
            if (res.next()){
                saldo1 = res.getDouble(1);
                System.out.println("Saldo for konto: " + konto1 + ": " +saldo1);
            }

            System.out.print("Indtast beløb som skal hæves fra kontoen: ");
            double beløbYeetes = input.nextDouble();
            input.nextLine();
            if (saldo1 >= beløbYeetes) {
                String queryUpdate = "UPDATE Konto SET saldo = saldo + ? WHERE ktoNr = ?";
                PreparedStatement pstmt = minConnection.prepareStatement(queryUpdate);

                pstmt.setDouble(1, beløbYeetes);
                pstmt.setString(2, konto1);
                pstmt.executeUpdate();



                System.out.print("Indtast til konto nummer: ");
                String konto2 = input.nextLine();

                res = stmt.executeQuery("SELECT saldo FROM Konto WHERE ktoNr =" + konto2);
                double saldo2 = 0.0;
                while (res.next()) {
                    saldo2 = res.getDouble(1);
                    System.out.println("Saldo for konto: " + konto2 + ": " + saldo2);
                }
            } else {
                System.out.println("Du har ikke nok penge på kontoen");
            }




        } catch (Exception e){

        }
    }
}
