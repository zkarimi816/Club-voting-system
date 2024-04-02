package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ArtCandidateControllar implements Initializable {
	
	ObservableList <String > positionlist = FXCollections.observableArrayList("President", "Vice President","Secretary");
	ObservableList <String > clublist = FXCollections.observableArrayList("Art Club");
	@FXML
    private AnchorPane artcandidateform;

    @FXML
    private TextField candidatename;

    @FXML
    private TextField candidatemajor;

    @FXML
    private TextField candidategpa;

    @FXML
    private RadioButton junior;

    @FXML
    private ToggleGroup tg3;

    @FXML
    private RadioButton senior;

    @FXML
    private TextField candidateemail;

    @FXML
    private ComboBox<String> choiceposition;

    @FXML
    private TextField candidateage;
    
    @FXML
    private ComboBox<String> choiceclub;
    @FXML
    private TableView<CTableModal> TABLE;

    @FXML
    private TableColumn<CTableModal , Integer> c_id;

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
    private TextField candidate_id;
    @FXML
    AnchorPane Candidate;
    
    private ObservableList <CTableModal> data ;
    private ObservableList <CTableModal> data2 ;
    
    
    String url = "jdbc:mysql://localhost:3306/vote";
	String user = "root";
	String pass = "143Mother";

	@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
		choiceposition.setValue("Select a Position");
    	choiceposition.setItems(positionlist);
    	choiceclub.setValue("Select a Club");
    	choiceclub.setItems(clublist);
    	setcellvaluefromtable() ;
	}

		private void setcellvaluefromtable() {
 	   TABLE.setOnMouseClicked(new EventHandler <MouseEvent>() {
 		   @Override 
 		   public void handle(MouseEvent event){
 			   CTableModal t1 = TABLE.getItems().get(TABLE.getSelectionModel().getSelectedIndex());
 			   candidatename.setText(t1.getfullname());
 			   candidateage.setText(String.valueOf(t1.getage()));
 			   candidategpa.setText(String.valueOf(t1.getgpa()));
 			   candidate_id.setText(String.valueOf(t1.getid()));
 			   candidatemajor.setText(t1.getmajor());
 			   candidateemail.setText(t1.getemial());
 			   choiceposition.setValue(t1.getposition());
 			   choiceclub.setValue(t1.getclub());
 			   if(null!= t1.getstatus()) switch(t1.getstatus()) {
 			   case"Junior":
 				   junior.setSelected(true);
 				   break;
 			   case"Senior":
 				   senior.setSelected(true);
 				   break;
 			   default :
 				   junior.setSelected(false);
 				   senior.setSelected(false);
 				   break;
 			   }else {
 				   junior.setSelected(false);
 				   senior.setSelected(false);
 			   }

 	   }
 		   
 	   });
    }
		public String getstatus() {
		String stat = "";
		if(junior.isSelected()) {
			stat = "Junior";
		}else {
			stat = "Senior";
			
		}
		return stat;
	}
	
		public void candidate(ActionEvent event) {
	 	String ID=  candidate_id.getText();
    	String flname = candidatename.getText();
    	String Major = candidatemajor.getText();
    	String Status= getstatus();
    	String Age = candidateage.getText();
    	String cemail =candidateemail.getText();
    	String Gpa= candidategpa.getText();
    	String Position = choiceposition.getValue();
    	String Club = choiceclub.getValue();
    	
	if(!Gpa.equals("2.9")&&!Gpa.equals("2.8")&&!Gpa.equals("2.7")&&!Gpa.equals("2.6")
			&&!Gpa.equals("2.5")&&!Gpa.equals("2.4")&&!Gpa.equals("2.3")&&!Gpa.equals("2.2")
			&&!Gpa.equals("2.1")&&!Gpa.equals("2.0")&&!Gpa.equals("1.9")) {
		try { 
			Connection mycon = DriverManager.getConnection(url,user,pass);
			Statement mystat = mycon.createStatement();
			mystat.executeUpdate("insert into candidates (id,full_name,age,major,gpa,email,status,position,club) values('"
			+ID+"','"+flname+"','"+Age+"','"+Major+"','"+Gpa+"','"+cemail+"','"+Status+"','"+Position+"','"+Club+"')");
			JOptionPane.showMessageDialog(null, "Successfully Candidated");	
			data = FXCollections.observableArrayList();
			ResultSet rs = mystat.executeQuery("select * from candidates where club = 'Art Club' and gpa >= 3.0 and id= '"+ ID +"'");
			
			while(rs.next()) {
				data.add(new CTableModal(rs.getInt("id"),rs.getString("full_name"),rs.getInt("age"),
						rs.getString("major"),rs.getDouble("gpa"),rs.getString("email"),rs.getString("status"),
						rs.getString("position"),rs.getString("club")));
			}
	}   		 
	catch(Exception ex) {
		ex.printStackTrace();
	}
		c_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		fullname.setCellValueFactory(new PropertyValueFactory<>("fullname"));
		age.setCellValueFactory(new PropertyValueFactory<>("age"));
		
		major.setCellValueFactory(new PropertyValueFactory<>("major"));
		gpa.setCellValueFactory(new PropertyValueFactory<>("gpa"));
		
		email.setCellValueFactory(new PropertyValueFactory<>("email"));
		status.setCellValueFactory(new PropertyValueFactory<>("status"));
		
		position.setCellValueFactory(new PropertyValueFactory<>("position"));
		club.setCellValueFactory(new PropertyValueFactory<>("club"));
		
		
		TABLE.setItems(null);
		TABLE.setItems(data);
		clearfields() ;
		
	}else {
		JOptionPane.showMessageDialog(null, "Sorry, You are not eligible!");
	}
	}
		private void clearfields() {
	    	candidatename.setText(null);
	    	candidate_id.setText(null);
	    	candidategpa.setText(null);   	
	    	candidateemail.setText(null);
	    	candidatemajor.setText(null);
	    	candidateage.setText(null);
	    	senior.setSelected(false);
	    	junior.setSelected(false);
	    	choiceposition.setValue("Select a Position");
	    	choiceclub.setValue("Select a Club");
	    }

	  /*  public void reset() {
	    candidate_id.clear();
		candidatename.clear();
		candidategpa.clear();   	
		candidateemail.clear();
		candidatemajor.clear();
		candidateage.clear();
		senior.setSelected(false);
		junior.setSelected(false);
		choiceposition.setValue("Select a position");
		choiceclub.setValue("Select a club");
	}*/

	    public void deletebutton(ActionEvent event) {
	    	TABLE.getItems().removeAll(TABLE.getSelectionModel().getSelectedItems());
	    	 String ID=  candidate_id.getText();
	    
	    	try { 
				Connection mycon = DriverManager.getConnection(url,user,pass);
				Statement mystat = mycon.createStatement();
				mystat.executeUpdate("delete from candidates where id = '"+ID+"'");
				JOptionPane.showMessageDialog(null, "Successfully Deleted!");	    			
				
		}   		
		catch(Exception ex) {
			ex.printStackTrace();
		}
	    }

	   /* @FXML
	    private void viewallbutton(ActionEvent ev) {
	    String id=  candidate_id.getText();
			try { 
				Connection mycon = DriverManager.getConnection(url,user,pass);
				Statement mystat = mycon.createStatement();
				data = FXCollections.observableArrayList();
				ResultSet rs = mystat.executeQuery("select * from candidates where club = 'Art Club' and gpa >= 3.0 and id = '"+id+"'");				
				while(rs.next()) {

					data.add(new CTableModal(rs.getInt("id"),rs.getString("full_name"),rs.getInt("age"),
							rs.getString("major"),rs.getDouble("gpa"),rs.getString("email"),rs.getString("status"),
							rs.getString("position"),rs.getString("club")));
				}
		}

		catch(Exception ex) {
			ex.printStackTrace();
		}
			c_id.setCellValueFactory(new PropertyValueFactory<>("id"));
			fullname.setCellValueFactory(new PropertyValueFactory<>("fullname"));
			age.setCellValueFactory(new PropertyValueFactory<>("age"));
			
			major.setCellValueFactory(new PropertyValueFactory<>("major"));
			gpa.setCellValueFactory(new PropertyValueFactory<>("gpa"));
			
			email.setCellValueFactory(new PropertyValueFactory<>("email"));
			status.setCellValueFactory(new PropertyValueFactory<>("status"));
			
			position.setCellValueFactory(new PropertyValueFactory<>("position"));
			club.setCellValueFactory(new PropertyValueFactory<>("club"));
			
			
			TABLE.setItems(null);
			TABLE.setItems(data);
	    }
*/
	    @FXML
	    private void updatebutton(ActionEvent event) {
	    	  // TABLE.getItems().get(TABLE.getSelectionModel().getSelectedIndex());
	    	setcellvaluefromtable() ;
	    	    String id=  candidate_id.getText();
			    String fullName = candidatename.getText();
		    	String Majorr = candidatemajor.getText();
		    	String Statuss= getstatus();
		    	String Agee = candidateage.getText();
		    	String cemaill =candidateemail.getText();
		    	String Gpaa= candidategpa.getText();
		    	String Positionn = choiceposition.getValue();
		    	String Clubb = choiceclub.getValue();
			  try { 
	    			Connection mycon = DriverManager.getConnection(url,user,pass);
	    			Statement mystat = mycon.createStatement();
	    			mystat.executeUpdate("update candidates set full_name = '"+fullName+"',age = '"+Agee+"', major= '"+Majorr+
	    					"',gpa= '"+Gpaa+"',email = '"+cemaill+"',status=' "+Statuss+"',position= '"+ Positionn+
	    					"',club='"+Clubb+"' where id= '"+id+"'");
	    			JOptionPane.showMessageDialog(null, "Successfully Updated!");
	    			data2 = FXCollections.observableArrayList();
					ResultSet rs = mystat.executeQuery("select * from candidates where club = 'Art Club' and gpa>=3.0 and id = '"+id+"'");
					
					while(rs.next()) {
						data2.add(new CTableModal(rs.getInt("id"),rs.getString("full_name"),rs.getInt("age"),
								rs.getString("major"),rs.getDouble("gpa"),rs.getString("email"),rs.getString("status"),
								rs.getString("position"),rs.getString("club")));
					}
	    	}   		
	    	catch(Exception ex) {
	    		ex.printStackTrace();
	    	}
	    		c_id.setCellValueFactory(new PropertyValueFactory<>("id"));
	    		fullname.setCellValueFactory(new PropertyValueFactory<>("fullname"));
				age.setCellValueFactory(new PropertyValueFactory<>("age"));
				
				major.setCellValueFactory(new PropertyValueFactory<>("major"));
				gpa.setCellValueFactory(new PropertyValueFactory<>("gpa"));
				
				email.setCellValueFactory(new PropertyValueFactory<>("email"));
				status.setCellValueFactory(new PropertyValueFactory<>("status"));
				
				position.setCellValueFactory(new PropertyValueFactory<>("position"));
				club.setCellValueFactory(new PropertyValueFactory<>("club"));
				
				TABLE.setItems(null);
				TABLE.setItems(data2);
		   }
	    private void setNode(Node node) {
	    	artcandidateform.getChildren().add((Node) node);
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
	  			Candidate = FXMLLoader.load(getClass().getResource("/application/Home.fxml"));
				setNode(Candidate);
			}catch(IOException e) {
				e.printStackTrace();
			}
	  		
	  	}
	  	public void all(ActionEvent eve) {
	  		try {
	    		Parent root = FXMLLoader.load(getClass().getResource("/application/allcandidatesart.fxml"));
	    		Scene scene = new Scene(root ,700, 353);
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