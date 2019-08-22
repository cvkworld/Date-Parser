import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * @author chandraveer kunwar
 *
 */
public class Dates
{

	/**
	 * The Year list of all dates gathered.
	 */
	private static ArrayList<Year> years = new ArrayList<>();

	private Dates() 
	{
		
	}

	/**
	 * Add a Date to the list registered by its year, month and day.
	 * 
	 * @param year
	 * The year of the Date
	 * @param month
	 * The month of the Date
	 * @param day
	 * The day of the Date
	 */
	public static void addDate(int year, int month, int day) 
	{
		// Utils.Filter returns the list of matching objects
		ArrayList<Year> y = Utils.filter(years, (obj) -> 
		{
			return ((Year) obj).year == year;
		});

		// If the filtered result is empty create the Year and add the date to it.
		if (y.isEmpty()) 
		{
			Year yy = new Year(year);
			yy.addDay(month, day);
			years.add(yy);
			return;
		}

		// Otherwise, we know for sure the first element is the Year we want.
		y.get(0).addDay(month, day);
	}

	/**
	 * Get the string representation of the Date list as a Tree.
	 * @return The expected String output
	 */
	public static String getPrintString() 
	{
		// First sort the Years for reading convenience
		Collections.sort(years);
		String str = "";
		for (Year y : years)
			str += y.toString() + "\n";
		return str;
	}

	/**
	 * Resets the Date list. Makes it empty.
	 */
	public static void reset() 
	{
		years = new ArrayList<>();
	}

}