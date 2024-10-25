package L21Sikkerhed;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.*;
import java.util.HashMap;

public class Gui extends Application {
	Button btnLogin, btnOpret, btnscene2;
	Label lblbrugernavn, lblPassword, lblBesked;
	Label lblscene2, lblInfoBruger;
	GridPane pane1, pane2;
	Scene scene1, scene2;
	Stage thestage;
	HashMap<String, String> brugere = new HashMap<>();
	private PasswordField password = new PasswordField();
	private static TextField brugernavn = new TextField();

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		thestage = primaryStage;

		btnLogin = new Button("Log in");
		btnOpret = new Button("Opret");
		btnscene2 = new Button("Tilbage til log in");
		btnLogin.setOnAction(e -> ButtonClicked(e));
		btnOpret.setOnAction(e -> ButtonClicked(e));
		btnscene2.setOnAction(e -> ButtonClicked(e));
		lblbrugernavn = new Label("Navn");
		lblPassword = new Label("Password");
		lblBesked = new Label("Hello World");

		lblscene2 = new Label("Du er nu logget ind");
		lblInfoBruger = new Label("Bruger info");

		pane1 = new GridPane();
		pane2 = new GridPane();
		pane1.setVgap(10);
		pane2.setVgap(10);

		pane1.setStyle("-fx-background-color: yellow;-fx-padding: 10px;");
		pane2.setStyle("-fx-background-color: lightgreen;-fx-padding: 10px;");

		pane1.setPadding(new Insets(5));
		pane1.setHgap(10);
		pane1.setVgap(10);

		pane1.add(lblbrugernavn, 0, 0);
		pane1.add(brugernavn, 0, 1, 2, 1);
		pane1.add(lblPassword, 0, 2);
		pane1.add(password, 0, 3, 2, 1);
		pane1.add(btnLogin, 0, 4);
		pane1.add(btnOpret, 1, 4);
		pane1.add(lblBesked, 0, 5);

		pane2.setPadding(new Insets(5));
		pane2.setHgap(10);
		pane2.setVgap(10);

		pane2.add(lblInfoBruger, 0, 0);
		pane2.add(btnscene2, 0, 1);

		scene1 = new Scene(pane1, 200, 200);
		scene2 = new Scene(pane2, 200, 200);

		primaryStage.setTitle("Hello World!");
		primaryStage.setScene(scene1);
		primaryStage.show();
	}


	public void ButtonClicked(ActionEvent e) {
		if (e.getSource() == btnLogin) {
			String username = brugernavn.getText();
			String kode = password.getText();

			// Validate login credentials
			if (validateLogin(username, kode)) {
				lblBesked.setText("Du er nu logget ind");
				thestage.setScene(scene2);
				lblInfoBruger.setText("Bruger info: " + username);
			} else {
				lblBesked.setText("Forkert brugernavn eller password");
			}
		} else if (e.getSource() == btnOpret) {
			String username = brugernavn.getText();
			String kode = password.getText();

			// Create new user in the database
			if (createUser(username, kode)) {
				lblBesked.setText("Bruger oprettet med succes");
			} else {
				lblBesked.setText("Fejl ved oprettelse af bruger");
			}
		} else {
			lblBesked.setText("");
			password.clear();
			brugernavn.clear();
			thestage.setScene(scene1);
		}
	}

	private boolean validateLogin(String username, String password) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=SikkerhedsOpgave;user=sa;password=reallyStrongPwd123;");

			String sql = "SELECT kode, salt FROM Brugere WHERE brugernavn=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				// Retrieve stored hashed password and salt
				byte[] storedHashedPassword = rs.getBytes("kode");
				byte[] salt = rs.getBytes("salt");

				// Hash the provided password with the retrieved salt
				byte[] hashedPassword = hashPassword(password, salt);

				// Compare hashed passwords
				if (MessageDigest.isEqual(storedHashedPassword, hashedPassword)) {
					// Passwords match
					conn.close();
					return true;
				}
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	private boolean createUser(String username, String password) {
		// Generate salt
		byte[] salt = generateSalt();

		// Hash password with salt
		byte[] hashedPassword = hashPassword(password, salt);

		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=SikkerhedsOpgave;user=sa;password=reallyStrongPwd123;");

			String sql = "INSERT INTO Brugere (brugernavn, kode, salt) VALUES (?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setBytes(2, hashedPassword);
			stmt.setBytes(3, salt);

			int rowsAffected = stmt.executeUpdate();
			conn.close();

			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	private byte[] generateSalt() {
		byte[] salt = new byte[16];
		new SecureRandom().nextBytes(salt);
		return salt;
	}

	private byte[] hashPassword(String password, byte[] salt) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			digest.reset();
			digest.update(salt);
			return digest.digest(password.getBytes());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
}
