/**
 * The main signal interpretation class. Generates signals from lines of data.
 * 
 * @author Visnu Pandian
 * @version 1.0
 * @since 04-02-2023
 */

package project3.algorithms;

public class Signal implements Comparable<Signal> {

	// Initializing variables.
	private double dm;
	private double sigma;
	private double time;
	private int sample;
	private int downfact;

	/**
	 * Signal
	 * 
	 * Constructor for Signal class.
	 */

	public Signal() {
		dm = sigma = time = sample = downfact = 0;
	}

	/**
	 * Signal
	 * 
	 * Parses line to assign data values.
	 * 
	 * @param line String of data values.
	 * 
	 * @throws NumberFormatException
	 * 
	 * @return void
	 */

	public Signal(String line) throws NumberFormatException {

		// Splitting string into array using delimiters.
		String[] temp = line.split(" ");

		// parsing each array element to update signal values.
		dm = Double.parseDouble(temp[0]);
		sigma = Double.parseDouble(temp[1]);
		time = Double.parseDouble(temp[2]);
		sample = Integer.parseInt(temp[3]);
		downfact = Integer.parseInt(temp[4]);
		// Bad data is handled in the FileSifter class.
	}

	/**
	 * Signal
	 * 
	 * Constructor for Signal class with values.
	 */

	public Signal(double dm, double sigma, double time, int sample, int downfact) {

		// Setting all signal values.
		this.dm = dm;
		this.sigma = sigma;
		this.time = time;
		this.sample = sample;
		this.downfact = downfact;

	}

	/**
	 * getDm
	 * 
	 * Returns the dm of the signal.
	 * 
	 * @param none
	 * 
	 * @return dm Dm of the signal.
	 */

	public double getDm() {
		return dm;
	}

	/**
	 * getSigma
	 * 
	 * Returns the sigma of the signal.
	 * 
	 * @param none
	 * 
	 * @return sigma Sigma of the signal.
	 */

	public double getSigma() {
		return sigma;
	}

	/**
	 * getTime
	 * 
	 * Returns the time of the signal.
	 * 
	 * @param none
	 * 
	 * @return time Time of the signal.
	 */

	public double getTime() {
		return time;
	}

	/**
	 * getSample
	 * 
	 * Returns the sample of the signal.
	 * 
	 * @param none
	 * 
	 * @return sample Sample of the signal.
	 */

	public int getSample() {
		return sample;
	}

	/**
	 * getDownfact
	 * 
	 * Returns the downfact of the signal.
	 * 
	 * @param none
	 * 
	 * @return downfact Downfact of the signal.
	 */

	public int getDownfact() {
		return downfact;
	}

	/**
	 * toString
	 * 
	 * Custom toString method for signals.
	 * 
	 * @param none
	 * 
	 * @return void
	 */

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("\nValues for this signal are: ");
		str.append("\tDM: " + getDm());
		str.append("\tSigma: " + getSigma());
		str.append("\tTime: " + getTime());
		str.append("\tSample: " + getSample());
		str.append("\tDownfact: " + getDownfact());
		return str.toString();

	}

	/**
	 * compareTo
	 * 
	 * Compares the sigma values of two signals.
	 * 
	 * @param o Signal to be compared to.
	 * 
	 * @return compare 0 if the signals are equals, 1 if the signal calling this
	 *         method is greater and -1 if it is smaller.
	 */

	public int compareTo(Signal o) {
		int compare = 0; // default value of compare.
		if (sigma < o.getSigma()) {
			compare = 1; // updating if greater.
		} else if (sigma > o.getSigma()) {
			compare = -1; // updating if lesser.
		}
		return compare;
	}

	/**
	 * equals
	 * 
	 * Checks if the sigma values of two signals are equal.
	 * 
	 * @param o Signal to compare to.
	 * 
	 * @return sigma == o.getSigma()
	 */
	public boolean equals(Signal o) {
		if (!(o instanceof Signal))
			return false;
		else
			return sigma == o.getSigma();
	}
}
