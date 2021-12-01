package ui;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
public class MainGUI {
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

    }

    @FXML
    void calculateRoundTrip(ActionEvent event) {

    }
}
