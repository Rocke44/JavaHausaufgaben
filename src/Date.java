/*
 * Name: André Spinnler
 * Aufgabe: Blatt 3
 * Datum: 26.10.2016
 * Status: In Bearbeitung
*/

public class Date {
public static final int [] lengthOfMonths = {31 ,28 ,31 ,30 ,31 ,30 ,31 ,31 ,30 ,31 ,30 ,31};
public static final String [] weekdays = {" Mon "," Tue "," Wed "," Thu "," Fri "," Sat "," Sun "};
private int day , month , year ;
public static int getLengthOfMonth (int month , int year ) {
// Gibt Laenge des Monats zurueck . Beruecksichtigt Schaltjahre .
}
public static boolean isLeapYear (int year ) {
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
public Date (int day , int month , int year ) {
// wirft eine Exception ( siehe Text unten )
}
public Date (int day , int year ) {
// Tag geht von 1 bis 366
// wirft eine Exception ( siehe Text unten )
}
public Date tomorrow () {
// gibt das Datum von this + 1 Tag zurueck
}
public Date yesterday () {
// gibt das Datum von this - 1 Tag zurueck
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