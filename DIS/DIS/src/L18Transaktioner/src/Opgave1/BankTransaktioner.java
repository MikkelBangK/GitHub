package L18Transaktioner.src.Opgave1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class BankTransaktioner {
    public static void main(String[] args) {
        try {
            Connection minConnection = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=Transaktioner;user=sa;password=reallyStrongPwd123;");
            Scanner input = new Scanner(System.in);

            System.out.println("Indtast kontoNr fra konto du vil sende fra:");
            String ktoNr = input.nextLine();
            Statement stmt = minConnection.createStatement();
            ResultSet res = stmt.executeQuery("SELECT saldo FROM Konto WHERE ktoNr =" + ktoNr);

            double saldo1 = 0.0;
            while (res.next()) {
                saldo1 = res.getDouble(1);
                System.out.println("Saldo for konto " + ktoNr + ": " + saldo1);
            }


            System.out.println("Indtast beløb der skal hæves frakonto:");
            double belobHeves = input.nextDouble();
            input.nextLine();
            if(belobHeves <= saldo1) {
                String updateQuery = "UPDATE Konto SET saldo = saldo - " + belobHeves + " WHERE ktoNr = '" + ktoNr + "'";


                System.out.println("Indtast kontoNr for tilKonto:");
                ktoNr = input.nextLine();
                res = stmt.executeQuery("SELECT saldo FROM Konto WHERE ktoNr =" + ktoNr);
                double saldo2 = 0.0;
                while (res.next()) {
                    saldo2 = res.getDouble(1);
                    System.out.println("Saldo for konto " + ktoNr + ": " + saldo2);
                }
            }else {
                System.out.println("FEJL SALDO MINDRE");
            }



        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}