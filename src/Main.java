/**
 * 
 * @author chandraveer kunwar
 *
 */
public class Main {

	//Main Method.
	
	public static void main(String[] args) {
		Parser parser = new Parser("Marvin Lee Minsky at the Mathematics Genealogy Project; 20 May 2014\r\n" + 
				"\r\n" + 
				"Marvin Lee Minsky at the AI Genealogy Project. {reprint 18 September 2011)\r\n" + 
				"\r\n" + 
				"\"Personal page for Marvin Minsky\". web.media.mit.edu. Retrieved 23 June 2016.\r\n" + 
				"\r\n" + 
				"Admin (January 27, 2016). \"Official Alcor Statement Concerning Marvin Minsky\". \r\n" + 
				"\r\n" + 
				"	Alcor Life Extension Foundation. Retrieved 2016-04-07.\r\n" + 
				"\r\n" + 
				"\"IEEE Computer Society Magazine Honors Artificial Intelligence Leaders\". \r\n" + 
				"\r\n" + 
				"	DigitalJournal.com. August 24, 2011. Retrieved September 18, 2011. \r\n" + 
				"\r\n" + 
				"	Press release source: PRWeb (Vocus).\r\n" + 
				"\r\n" + 
				"\"Dan David prize 2014 winners\". May 15, 2014. Retrieved May 20, 2014.");
				parser.parse();

		// Print the output
		System.out.println(Dates.getPrintString());
	}

}
