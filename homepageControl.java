package application;

import java.io.IOException;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class homepageControl {
	    @FXML
	    AnchorPane home;
	    
	    AnchorPane Candidate;
	    
	    AnchorPane Voter;
	    
	    AnchorPane result;
	    
	private void setNode(Node node) {
	    	home.getChildren().add((Node) node);
	    	FadeTransition ft = new FadeTransition(Duration.millis(1500));
	    	ft.setNode(node);
	    	ft.setFromValue(0.1);
	    	ft.setToValue(1);
	    	ft.setCycleCount(1);
	    	ft.setAutoReverse(false);
	    	ft.play();
	    	
	    }
	public void exitbutton(ActionEvent event) {
		Platform.exit();
	}
	public void createpage() throws IOException {
		try {
		Candidate  = FXMLLoader.load(getClass().getResource("/application/Home.fxml"));
		setNode(Candidate);
	}catch(IOException e) {
		e.printStackTrace();
	}
	}
     
	public void createvoterpage() throws IOException {
			try {
			Voter = FXMLLoader.load(getClass().getResource("/application/Home2.fxml"));
			setNode(Voter);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	public void createresultpage() throws IOException {
		try {
		result  = FXMLLoader.load(getClass().getResource("/application/Results.fxml"));
		setNode(result);
	}catch(IOException e) {
		e.printStackTrace();
	}
	}
	
	public void signout(ActionEvent event) {
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
}