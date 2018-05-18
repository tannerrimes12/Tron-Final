

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class Tron extends Application
{
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		Button start = new Button("Play Game");
		Button exit = new Button("Exit Game");
		
		exit.setOnAction(e -> System.exit(0));
		
		VBox root = new VBox(100);
		root.getStyleClass().add("vbox");
		
		root.getChildren().addAll(start,exit);
		root.setAlignment(Pos.BOTTOM_CENTER);
		
		
		
		//root.setStyle("-fx-background-color:#000000;");
		Scene scene = new Scene(root,500,500);
		root.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
