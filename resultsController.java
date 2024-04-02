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

public class resultsController {
	@FXML
    private AnchorPane result;

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
    
    AnchorPane debateresults; 
    
    AnchorPane cscresults;
    
    AnchorPane speechresults;
    
    AnchorPane artresults; 
    
    AnchorPane musicresults;
    
    AnchorPane bookresults;
    
    private void setNode(Node node) {
    	result.getChildren().add((Node) node);
    	FadeTransition ft = new FadeTransition(Duration.millis(1500));
    	ft.setNode(node);
    	ft.setFromValue(0.1);
    	ft.setToValue(1);
    	ft.setCycleCount(1);
    	ft.setAutoReverse(false);
    	ft.play();
    	
    }
   
    @FXML
    public void Debate(ActionEvent event) {
	 try {
		 debateresults  = FXMLLoader.load(getClass().getResource("/application/DebateResults.fxml"));
			setNode( debateresults);
		}catch(IOException e) {
			e.printStackTrace();
		}
	
    }
    
    @FXML
    public void CSC(ActionEvent event) {
	 try {
		 cscresults  = FXMLLoader.load(getClass().getResource("/application/cscresults.fxml"));
			setNode( cscresults);
		}catch(IOException e) {
			e.printStackTrace();
		}
	
    }

    @FXML
    public void Speech(ActionEvent event) {
	 try {
		 speechresults  = FXMLLoader.load(getClass().getResource("/application/SpeechResults.fxml"));
			setNode( speechresults);
		}catch(IOException e) {
			e.printStackTrace();
		}
	
    }
    
    @FXML
    public void Art(ActionEvent event) {
	 try {
		 artresults  = FXMLLoader.load(getClass().getResource("/application/ArtResults.fxml"));
			setNode(artresults);
		}catch(IOException e) {
			e.printStackTrace();
		}
	
    }
    
    @FXML
    public void Music(ActionEvent event) {
	 try {
		 musicresults = FXMLLoader.load(getClass().getResource("/application/MusicResults.fxml"));
			setNode(musicresults);
		}catch(IOException e) {
			e.printStackTrace();
		}
	
    }

    @FXML
    public void Book(ActionEvent event) {
	 try {
		 bookresults  = FXMLLoader.load(getClass().getResource("/application/BookResults.fxml"));
			setNode( bookresults);
		}catch(IOException e) {
			e.printStackTrace();
		}
	
    }

}
