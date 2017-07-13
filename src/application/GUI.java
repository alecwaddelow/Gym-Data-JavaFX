package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GUI extends Application {

	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		launch(args);
	}

	
	Button button;
	@Override
	public void start(Stage stage) throws IOException {
		 	Parent root = FXMLLoader.load(getClass().getResource("gui.fxml"));
	        Scene scene = new Scene(root, 500, 500);
	        
	        stage.setTitle("FXML Welcome");
	        stage.setScene(scene);
	        stage.show();
	}
}
