package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		StackPane root = new StackPane();
		root.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		Scene scene = new Scene(root, 854,512);
		
		VBox mainVBox = new VBox();
		mainVBox.setAlignment(Pos.TOP_CENTER);

		scene.setRoot(mainVBox);
		primaryStage.setScene(scene);

		primaryStage.show();

		//This is so all the threads exits properly upon closing the program.
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
		       @Override
		       public void handle(WindowEvent e) {
		          Platform.exit();
		          System.exit(0);
		       }
		    });
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
