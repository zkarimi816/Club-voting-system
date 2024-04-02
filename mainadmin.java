package application;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class mainadmin {
	 @FXML
	    AnchorPane mainadmin;
	    
	    AnchorPane user;
	    
	    AnchorPane candidatess;
	    
	    AnchorPane voter1;
	    AnchorPane voter2;
	    AnchorPane voter3;
	    AnchorPane voter4;
	    AnchorPane voter5;
	    AnchorPane voter6;
	    
	    private void setNode(Node node) {
	    	mainadmin.getChildren().add((Node) node);
	    	FadeTransition ft = new FadeTransition(Duration.millis(1500));
	    	ft.setNode(node);
	    	ft.setFromValue(0.1);
	    	ft.setToValue(1);
	    	ft.setCycleCount(1);
	    	ft.setAutoReverse(false);
	    	ft.play();
	    	
	    }
	    public void createpage() throws IOException {
			try {
			user  = FXMLLoader.load(getClass().getResource("/application/users.fxml"));
			setNode(user);
		}catch(IOException e) {
			e.printStackTrace();
		}
		}

	    
	    public void createpagecandidate() throws IOException {
			try {
				candidatess = FXMLLoader.load(getClass().getResource("/application/adminvoter.fxml"));
			setNode(candidatess);
		}catch(IOException e) {
			e.printStackTrace();
		}
		}
	    public void createpagevoter1() throws IOException {
			try {
				voter1 = FXMLLoader.load(getClass().getResource("/application/voter1.fxml"));
			setNode(voter1);
		}catch(IOException e) {
			e.printStackTrace();
		}
		}
	    
	    
	    public void createpagevoter2() throws IOException {
			try {
				voter2 = FXMLLoader.load(getClass().getResource("/application/voter2.fxml"));
			setNode(voter2);
		}catch(IOException e) {
			e.printStackTrace();
		}
		}
	    public void createpagevoter3() throws IOException {
	 			try {
	 				voter3 = FXMLLoader.load(getClass().getResource("/application/voter3.fxml"));
	 			setNode(voter3);
	 		}catch(IOException e) {
	 			e.printStackTrace();
	 		}
	 		}
	 	    public void createpagevoter4() throws IOException {
	 			try {
	 				voter4 = FXMLLoader.load(getClass().getResource("/application/voter4.fxml"));
	 			setNode(voter4);
	 		}catch(IOException e) {
	 			e.printStackTrace();
	 		}
	 		}
	 	    
	 	    
	 	    public void createpagevoter5() throws IOException {
	 			try {
	 				voter5 = FXMLLoader.load(getClass().getResource("/application/voter5.fxml"));
	 			setNode(voter5);
	 		}catch(IOException e) {
	 			e.printStackTrace();
	 		}
	 		}
	 	   public void createpagevoter6() throws IOException {
	 			try {
	 				voter6 = FXMLLoader.load(getClass().getResource("/application/voter6.fxml"));
	 			setNode(voter6);
	 		}catch(IOException e) {
	 			e.printStackTrace();
	 		}
	 		}
	 	  public void logout(ActionEvent event) {
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
