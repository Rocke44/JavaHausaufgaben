/*
 * Namen: André Spinnler / Jakob Rockenbauch
 * Aufgabe: Blatt 3
 * Datum: 26.10.2016
 * Status: In Bearbeitung mit Git
*/

public class Date {
public static final int [] lengthOfMonths = {31 ,28 ,31 ,30 ,31 ,30 ,31 ,31 ,30 ,31 ,30 ,31};
public final String [] weekdays = {" Mon "," Tue "," Wed "," Thu "," Fri "," Sat "," Sun "};
private int day , month , year ;
public static int getLengthOfMonth (int month , int year )
{
	if(month ==2&&isLeapYear(year))
	{
		return 29;
	}
	return lengthOfMonths[month-1];
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
	if(month < 0 || month > 12 || day < 0 || (Date.isLeapYear(year) && month == 2 && day > 29) || (!Date.isLeapYear(year) && day > Date.lengthOfMonths[month-1]) ) { throw new InvalidDateException();}
	if(year < 1800 || year > 2100) {throw new DateOutOfRangeException();}
	
	this.day = day;
	this.month = month;
	this.year = year;
}
public Date (int day , int year ) {
	if(day < 0 || day > 366 || ( !isLeapYear(year) && day == 366) ){ throw new InvalidDateException();}
	if(year < 1800 || year > 2100) {throw new DateOutOfRangeException();}
	
	for(int i = 0; i < 12 ; i++){
		if(day <= Date.lengthOfMonths[i]){
			this.day = day;
			this.month = i+1;
			this.year = year;
		}
		if(i == 1 && isLeapYear(year)){
			if(day == Date.lengthOfMonths[i]+1){
				this.day = day;
				this.month = i+1;
				this.year = year;
			}
			day--;
		}
		day -= Date.lengthOfMonths[i];
	}
}
public Date tomorrow () {
	int tag = this.day;
	int monat = this.month;
	int jahr = this.year;
	tag++;
	if(tag>lengthOfMonths[monat-1])
	{
		tag = 1;
		monat++;
		if(monat>12)
		{
			monat = 1;
			jahr++;
		}
	}
	return new Date(tag, monat, jahr);
}
public Date yesterday () {
	int tag = this.day;
	int monat = this.month;
	int jahr = this.year;
	tag--;
	if(tag==0)
	{
		monat--;
		if(monat == 0)
		{
			monat = 12;
			jahr--;
		}
		tag = lengthOfMonths[monat-1];
	}
	return new Date(tag, monat, jahr);
}
public String getWeekday () {
// gibt den Wochentag des Datums ( Mo - So ) zurueck
// Berechnungsmethode : siehe Text unten

}
public String toString () {
	return year + "-" + month + "-" + day ;
}
public boolean equals ( Date d ) {
	return this.day == d.day && this.month == d.month && this.year == d.year;
}
public boolean isSameDay ( Date d ) {
	return (this.day == d.day) && (this.month == d.month);
}
}