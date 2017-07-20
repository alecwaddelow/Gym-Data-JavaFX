package application;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUI extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	
	@Override
	public void start(Stage stage) throws IOException {
		 	Parent root = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
	        Scene scene = new Scene(root, 500, 500);
	        
	        stage.setTitle("Please log in");
	        stage.setScene(scene);
	        stage.show();
	        //test
	        
	        //test2
	}
}
