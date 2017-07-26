package application;

import java.net.URL;
import java.util.ResourceBundle;

import domain.AnalyticsModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * @author Alec Waddelow
 *
 * Controller for Analytics Screen
 */
public class AnalyticsController implements Initializable
{
	@FXML private TextField maxWeightField;
	@FXML private TextField minWeightField;
	@FXML private TextField averageWeightField;
	@FXML private TextField averageLengthOfTripField;
	@FXML private TextField shortestTripField;
	@FXML private TextField longestTripField;
	@FXML private TextField averageCardioLengthField;
	@FXML private TextField longestSaunaField;
	
	private AnalyticsModel model = new AnalyticsModel();
	private String maxWeight = String.valueOf(model.findMaxWeight());
	private String minWeight = String.valueOf(model.findMinWeight());
	private String averageWeight = String.valueOf(model.findAverageWeight());
	private String averageLengthOfTrip = String.valueOf(model.findAverageLengthOfTrip());
	private String shortestTrip = String.valueOf(model.findMinLengthOfTrip());
	private String longestTrip = String.valueOf(model.findMaxLengthOfTrip());
	private String averageCardioLength = String.valueOf(model.findAverageLengthOfCardio());
	private String longestSauna = String.valueOf(model.findMaxLengthInSauna());
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		maxWeightField.setText(maxWeight);
		minWeightField.setText(minWeight);
		averageWeightField.setText(averageWeight);
		averageLengthOfTripField.setText(averageLengthOfTrip);
		shortestTripField.setText(shortestTrip);
		longestTripField.setText(longestTrip);
		averageCardioLengthField.setText(averageCardioLength);
		longestSaunaField.setText(longestSauna);
	}
}
