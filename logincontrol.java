package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class logincontrol {
	
    @FXML
    private TextField username;

    @FXML
    private PasswordField txtpass;
    
    String url = "jdbc:mysql://localhost:3306/vote";
	String user = "root";
	String pass = "143Mother";

    public void loginAction(ActionEvent e) {
    	String uname = username.getText();
		String pw = txtpass.getText();	
		try {
			Connection mycon = DriverManager.getConnection(url,user,pass);
			Statement mystat = mycon.createStatement();
			ResultSet myres = mystat.executeQuery("select * from users where User_Name= '"+uname+"' and Password= '"+pw+"'");
			
				if(uname.equals("admin") && pw.equals("admin")){
					JOptionPane.showMessageDialog(null,"Welcome Administrator! ");
					Parent proceed = FXMLLoader.load(getClass().getResource("/application/adminpage.fxml"));
					Scene scene = new Scene(proceed, 700,508);
					Stage stage = new Stage();
					stage.setScene(scene);
					stage.setTitle("Club Voting System");
					stage.show();
					stage.setResizable(false);
				}else if (myres.next()){
				JOptionPane.showMessageDialog(null,"Welcome "+uname);
				Parent proceed = FXMLLoader.load(getClass().getResource("/application/HomePage.fxml"));
				Scene scene = new Scene(proceed, 739,570);
				Stage stage = new Stage();
				stage.setScene(scene);
				stage.setTitle("Club Voting System");
				stage.show();
				stage.setResizable(false);
			}else {
				JOptionPane.showMessageDialog(null, "This username doesnt exist!");
			
			}
    }catch(Exception exec) {
		exec.printStackTrace();
	}
}
    public void signupAction(ActionEvent e) {
    	try {
    		Parent root = FXMLLoader.load(getClass().getResource("/application/Signup.fxml"));
    		Scene scene = new Scene(root ,700, 500);
    		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    		Stage stage = new Stage();
    		stage.setScene(scene);
    		stage.setTitle("Club Voting System");
    		stage.show();
    		stage.setResizable(false);
    	}catch(Exception exec) {
    		exec.printStackTrace();
    	}


    }
}
