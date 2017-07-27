package application;

import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import domain.TripDTO;
import domain.TripManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;

/**
 * 
 * @author Alec Waddelow
 *
 * Controller for the Weight History Chart
 */
public class WeightChartController implements Initializable
{
	@FXML LineChart<String, Integer> weightChart;
	@FXML NumberAxis yAxis = new NumberAxis();
	private TripManager manager = new TripManager();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		try {
			yAxis.setAutoRanging(false);
		    yAxis.setLowerBound(250);
		    yAxis.setUpperBound(300);
		    yAxis.setTickUnit(1);
			ArrayList<TripDTO> entriesList = manager.getAllEntries();
			Collections.sort(entriesList);
			
			ObservableList<XYChart.Series<String, Integer>> series = FXCollections.observableArrayList();
			Series<String, Integer> aSeries = new Series<String, Integer>();
			
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			for(TripDTO dto : entriesList)
			{
				aSeries.getData().add(new XYChart.Data<String,Integer>(df.format(dto.getDate()), dto.getWeight()));
			}
			
			series.add(aSeries);
			weightChart.getData().addAll(series);
		} catch (SQLServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
