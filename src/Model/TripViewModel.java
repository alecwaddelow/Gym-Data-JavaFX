package Model;

import java.util.Date;

public class TripViewModel 
{
	protected Date date; 
	protected double lengthOfTrip; 
	protected double lengthOfCardio; 
	protected double lengthOfLifting; 
	protected double lengthOfSauna; 
	protected int weight; 
	protected String comment; 

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
	protected Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	protected void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the lengthOfTrip
	 */
	protected double getLengthOfTrip() {
		return lengthOfTrip;
	}

	/**
	 * @param lengthOfTrip the lengthOfTrip to set
	 */
	protected void setLengthOfTrip(double lengthOfTrip) {
		this.lengthOfTrip = lengthOfTrip;
	}

	/**
	 * @return the lengthOfCardio
	 */
	protected double getLengthOfCardio() {
		return lengthOfCardio;
	}

	/**
	 * @param lengthOfCardio the lengthOfCardio to set
	 */
	protected void setLengthOfCardio(double lengthOfCardio) {
		this.lengthOfCardio = lengthOfCardio;
	}

	/**
	 * @return the lengthOfLifting
	 */
	protected double getLengthOfLifting() {
		return lengthOfLifting;
	}

	/**
	 * @param lengthOfLifting the lengthOfLifting to set
	 */
	protected void setLengthOfLifting(double lengthOfLifting) {
		this.lengthOfLifting = lengthOfLifting;
	}

	/**
	 * @return the lengthOfSauna
	 */
	protected double getLengthOfSauna() {
		return lengthOfSauna;
	}

	/**
	 * @param lengthOfSauna the lengthOfSauna to set
	 */
	protected void setLengthOfSauna(double lengthOfSauna) {
		this.lengthOfSauna = lengthOfSauna;
	}

	/**
	 * @return the weight
	 */
	protected int getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	protected void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * @return the comment
	 */
	protected String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	protected void setComment(String comment) {
		this.comment = comment;
	}
}
