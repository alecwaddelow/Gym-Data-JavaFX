package application;

import java.sql.SQLException;
import java.util.ArrayList;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import Model.TripViewModel;
import domain.GymBL;
import domain.LoginManager;
import domain.TripDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Controller for logging in 
 * 
 * @author Alec Waddelow
 *
 */
public class LoginController 
{
	@FXML
	private TextField username;
	
	@FXML
	private PasswordField password;
	
	@FXML
	private Button submitCredentials;
	
	private LoginManager manager;

	@FXML
	private Label resultText;
	
	private GymBL logic;
	
	/**
	 * Attempts to log in 
	 * 
	 * @return true or false
	 * @throws SQLServerException
	 */
	@FXML
	public void logIn(ActionEvent event) throws SQLServerException
	{
		String user = username.getText();
		String pass = password.getText();
		manager = new LoginManager(user, pass);
		try{
			if(manager.login() == true)
			{
				resultText.setText("Successful Login");
				ArrayList<TripViewModel> viewModels = new ArrayList<TripViewModel>();
				this.getEntries();
			}
		}catch(Exception e){
			resultText.setText("Failed Login");
		
		}
	}
	
	public ArrayList<TripViewModel> getEntries() throws SQLServerException, SQLException
	{
		return this.convertToViewModels(logic.getAllEntries());
	}
	
	public ArrayList<TripViewModel> convertToViewModels(ArrayList<TripDTO> entries){
		return null;
	}
	
}
