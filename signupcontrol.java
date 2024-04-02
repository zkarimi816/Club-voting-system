package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
//import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class signupcontrol {

	    @FXML
	    private  PasswordField  password;

	    @FXML
	    private PasswordField cpassword;

	    @FXML
	    private TextField email;

	    @FXML
	    private TextField UserName;
	    
	   /* public String getgender() {
	    	String gen = "";
	    	if(male.isSelected()) {
	    		gen = "Male";
	    	}else if (female.isSelected()) {
	    		gen = "Female";
	    	}else {
	    		gen = "Other";
	    	}
	    	return gen;
	    }*/
	    
	    public void signup(ActionEvent e) {
	    	String url = "jdbc:mysql://localhost:3306/vote";
	    	String user = "root";
	    	String pass = "143Mother";

	    	String uname= UserName.getText();
	    	String uemail = email.getText();
	    	String Pass = password.getText();
	    	String CPass = cpassword.getText();
	    	
	    	try {
				Connection mycon = DriverManager.getConnection(url,user,pass);
				Statement mystat = mycon.createStatement();
				
				if(!Pass.equals(CPass)) {
					JOptionPane.showMessageDialog(null, "Passwords do not match! ");
				}else if(Pass.equals (CPass)) {
					mystat.executeUpdate("insert into users (User_Name,Email,Password,confirm_pass) values('"+
							uname+"','"+uemail+"','"+Pass+"','"+CPass+"')");
					JOptionPane.showMessageDialog(null, "Successfully Signed Up!");	
					
				}
				clearfields();
	    	}catch(Exception ex) {
			ex.printStackTrace();
		}
	    	
	    	
	    	
	    }
	    public void login(ActionEvent e) {
	    	try {
	    		Parent root = FXMLLoader.load(getClass().getResource("/application/log_in.fxml"));
	    		Scene scene = new Scene(root,700,500);
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
	    private void clearfields() {
	    	password.setText(null);
	    	cpassword.setText(null);
	    	UserName.setText(null);   	
	    	email.setText(null);
	    	
	    }
}
