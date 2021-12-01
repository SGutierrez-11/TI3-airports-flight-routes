package ui;
import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
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
    			 //System.out.println(" Comienza");
				 agency.importData(file.getAbsolutePath());
				 System.out.println("De aqui pasa");
				 Alert alert = new Alert(AlertType.INFORMATION);
				    alert.setTitle("Flight-Routes");
				    alert.setHeaderText("Annoucement");
				    alert.setContentText("The Flights have been succesfully imported");
				    //initializeAllPlayersTableview();
				    alert.showAndWait();
				    String origin = txtOrigin.getText();
				    String destity = txtDestination.getText();
				    String toShow = agency.findBestWay(origin, destity);
				   // System.out.println(toShow);
				    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("results.fxml"));
				    fxmlLoader.setController(this);
			    	Parent menuPane = fxmlLoader.load();
			    	mainPane.getChildren().setAll(menuPane); 
				    txtResult.setText(toShow);
 			    	
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
    void calculateRoundTrip(ActionEvent event) throws IOException {
    	
    	int toShow1 = 0;

    	int toShow2 = 0;
    	
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
				    String origin = txtOrigin.getText();
				    String destity = txtDestination.getText();
				    toShow1 = agency.findBestWayReturn(origin, destity);
				    
				    
				    
				    //playerTable.refresh();
			} catch (IOException e) {
				 Alert alert = new Alert(AlertType.INFORMATION);
				    alert.setTitle("FIBA");
				    alert.setHeaderText("Error");
				    alert.setContentText("The Players were not succesfully imported ");
				
				    alert.showAndWait();
			}
    		
	 
    }
    	FileChooser fileChooser2 = new FileChooser();
    	fileChooser2.setTitle("Open Resource File");
    	File file2 = fileChooser.showOpenDialog(null);
    	if(file2 != null) {
    		try {
				 agency.importData(file.getAbsolutePath());
				 Alert alert = new Alert(AlertType.INFORMATION);
				    alert.setTitle("FIBA");
				    alert.setHeaderText("Annoucement");
				    alert.setContentText("The Players Have been succesfully imported");
				    //initializeAllPlayersTableview();
				    alert.showAndWait();
				    String origin = txtOrigin.getText();
				    String destity = txtDestination.getText();
				    toShow2 = agency.findBestWayReturn(destity, origin);
				    
				    
				    
				    //playerTable.refresh();
			} catch (IOException e) {
				 Alert alert = new Alert(AlertType.INFORMATION);
				    alert.setTitle("FIBA");
				    alert.setHeaderText("Error");
				    alert.setContentText("The Players were not succesfully imported ");
				
				    alert.showAndWait();
			}
	  
	 
    }
    	int toShow = toShow1 + toShow2;
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("results.fxml"));
    	//FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mainPaneV2.fxml"));
		fxmlLoader.setController(this);
    	Parent menuPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(menuPane); 	
	    	String finalToShow = "El mejor precio para ir y volver desde " + txtOrigin.getText() + " a " + txtDestination.getText() + " es de: " + toShow;   
    	txtResult.setText(finalToShow);
    	
    }
}