/*
 * Name: André Spinnler
 * Aufgabe: Blatt 3
 * Datum: 26.10.2016
 * Status: In Bearbeitung mit Git
*/

public class Date {
public static final int [] lengthOfMonths = {31 ,28 ,31 ,30 ,31 ,30 ,31 ,31 ,30 ,31 ,30 ,31};
public static final String [] weekdays = {" Mon "," Tue "," Wed "," Thu "," Fri "," Sat "," Sun "};
private int day , month , year ;
public Date (int day , int month , int year ) {
	// wirft eine Exception ( siehe Text unten )
	}
public Date (int day , int year ) {
	// Tag geht von 1 bis 366
	// wirft eine Exception ( siehe Text unten )
	}
public static int getLengthOfMonth (int month , int year ) {//Fertig
	if (month == 2)
	{
		if(isLeapYear(year))
		{
			return 29;
		}
		return 28;
	}
	return lengthOfMonths[month];
}

public static boolean isLeapYear (int year ) {//Fertig
	if(year%400==0)
	{
		return true;
	}
	if(year%100==0)
	{
		return false;
	}
	if(year%4==0)
	{
		return true;
	}
	return false;
}

public Date tomorrow () {
	int tag = this.day;
	int monat = this.month;
	int jahr = this.year;
	tag++;
	if(tag > lengthOfMonths[monat])
	{
		monat++;
		tag = 1;
		if(monat>12)
		{
			monat = 1;
			jahr++;
		}
	}
	Date Neu = new Date(tag, monat, jahr);
	return Neu;
}
public Date yesterday () {
	int tag = this.day-1;
	int monat = this.month;
	int jahr = this.year;
	if(tag == 0)
	{
		monat--;
		if(monat == 0)
		{
			year--;
			month = 12;
		}
		tag = Date.lengthOfMonths[monat];
	}
	return new Date(tag, monat, jahr);
}
public String getWeekday () {
// gibt den Wochentag des Datums ( Mo - So ) zurueck
// Berechnungsmethode : siehe Text unten
3
}
public String toString () {
// gibt eine passende String - Darstellung des Datums zurueck
}
public boolean equals ( Date d ) {
// ueberprueft , ob this und d das gleiche Datum haben .
}
public boolean isSameDay ( Date d ) {
// ueberprueft , ob Tag und Monat gleich sind
// ( ohne Beruecksichtigung des Jahres )
}
}