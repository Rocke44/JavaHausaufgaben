/*
 * Namen: Andre Spinnler / Jakob Rockenbauch
 * Namen: Andr� Spinnler / Jakob Rockenbauch
 * Aufgabe: Blatt 3
 * Datum: 28.10.2016
 * Status: Fertig
*/

public class Date {
public static final int [] lengthOfMonths = {31 ,28 ,31 ,30 ,31 ,30 ,31 ,31 ,30 ,31 ,30 ,31};
public final String [] weekdays = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
private int day , month , year ;
public static int getLengthOfMonth (int month , int year )
{
	if(month < 1 || month > 12){ throw new InvalidDateException();}
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
	if(month < 1 || month > 12 || day < 1 || (Date.isLeapYear(year) && month == 2 && day > 29) || ((!Date.isLeapYear(year) && day > Date.lengthOfMonths[month-1])) ) { throw new InvalidDateException();}
	if(year < 1800 || year > 2100) {throw new DateOutOfRangeException();}

	this.day = day;
	this.month = month;
	this.year = year;
}
public Date (int day , int year ) {
	if(day < 1 || day > 366 || ( !isLeapYear(year) && day == 366) ){ throw new InvalidDateException();}
	if(year < 1800 || year > 2100) {throw new DateOutOfRangeException();}

	for(int i = 0; i < 12 ; i++){
		if(day <= Date.lengthOfMonths[i]){
			this.day = day;
			this.month = i+1;
			this.year = year;
			break;
		}
		if(i == 1 && isLeapYear(year)){
			if(day == Date.lengthOfMonths[i]+1){
				this.day = day;
				this.month = i+1;
				this.year = year;
				break;
			}
			day--;
		}
		day -= Date.lengthOfMonths[i];
	}
}


public int getDay(){return this.day;}
public int getMonth(){return this.month;}
public int getYear(){return this.year;}

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
	int cDD = (8 - ((this.year / 100) % 4) * 2) % 7;        //centuryDD
	int jDD = (this.year % 100 + ((this.year % 100) / 4) + cDD) % 7; //JahresDD

	int abstand = 0;
	if (this.month <= 4) {
		abstand += this.lengthOfMonths[this.month - 1] - this.day;
		for (int i = this.month + 1; i < 4; i++) {
			abstand += this.lengthOfMonths[i - 1];
			if ((i == 2) && isLeapYear(this.year)) {
				abstand += 1;
			}
		}
		abstand += 4;
		abstand %= 7;
		return this.weekdays[((7 - abstand) + jDD) % 7];
	} else {
		abstand += this.lengthOfMonths[3]-4;
		for (int i = 5; i < this.month; i++) {
			abstand += this.lengthOfMonths[i - 1];
		}
		abstand += this.day;
		abstand %= 7;
		return this.weekdays[(abstand + jDD) % 7];
	}
// gibt den Wochentag des Datums ( Mo - So ) zurueck
// Berechnungsmethode : Doomsday Methode
}
@Override
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
