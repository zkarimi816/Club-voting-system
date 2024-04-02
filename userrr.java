package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class userrr implements Initializable
{
	@FXML
    private AnchorPane user;

    @FXML
    private TableView<userrrrmodal> TABLE;

    @FXML
    private TableColumn<userrrrmodal, String> username;

    @FXML
    private TableColumn<userrrrmodal, String> email;

    @FXML
    private TableColumn<userrrrmodal, String> password;

    @FXML
    private Label countnum;

    private ObservableList <userrrrmodal> data ;
    String url = "jdbc:mysql://localhost:3306/vote";
	String userr = "root";
	String pass = "143Mother";
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		try { 
			Connection mycon = DriverManager.getConnection(url,userr,pass);
			Statement mystat = mycon.createStatement();
			data = FXCollections.observableArrayList();
			ResultSet rs = mystat.executeQuery("select * from users");				
			while(rs.next()) {
				data.add(new userrrrmodal(rs.getString("User_Name"),
						rs.getString("Email"),rs.getString("Password")));
			}
	}

	catch(Exception ex) {
		ex.printStackTrace();
	}
		username.setCellValueFactory(new PropertyValueFactory<>("username"));
		password.setCellValueFactory(new PropertyValueFactory<>("password"));
		email.setCellValueFactory(new PropertyValueFactory<>("email"));

		TABLE.setItems(data);
		
	}
	public void delete(ActionEvent event) {
    	TABLE.getItems().removeAll(TABLE.getSelectionModel().getSelectedItems());
    	
    	try { 
			Connection mycon = DriverManager.getConnection(url,userr,pass);
			Statement mystat = mycon.createStatement();
			mystat.executeUpdate("delete from candidates where User_Name = ?");
			JOptionPane.showMessageDialog(null, "Successfully Deleted!");	    			
			
	}   		
	catch(Exception ex) {
		ex.printStackTrace();
	}
    }
	public void counttt(ActionEvent eve) {
		try { 
			Connection mycon = DriverManager.getConnection(url,userr,pass);
			Statement mystat = mycon.createStatement();
			ResultSet rs = mystat.executeQuery("select count(User_Name) as result from users");
			while(rs.next()) {
				countnum.setText(rs.getString("result"));
			}
	}   		
	catch(Exception ex) {
		ex.printStackTrace();
	}
	}
	
	

}
