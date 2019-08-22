/**
 * 
 * @author chandraveer kunwar
 *
 */
public class Month {
	public static String[] monthPatterns = { "January", "February", "March", "April", "May",
			  "June", "July", "August", "September", "October", "November", "December" };

	/**
	 * The month number (January = 01, ...)
	 */
	public int month;

	/**
	 * The internal array for day occurrences.
	 */
	public int[] days;

	public Month(int month) {
		this.month = month;
		days = new int[31];
	}

	/**
	 * Registers a new day occurrence by incrementing its occurrence count by 1.
	 * 
	 * @param day
	 * The n-th day of the given month
	 */
	public void addDay(int day) {
		days[day - 1]++;
	}

	/**
	 * Sums all occurrences of dates in the month. If this returns 0, then the
	 * month holds no registered date.
	 * 
	 * @return the amount of dates registered in this Month
	 */
	public int datesCount() {
		int sum = 0;
		for (int d : days)
			sum += d;
		return sum;
	}

	public String toString() {
		String str = String.format("\t- %02d\n", month);
		for (int i = 0; i < 31; i++)
			if (days[i] > 0)
				str += String.format("\t\t- %02d (%d)\n", i + 1, days[i]);
		return str;
}
}
	
	
