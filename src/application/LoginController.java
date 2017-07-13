package application;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import domain.LoginManager;
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
		
		if(manager.login() == true)
		{
			resultText.setText("Successful Login");
		}
		else
		{
			resultText.setText("Failed Login");
		}
	}
	
}
