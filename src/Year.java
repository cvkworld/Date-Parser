/**
 * 
 * @author chandraveer kunwar
 *
 */
public class Year implements Comparable<Year> {
	
	public int year;

	/**
	 * The usual Months of the Year ordered in ascending order (Jan -> Dec)
	 */
	public Month[] months;

	public Year(int year) {
		this.year = year;

		// Instantiate and fill the months array
		months = new Month[12];
		for (int i = 1; i <= 12; i++)
			months[i - 1] = new Month(i);
	}

	/**
	 * Registers a date given a month and day.
	 * 
	 * @param month
	 * The month of the Date
	 * @param day
	 * The day of the Date
	 */
	public void addDay(int month, int day) {
		months[month - 1].addDay(day);
	}

	public String toString() {
		String str = "- " + year + " \n";
		for (Month m : months)
			if (m.datesCount() > 0)
				str += m.toString();
		return str;
	}

	@Override
	/**
	 * Used to sort the Year list in the Dates class.
	 * 
	 */
	public int compareTo(Year y) {
		return year - y.year;
	}

}
