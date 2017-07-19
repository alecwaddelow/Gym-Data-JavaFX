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
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller for logging in 
 * 
 * @author Alec Waddelow
 *
 */
public class LoginController 
{
	private LoginManager manager;
	private GymBL logic;

	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private Button submitCredentials;
	@FXML
	private TextField resultText;

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
				try {
					FXMLLoader loader = new FXMLLoader();
					loader.setLocation(getClass().getResource("DatabaseEntries.fxml"));
					
					Scene scene = new Scene(loader.load(), 1000, 600);
					Stage stage = new Stage();
					stage.setTitle("Entries in Database");
					stage.setScene(scene);
					stage.show();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				//				ArrayList<TripViewModel> viewModels = new ArrayList<TripViewModel>();
				//				this.getEntries();
			}
		}catch(Exception e){
			resultText.setText("Failed Login");

		}
	}

}
