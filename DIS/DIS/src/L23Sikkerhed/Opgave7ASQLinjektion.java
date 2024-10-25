package L23Sikkerhed;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class Opgave7ASQLinjektion {
        public static void main(String[] args) {
            BufferedReader inLine;
            Connection minConnection;
            try {
                inLine = new BufferedReader(new
                        InputStreamReader(System.in));
                System.out.println("Indtast a eller b for delopgave a eller b");
                String delopgave = inLine.readLine();
                minConnection =
                        DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=SQLInjections;user=sa;password=reallyStrongPwd123;");
                if (delopgave.equals("a")) { // denne del bruges til delopgavene 2 - 4
                    System.out.println("Indtast brugernavn");
                    String s1 =inLine.readLine();
                    System.out.println("Indtast password");
                    String s2 =inLine.readLine();

                    //Beskyttelse mod SQL injection
                    String ss = "select * from brugere where brugerid = ? and passw = ?";
                    PreparedStatement pstmt = minConnection.prepareStatement(ss);
                    pstmt.setString(1, s1);
                    pstmt.setString(2, s2);

                    ResultSet res=pstmt.executeQuery();
                    if (res.next()) {
                        System.out.print("Velkommen du er nu logget ind");
                    }
                    else
                        System.out.print("Ukorrekt logon");
                    if (pstmt != null)
                        pstmt.close();
                    if (minConnection != null)
                        minConnection.close();
                }
                else { // denne del anvendes til delopgave 5
                    System.out.println("Indtast søgestreng");
                    String s3 =inLine.readLine();
                    String s = "select produktnavn,lagerantal,pris from produkt " +
                            "where produktnavn like '" + s3 + "%'";
                    System.out.println(s);
                    Statement stmt2 = minConnection.createStatement();
                    ResultSet res2=stmt2.executeQuery(s);
                    while (res2.next()) {
                        System.out.println (res2.getString(1) + " " + res2.getInt(2) +
                                " " + res2.getFloat(3));
                    }
                    if (stmt2 != null)
                        stmt2.close();
                    if (minConnection != null)
                        minConnection.close();
                }
            }
            catch (Exception e) {
                System.out.print("fejl: "+e.getMessage());
            }
        }
    }

