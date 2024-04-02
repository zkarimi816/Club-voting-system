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

public class admincandidate implements Initializable{
	@FXML
    private AnchorPane  candidatess;

    @FXML
    private TableView<CTableModal> table;

    @FXML
    private TableColumn<CTableModal , Integer> id;

    @FXML
    private TableColumn<CTableModal , String> fullname;

    @FXML
    private TableColumn<CTableModal , Integer> age;

    @FXML
    private TableColumn<CTableModal , String> major;

    @FXML
    private TableColumn<CTableModal , Double> gpa;

    @FXML
    private TableColumn<CTableModal , String> email;

    @FXML
    private TableColumn<CTableModal , String> status;

    @FXML
    private TableColumn<CTableModal , String> position;

    @FXML
    private TableColumn<CTableModal , String> club;
    
    @FXML
    private Label countnum;
    private ObservableList <CTableModal> data ;
    String url = "jdbc:mysql://localhost:3306/vote";
		String user = "root";
		String pass = "143Mother";
   	@Override
   	public void initialize(URL arg0, ResourceBundle arg1) {
   		   			try { 
   				Connection mycon = DriverManager.getConnection(url,user,pass);
   				Statement mystat = mycon.createStatement();
   				data = FXCollections.observableArrayList();
   				ResultSet rs = mystat.executeQuery("select * from candidates");				
   				while(rs.next()) {

   					data.add(new CTableModal(rs.getInt("id"),rs.getString("full_name"),rs.getInt("age"),
   							rs.getString("major"),rs.getDouble("gpa"),rs.getString("email"),rs.getString("status"),
   							rs.getString("position"),rs.getString("club")));
   				}
   		}

   		catch(Exception ex) {
   			ex.printStackTrace();
   		}
   			id.setCellValueFactory(new PropertyValueFactory<>("id"));
   			fullname.setCellValueFactory(new PropertyValueFactory<>("fullname"));
   			age.setCellValueFactory(new PropertyValueFactory<>("age"));
   			
   			major.setCellValueFactory(new PropertyValueFactory<>("major"));
   			gpa.setCellValueFactory(new PropertyValueFactory<>("gpa"));
   			
   			email.setCellValueFactory(new PropertyValueFactory<>("email"));
   			status.setCellValueFactory(new PropertyValueFactory<>("status"));
   			
   			position.setCellValueFactory(new PropertyValueFactory<>("position"));
   			club.setCellValueFactory(new PropertyValueFactory<>("club"));
   			
   			
   			table.setItems(null);
   			table.setItems(data);
   		
   	}

   	public void counttt(ActionEvent eve) {
   		
   		try { 
   			Connection mycon = DriverManager.getConnection(url,user,pass);
   			Statement mystat = mycon.createStatement();
   			ResultSet rs = mystat.executeQuery("select count(full_name) as result from candidates");
   			while(rs.next()) {
   				countnum.setText(rs.getString("result"));
   			}
   	}   		
   	catch(Exception ex) {
   		ex.printStackTrace();
   	}
   	}
   	
   		public void delete(ActionEvent event) {
   	    	table.getItems().removeAll(table.getSelectionModel().getSelectedItems());
   	    	
   	    	try { 
   				Connection mycon = DriverManager.getConnection(url,user,pass);
   				Statement mystat = mycon.createStatement();
   				mystat.executeUpdate("delete from candidates where User_Name = ?");
   				JOptionPane.showMessageDialog(null, "Successfully Deleted!");	    			
   				
   		}   		
   		catch(Exception ex) {
   			ex.printStackTrace();
   		}
   	   
   	}
}
