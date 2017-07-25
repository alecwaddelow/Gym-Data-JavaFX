package application;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import Model.TripViewModel;
import domain.TripDTO;
import domain.TripManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * @author Alec Waddelow
 *
 *	A controller to initialize the table of GymTrip entries and fill it with data from the Database 
 */
public class EntriesController implements Initializable
{
	protected TripManager manager = new TripManager();
	protected ObservableList<TripViewModel> entries = FXCollections.observableArrayList();
	
	@FXML private TableView<TripViewModel> tableView = new TableView<>();
	@FXML private TableColumn<TripViewModel, Date> date = new TableColumn<TripViewModel, Date>();
	@FXML private TableColumn<TripViewModel, Double> lengthOfTrip = new TableColumn<>();
	@FXML private TableColumn<TripViewModel, Double> lengthOfCardio = new TableColumn<>();
	@FXML private TableColumn<TripViewModel, Double> lengthOfLifting = new TableColumn<>();
	@FXML private TableColumn<TripViewModel, Double> lengthOfSauna = new TableColumn<>();
	@FXML private TableColumn<TripViewModel, Integer> weight = new TableColumn<>();
	@FXML private TableColumn<TripViewModel, String> comment = new TableColumn<>();
	
	@FXML private DatePicker dateInput;
	@FXML private TextField lengthOfTripInput;
	@FXML private TextField lengthOfCardioInput;
	@FXML private TextField lengthOfLiftingInput;
	@FXML private TextField lengthOfSaunaInput;
	@FXML private TextField weightInput;
	@FXML private TextField commentInput;
	@FXML private Button submitButton;
	@FXML private Button deleteButton;
	
	/**
	 * Initialized the table
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		date.setCellValueFactory(new PropertyValueFactory<>("date"));
		lengthOfTrip.setCellValueFactory(new PropertyValueFactory<>("lengthOfTrip"));
		lengthOfCardio.setCellValueFactory(new PropertyValueFactory<>("lengthOfCardio"));
		lengthOfLifting.setCellValueFactory(new PropertyValueFactory<>("lengthOfLifting"));
		lengthOfSauna.setCellValueFactory(new PropertyValueFactory<>("lengthOfSauna"));
		weight.setCellValueFactory(new PropertyValueFactory<>("weight"));
		comment.setCellValueFactory(new PropertyValueFactory<>("comment"));
		
		try {
			tableView.setItems(returnListOfTrips());
		} catch (SQLServerException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * On submit, add a new row to table
	 * 
	 * @param event
	 * @throws NumberFormatException
	 * @throws SQLException
	 */
	public void addTrip(ActionEvent event) throws NumberFormatException, SQLException
	{
		manager.enterNewTrip(Date.valueOf(dateInput.getValue()), Double.parseDouble(lengthOfTripInput.getText()),
				Double.parseDouble(lengthOfCardioInput.getText()), Double.parseDouble(lengthOfLiftingInput.getText()),
				Double.parseDouble(lengthOfSaunaInput.getText()), Integer.parseInt(weightInput.getText()), commentInput.getText());
		
		entries.add(new TripViewModel(Date.valueOf(dateInput.getValue()), Double.parseDouble(lengthOfTripInput.getText()),
				Double.parseDouble(lengthOfCardioInput.getText()), Double.parseDouble(lengthOfLiftingInput.getText()),
				Double.parseDouble(lengthOfSaunaInput.getText()), Integer.parseInt(weightInput.getText()), commentInput.getText()));
	}
	
	/**
	 * Gets the current list of entries from the database 
	 * 
	 * @return TripViewModels in ObservableList form
	 * @throws SQLServerException
	 * @throws SQLException
	 */
	private ObservableList<TripViewModel> returnListOfTrips() throws SQLServerException, SQLException
	{
		ArrayList<TripDTO> rows = manager.getAllEntries();
		this.entries = convertToViewModel(rows);
		return this.entries;
	}
	
	/**
	 * Converts  DTO's to TripViewModels
	 * 
	 * @param ArrayList<TripDTO> dtoList
	 */
	private ObservableList<TripViewModel> convertToViewModel(ArrayList<TripDTO> dtoList)
	{
		for(TripDTO row : dtoList)
		{
			entries.add(new TripViewModel(row.getDate(), row.getLengthOfTrip(), row.getLengthOfCardio(), row.getLengthOfLifting(), row.getLengthOfSauna(), row.getWeight(), row.getComment()));
		}
		return this.entries;
	}
	
	/**
	 * Deletes a selected row from database
	 * 
	 * @param event
	 * @throws SQLException
	 */
	public void deleteTrip(ActionEvent event) throws SQLException
	{
		ObservableList<TripViewModel> tripSelected, allTrips;
		allTrips = tableView.getItems();
		tripSelected = tableView.getSelectionModel().getSelectedItems();
		allTrips.forEach(tripSelected::remove);
		Date date = (Date) tripSelected.get(0).getDate();
		manager.deleteTrip(date);
	}
}
