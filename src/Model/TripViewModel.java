package Model;

import java.util.Date;

/**
 * 
 * @author Marty Sease and Alec Waddelow
 * 
 * A model for holding data that will be displayed in the User Interface
 *
 */
public class TripViewModel 
{
	protected Date date; 
	protected double lengthOfTrip; 
	protected double lengthOfCardio; 
	protected double lengthOfLifting; 
	protected double lengthOfSauna; 
	protected int weight; 
	protected String comment; 

	/**
	 * Standard constructor
	 * 
	 * @param date
	 * @param lengthOfTrip
	 * @param lengthOfCardio
	 * @param lengthOfLifting
	 * @param lengthOfSauna
	 * @param weight
	 * @param comment
	 */
	public TripViewModel(Date date, double lengthOfTrip, double lengthOfCardio, double lengthOfLifting, double lengthOfSauna, 
			int weight, String comment)
	{
		this.date = date; 
		this.lengthOfTrip = lengthOfTrip; 
		this.lengthOfCardio = lengthOfCardio; 
		this.lengthOfLifting = lengthOfLifting; 
		this.lengthOfSauna = lengthOfSauna; 
		this.weight = weight; 
		this.comment = comment; 
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the lengthOfTrip
	 */
	public double getLengthOfTrip() {
		return lengthOfTrip;
	}

	/**
	 * @param lengthOfTrip the lengthOfTrip to set
	 */
	public void setLengthOfTrip(double lengthOfTrip) {
		this.lengthOfTrip = lengthOfTrip;
	}

	/**
	 * @return the lengthOfCardio
	 */
	public double getLengthOfCardio() {
		return lengthOfCardio;
	}

	/**
	 * @param lengthOfCardio the lengthOfCardio to set
	 */
	public void setLengthOfCardio(double lengthOfCardio) {
		this.lengthOfCardio = lengthOfCardio;
	}

	/**
	 * @return the lengthOfLifting
	 */
	public double getLengthOfLifting() {
		return lengthOfLifting;
	}

	/**
	 * @param lengthOfLifting the lengthOfLifting to set
	 */
	public void setLengthOfLifting(double lengthOfLifting) {
		this.lengthOfLifting = lengthOfLifting;
	}

	/**
	 * @return the lengthOfSauna
	 */
	public double getLengthOfSauna() {
		return lengthOfSauna;
	}

	/**
	 * @param lengthOfSauna the lengthOfSauna to set
	 */
	public void setLengthOfSauna(double lengthOfSauna) {
		this.lengthOfSauna = lengthOfSauna;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
}
