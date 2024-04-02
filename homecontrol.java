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

public class homecontrol {
    @FXML
    private AnchorPane Candidate;
    
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
    
    AnchorPane Candidateform;
    
    AnchorPane CSCCandidateform;
    
    AnchorPane SpeechCandidateform;
    
    AnchorPane  artcandidateform;
    
    AnchorPane  Musiccandidateform;
    
    AnchorPane BookCandidateform;
    
    //Changing scenes between candidate form and Candidate page
    private void setNode(Node node) {
    	Candidate.getChildren().add((Node) node);
    	FadeTransition ft = new FadeTransition(Duration.millis(1500));
    	ft.setNode(node);
    	ft.setFromValue(0.1);
    	ft.setToValue(1);
    	ft.setCycleCount(1);
    	ft.setAutoReverse(false);
    	ft.play();
    	
    }

    //Debate Club Button
    @FXML
    public void debatebutton(ActionEvent event) {
	 try {
			Candidateform  = FXMLLoader.load(getClass().getResource("/application/candidate.fxml"));
			setNode(Candidateform);
		}catch(IOException e) {
			e.printStackTrace();
		}
		 
    }
    
    //Computer Science Button
    @FXML
    public void cscbutton(ActionEvent event) {
	 try {
		 CSCCandidateform  = FXMLLoader.load(getClass().getResource("/application/CSCCandidate.fxml"));
			setNode(CSCCandidateform);
		}catch(IOException e) {
			e.printStackTrace();
		}
		 
    }
    
    //Speech Club Button
    @FXML
    public void speechbutton(ActionEvent event) {
	 try {
		 SpeechCandidateform  = FXMLLoader.load(getClass().getResource("/application/SpeechCandidate.fxml"));
			setNode(SpeechCandidateform);
		}catch(IOException e) {
			e.printStackTrace();
		}
		 
    }
    
    //Art Club Button
    @FXML
    public void artbutton(ActionEvent event) {
	 try {
		 artcandidateform  = FXMLLoader.load(getClass().getResource("/application/ArtCandidate.fxml"));
			setNode(artcandidateform);
		}catch(IOException e) {
			e.printStackTrace();
		}
		 
    }
    
    //Music Club Button
    @FXML
    public void musicbutton(ActionEvent event) {
	 try {
		 Musiccandidateform  = FXMLLoader.load(getClass().getResource("/application/MusicCandidate.fxml"));
			setNode( Musiccandidateform);
		}catch(IOException e) {
			e.printStackTrace();
		}
		 
    }
    
     //Book Club Button
    @FXML
    public void bookbutton(ActionEvent event) {
	 try {
		 BookCandidateform  = FXMLLoader.load(getClass().getResource("/application/BookCandidate.fxml"));
			setNode(BookCandidateform);
		}catch(IOException e) {
			e.printStackTrace();
		}
		 
    }
}
