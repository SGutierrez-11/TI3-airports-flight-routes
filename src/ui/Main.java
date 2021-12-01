package ui;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Agency;


/*public class Main {
	private static WeightedGraph<Integer> graph;

	public static void main(String[] args) {

		graph = new WeightedGraph<>(3);
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);


		graph.addEdge(1, 2, 4, false);
		graph.addEdge(1, 3, 2, false);
		graph.addEdge(2, 1, 5, false);
		graph.addEdge(2, 3, 3, false);
		graph.addEdge(3, 1, 6, false);
		graph.addEdge(3, 2, 7, false);

		
		int[][] matrix=graph.minimunDistancesList();
		
		for(int i=0; i<3;i++) {
			for(int j=0;j<3;j++) {

				System.out.print("["+matrix[i][j]+"]");
			}
			System.out.println();
		}
		
		
		
	}
}*/


public class Main extends Application{
	private MainGUI gui;
	private Agency agency;
	public Main() {
		agency = new Agency();
		gui = new MainGUI(agency);
	}
	public static void main(String[]args) {
			launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-pane.fxml"));
		fxmlLoader.setController(gui);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Minesweeper");
		primaryStage.show();
		gui.backMain(new ActionEvent());
		Platform.setImplicitExit(true);
        primaryStage.setOnCloseRequest((ae) -> {
            Platform.exit();
            System.exit(0);
        });
	}
}