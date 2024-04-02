package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class ArtResultsController implements Initializable{
	@FXML
    private AnchorPane artresults;
 
    @FXML
    private TableView<DPresultsTablemodal> table1;

    @FXML
    private TableColumn<DPresultsTablemodal, String> president;

    @FXML
    private TableColumn<DPresultsTablemodal, String> results;
    
    @FXML
    private TableView<DPresultsTablemodal> table2;

    @FXML
    private TableColumn<DPresultsTablemodal, String> vpresident;

    @FXML
    private TableColumn<DPresultsTablemodal, String> result2;

    @FXML
    private TableView<DPresultsTablemodal> table3;

    @FXML
    private TableColumn<DPresultsTablemodal, String> secretary;

    @FXML
    private TableColumn<DPresultsTablemodal, String> result3;
    @FXML
    AnchorPane result;

    private ObservableList <DPresultsTablemodal> data ;
    private ObservableList <DPresultsTablemodal> data2 ;
    private ObservableList <DPresultsTablemodal> data3 ;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		String url = "jdbc:mysql://localhost:3306/vote";
		String user = "root";
		String pass = "143Mother";
		try { 
			Connection mycon = DriverManager.getConnection(url,user,pass);
			Statement mystat = mycon.createStatement();
			data = FXCollections.observableArrayList();
			ResultSet rs = mystat.executeQuery("select president, count(president) as result from artvoter where club = 'Art Club' group by president having count(president)>=1");
			
			while(rs.next()) {
				data.add(new DPresultsTablemodal(rs.getString("president"),rs.getString("result") ));
			}
	}

	catch(Exception ex) {
		ex.printStackTrace();
	}
	
		try { 
			Connection mycon = DriverManager.getConnection(url,user,pass);
			Statement mystat = mycon.createStatement();
			data2 = FXCollections.observableArrayList();
			ResultSet rs = mystat.executeQuery("select vice_president, count(vice_president) as result from artvoter where club = 'Art Club' group by vice_president having count(vice_president)>=1");
			
			while(rs.next()) {
				data2.add(new DPresultsTablemodal(rs.getString("vice_president"),rs.getString("result") ));
			}
	}

	catch(Exception ex) {
		ex.printStackTrace();
	}
		
		try { 
			Connection mycon = DriverManager.getConnection(url,user,pass);
			Statement mystat = mycon.createStatement();
			data3 = FXCollections.observableArrayList();
			ResultSet rs = mystat.executeQuery("select secretary, count(secretary) as result from artvoter where club = 'Art Club' group by secretary having count(secretary)>=1");
			
			while(rs.next()) {
				data3.add(new DPresultsTablemodal(rs.getString("secretary"),rs.getString("result") ));
			}
	}

	catch(Exception ex) {
		ex.printStackTrace();
	}
		
		
		president.setCellValueFactory(new PropertyValueFactory<>("president"));
		results.setCellValueFactory(new PropertyValueFactory<>("count"));
		
		vpresident.setCellValueFactory(new PropertyValueFactory<>("president"));
		result2.setCellValueFactory(new PropertyValueFactory<>("count"));
		
		secretary.setCellValueFactory(new PropertyValueFactory<>("president"));
		result3.setCellValueFactory(new PropertyValueFactory<>("count"));
		
		table1.setItems(null);
		table1.setItems(data);
		
		table2.setItems(null);
		table2.setItems(data2);
		
		table3.setItems(null);
		table3.setItems(data3);
	}
	
	private void setNode(Node node) {
		artresults.getChildren().add((Node) node);
    	FadeTransition ft = new FadeTransition(Duration.millis(1500));
    	ft.setNode(node);
    	ft.setFromValue(0.1);
    	ft.setToValue(1);
    	ft.setCycleCount(1);
    	ft.setAutoReverse(false);
    	ft.play();
    	
    }
  	public void backButton(ActionEvent event) {
  		try {
  			result = FXMLLoader.load(getClass().getResource("/application/Results.fxml"));
			setNode(result);
		}catch(IOException e) {
			e.printStackTrace();
		}
  		
  	}
	
	 
}
