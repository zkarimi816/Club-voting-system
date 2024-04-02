package application;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class home2Control {
	    @FXML
	    private AnchorPane Voter;

	    @FXML
	    private Button debate;

	    @FXML
	    private Button csc;

	    @FXML
	    private Button speech;

	    @FXML
	    private Button art;

	    @FXML
	    private Button music;

	    @FXML
	    private Button book;
	    @FXML
	    AnchorPane home;
	    
	    AnchorPane voterform;
	    
	    AnchorPane CSCVoterform;
	    
	    AnchorPane SpeechVoterForm;
	    
	    AnchorPane ArtVoterform;
	    
	    AnchorPane MusicVoter;
	    
	    AnchorPane Bookvoterform;
	    
	    private void setNode(Node node) {
	    	Voter.getChildren().add((Node) node);
	    	FadeTransition ft = new FadeTransition(Duration.millis(1500));
	    	ft.setNode(node);
	    	ft.setFromValue(0.1);
	    	ft.setToValue(1);
	    	ft.setCycleCount(1);
	    	ft.setAutoReverse(false);
	    	ft.play();
	    	
	    }

	    @FXML
	    public void DebateButton(ActionEvent event) {
		 try {
				voterform  = FXMLLoader.load(getClass().getResource("/application/Voter.fxml"));
				setNode(voterform);
			}catch(IOException e) {
				e.printStackTrace();
			}
			 
	    }
	    
	  //Computer Science Button
	    @FXML
	    public void CSCButton(ActionEvent event) {
		 try {
			 CSCVoterform  = FXMLLoader.load(getClass().getResource("/application/CSCVoter.fxml"));
				setNode(CSCVoterform);
			}catch(IOException e) {
				e.printStackTrace();
			}
			 
	    }
	    
	    //Speech Club Button
	    @FXML
	    public void SpeechButton(ActionEvent event) {
		 try {
			 SpeechVoterForm  = FXMLLoader.load(getClass().getResource("/application/SpeechVoter.fxml"));
				setNode(SpeechVoterForm);
			}catch(IOException e) {
				e.printStackTrace();
			}
			 
	    }
	    
	    //Art Club Button
	    @FXML
	    public void ArtButton(ActionEvent event) {
		 try {
			 ArtVoterform  = FXMLLoader.load(getClass().getResource("/application/ArtVoter.fxml"));
				setNode(ArtVoterform);
			}catch(IOException e) {
				e.printStackTrace();
			}
			 
	    }
	    
	    //Music Club Button
	    @FXML
	    public void MusicButton(ActionEvent event) {
		 try {
			 MusicVoter  = FXMLLoader.load(getClass().getResource("/application/MusicVoter.fxml"));
				setNode(MusicVoter);
			}catch(IOException e) {
				e.printStackTrace();
			}
			 
	    }
	    
	     //Book Club Button
	    @FXML
	    public void BookButton(ActionEvent event) {
		 try {
			 Bookvoterform  = FXMLLoader.load(getClass().getResource("/application/BookVoter.fxml"));
				setNode(Bookvoterform);
			}catch(IOException e) {
				e.printStackTrace();
			}
			 
	    }
}
