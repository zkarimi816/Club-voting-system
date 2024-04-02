package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class ArtVoterControllar {
	

	    @FXML
	    private AnchorPane ArtVoterform;

	    @FXML
	    private TextField voterid;

	    @FXML
	    private TextField voterlname;

	    @FXML
	    private ComboBox<String> presidentlist;

	    @FXML
	    private ComboBox<String> vplist;

	    @FXML
	    private ComboBox<String> secretarylist;

	    @FXML
	    private TextField President;

	    @FXML
	    private TextField vpresident;

	    @FXML
	    private TextField secretary;
	    
	    @FXML
	    private ComboBox<String> clublist;

	    @FXML
	    private TextField club;
	    
	    @FXML
	    AnchorPane Voter;
	    
	    String url = "jdbc:mysql://localhost:3306/vote";
	  	String user = "root";
	  	String pass = "143Mother";
	  	public void initialize() {

	  		try{
		  	 	Connection mycon= DriverManager.getConnection(url,user,pass);
		  		Statement mystat = mycon.createStatement();
		  		ResultSet myres= mystat.executeQuery("select distinct(club) from candidates where club = 'Art Club'");
		  		while(myres.next()) {
		  			String s = myres.getString("club");
		  			clublist.getItems().addAll(s);
		  			clublist.setValue("Names");
					}
				}catch(Exception ex) {
			  		ex.printStackTrace();
			  	}
	  		
	  		try{
		  	 	Connection mycon= DriverManager.getConnection(url,user,pass);
		  		Statement mystat = mycon.createStatement();
		  		ResultSet myres= mystat.executeQuery("select full_name from candidates where position = 'President' and club = 'Art Club' and gpa>=3.0");
		  		while(myres.next()) {
		  			String s = myres.getString("full_name");
		  			presidentlist.getItems().addAll(s);
		  			presidentlist.setValue("Names");
					}
				}catch(Exception ex) {
			  		ex.printStackTrace();
			  	}
			
			try{
		  	 	Connection mycon= DriverManager.getConnection(url,user,pass);
		  		Statement mystat = mycon.createStatement();
		  		ResultSet myres= mystat.executeQuery("select full_name from candidates where position = 'Secretary' and club = 'Art Club' and gpa>=3.0");
		  		while(myres.next()) {
		  			String s = myres.getString("full_name");
		  			secretarylist.getItems().addAll(s);
		  			secretarylist.setValue("Names");
					}
				}catch(Exception ex) {
			  		ex.printStackTrace();
			  	}
			
			try{
		  	 	Connection mycon= DriverManager.getConnection(url,user,pass);
		  		Statement mystat = mycon.createStatement();
		  		ResultSet myres= mystat.executeQuery("select full_name from candidates where position = 'Vice President' and club = 'Art Club' and gpa>=3.0");
		  		while(myres.next()) {
		  			String s = myres.getString("full_name");
		  			vplist.getItems().addAll(s);
		  			vplist.setValue("Names");
					}
				}catch(Exception ex) {
			  		ex.printStackTrace();
			  	}
	  	
	 }
		public void clubname(ActionEvent event) {
	  		club.setText(clublist.getValue());
	  	 }
	 
	  	public void presidentname(ActionEvent event) {
		 President.setText(presidentlist.getValue());
	 }
	 
	  	public void vpname(ActionEvent event) {
		 vpresident.setText(vplist.getValue());
	 }
	 
	  	public void secratoryname(ActionEvent event) {
		 secretary.setText(secretarylist.getValue());
	 }
	 
	  	public void voterButton(ActionEvent event) {
	  		 
	  		String voter_num = voterid.getText();
	    	String full_name = voterlname.getText();
	    	String club_name=  club.getText();
	    	String president = President.getText();
	    	String vice_president = vpresident.getText();
	    	String secretary_name= secretary.getText();
	    	
	    	try { 
				Connection mycon = DriverManager.getConnection(url,user,pass);
				Statement mystat = mycon.createStatement();
				mystat.executeUpdate("insert into artvoter (voter_num,full_name,club,president,vice_president,secretary) values('"
				+voter_num+"','"+full_name+"','"+club_name+"','"+president+"','"+vice_president+"','"+secretary_name+"')");
				JOptionPane.showMessageDialog(null, "Successfully Voted");	
		}
		
		catch(Exception ex) {
			ex.printStackTrace();
		}
	    	
	    	
	    	
	 } 

	  	private void setNode(Node node) {
	  		ArtVoterform.getChildren().add((Node) node);
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
				Voter = FXMLLoader.load(getClass().getResource("/application/Home2.fxml"));
				setNode(Voter);
			}catch(IOException e) {
				e.printStackTrace();
			}
	  		
	  	}
	  	
}
