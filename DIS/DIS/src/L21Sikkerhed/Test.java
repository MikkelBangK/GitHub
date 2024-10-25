package L21Sikkerhed;

import java.sql.*;
import java.security.SecureRandom;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Test {


    public class Main {
        public static void main(String[] args) throws NoSuchAlgorithmException {
            String brugernavn = "alice";
            String adgangskode = "hemmeligAdgangskode";

            // Generer et tilfældigt salt
            byte[] salt = generateSalt();

            // Generer hash af passwordet
            byte[] hash = generateHash(adgangskode, salt);

            // Opret forbindelse til databasen
            try (Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=SikkerhedsOpgave;user=sa;password=reallyStrongPwd123;")) {
                // Opret en SQL-forespørgsel for at indsætte en ny bruger i databasen
                String sql = "INSERT INTO Brugere (brugernavn, salt, hash) VALUES (?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, brugernavn);
                stmt.setBytes(2, salt);
                stmt.setBytes(3, hash);

                // Udfør forespørgslen
                stmt.executeUpdate();
                System.out.println("Bruger oprettet med succes.");

                // Valider brugerens adgangskode
                boolean valideret = validatePassword(conn, brugernavn, adgangskode);
                if (valideret) {
                    System.out.println("Adgangskode valideret.");
                } else {
                    System.out.println("Forkert adgangskode.");
                }
            } catch (NoSuchAlgorithmException | SQLException e) {
                e.printStackTrace();
            }
        }

        // Metode til at generere et tilfældigt salt
        private static byte[] generateSalt() {
            byte[] salt = new byte[16];
            new SecureRandom().nextBytes(salt);
            return salt;
        }

        // Metode til at generere hash af passwordet
        private static byte[] generateHash(String password, byte[] salt) throws NoSuchAlgorithmException {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.reset();
            digest.update(salt);
            return digest.digest(password.getBytes());
        }

        // Metode til at validere brugerens adgangskode
        private static boolean validatePassword(Connection conn, String brugernavn, String adgangskode) throws SQLException, NoSuchAlgorithmException {
            // Hent salt og hash fra databasen
            String sql = "SELECT salt, hash FROM Brugere WHERE brugernavn = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, brugernavn);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                byte[] salt = rs.getBytes("salt");
                byte[] dbHash = rs.getBytes("hash");

                // Generer hash af passwordet med samme salt
                byte[] hash = generateHash(adgangskode, salt);

                // Sammenlign hashværdier
                return MessageDigest.isEqual(dbHash, hash);
            }
            return false;
        }
    }
}
