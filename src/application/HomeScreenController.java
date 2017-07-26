package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * 
 * @author Alec Waddelow
 * 
 * Controller for the main home screen menu to redirect to different screens
 * 
 */
public class HomeScreenController 
{
	@FXML private Button openEntriesScreenButton;
	@FXML private Button openAnalyticsScreenButton;
	@FXML private Button closeProgramButton;
	
	/**
	 * Opens the database entries screen
	 * 
	 * @param event
	 */
	@FXML
	public void openDatabaseScreen(ActionEvent event)
	{
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("DatabaseEntries.fxml"));
			
			Scene scene = new Scene(loader.load(), 1280, 600);
			Stage stage = new Stage();
			stage.setTitle("Database Entries");
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param event
	 */
	@FXML
	public void openAnalyticsScreen(ActionEvent event)
	{
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("AnalyticsScreen.fxml"));
			
			Scene scene = new Scene(loader.load(), 800, 800);
			Stage stage = new Stage();
			stage.setTitle("Analytics");
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Kills the entire program on button press
	 * 
	 * @param event
	 */
	@FXML 
	public void closeProgram(ActionEvent event)
	{
		System.exit(1);
	}
	
}
