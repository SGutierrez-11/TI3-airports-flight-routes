package ui;
import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import model.Agency;
public class MainGUI {
	
	private Agency agency;
	
	public MainGUI(Agency agency) {
		
		this.agency = agency;
	}
	
    @FXML
    private Pane mainPane;
    @FXML
    private TextField txtOrigin;
    @FXML
    private TextField txtDestination;
    @FXML
    private TextArea txtResult;
    @FXML
    void backMain(ActionEvent event) {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-menu.fxml"));
    	fxmlLoader.setController(this);
		Parent userView;
		try {
			userView = fxmlLoader.load();
			mainPane.getChildren().clear();
			mainPane.getChildren().add(userView);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    @FXML
    void calculateFlight(ActionEvent event) {
    		

		FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Open Resource File");
    	File file = fileChooser.showOpenDialog(null);
    	if(file != null) {
    		try {
				 agency.importData(file.getAbsolutePath());
				 Alert alert = new Alert(AlertType.INFORMATION);
				    alert.setTitle("Flight-Routes");
				    alert.setHeaderText("Annoucement");
				    alert.setContentText("The Flights have been succesfully imported");
				    //initializeAllPlayersTableview();
				    alert.showAndWait();
				    String origin = txtOrigin.getText();
				    String destity = txtDestination.getText();
				    
				    
				    
				    //playerTable.refresh();
			} catch (IOException e) {
				 Alert alert = new Alert(AlertType.INFORMATION);
				    alert.setTitle("FIBA");
				    alert.setHeaderText("Error");
				    alert.setContentText("The Players were not succesfully imported ");
				
				    alert.showAndWait();
			}
	  
	 
    }
    	
    }

    @FXML
    void calculateRoundTrip(ActionEvent event) {
    	
    	

		FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Open Resource File");
    	File file = fileChooser.showOpenDialog(null);
    	if(file != null) {
    		try {
				 agency.importData(file.getAbsolutePath());
				 Alert alert = new Alert(AlertType.INFORMATION);
				    alert.setTitle("FIBA");
				    alert.setHeaderText("Annoucement");
				    alert.setContentText("The Players Have been succesfully imported");
				    //initializeAllPlayersTableview();
				    alert.showAndWait();
				 
				    //playerTable.refresh();
			} catch (IOException e) {
				 Alert alert = new Alert(AlertType.INFORMATION);
				    alert.setTitle("FIBA");
				    alert.setHeaderText("Error");
				    alert.setContentText("The Players were not succesfully imported ");
				
				    alert.showAndWait();
			}
	  
	 
    }
    }
}