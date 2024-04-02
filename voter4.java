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

public class voter4 implements Initializable{

    @FXML
    private AnchorPane voter4;

    @FXML
    private TableView<votermodal> TABLE;
   

    @FXML
    private TableColumn<votermodal, String> fn;

    @FXML
    private TableColumn<votermodal, String> c;

    @FXML
    private TableColumn<votermodal, String> p;

    @FXML
    private TableColumn<votermodal, String> vp;

    @FXML
    private TableColumn<votermodal, String> s;
    @FXML
    private Label countnum;
    private ObservableList <votermodal> data ;
   

    String url = "jdbc:mysql://localhost:3306/vote";
	String user = "root";
		String pass = "143Mother";
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try { 
				Connection mycon = DriverManager.getConnection(url,user,pass);
				Statement mystat = mycon.createStatement();
				data = FXCollections.observableArrayList();
				ResultSet rs = mystat.executeQuery("select * from artvoter");				
				while(rs.next()) {
					data.add(new votermodal(rs.getString("full_name"),rs.getString("club"),
							rs.getString("president"),rs.getString("vice_president"),rs.getString("secretary")));
				}
		}

		catch(Exception ex) {
			ex.printStackTrace();
		}
			fn.setCellValueFactory(new PropertyValueFactory<>("fullname"));
			c.setCellValueFactory(new PropertyValueFactory<>("club"));
			p.setCellValueFactory(new PropertyValueFactory<>("president"));
			
			vp.setCellValueFactory(new PropertyValueFactory<>("vicep"));
			s.setCellValueFactory(new PropertyValueFactory<>("secretary"));

			TABLE.setItems(null);
			TABLE.setItems(data);
			
	}
public void counttt(ActionEvent eve) {
   		
   		try { 
   			Connection mycon = DriverManager.getConnection(url,user,pass);
   			Statement mystat = mycon.createStatement();
   			ResultSet rs = mystat.executeQuery("select count(full_name) as result from artvoter");
   			while(rs.next()) {
   				countnum.setText(rs.getString("result"));
   			}
   	}   		
   	catch(Exception ex) {
   		ex.printStackTrace();
   	}
   		
   	}
   	
   		public void delete(ActionEvent event) {
   	    	TABLE.getItems().removeAll(TABLE.getSelectionModel().getSelectedItems());
   	    	
   	    	try { 
   				Connection mycon = DriverManager.getConnection(url,user,pass);
   				Statement mystat = mycon.createStatement();
   				mystat.executeUpdate("delete from artvoter where full_name = ?");
   				JOptionPane.showMessageDialog(null, "Successfully Deleted!");	    			
   				
   		}   		
   		catch(Exception ex) {
   			ex.printStackTrace();
   		}
   		}
 

}
