import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/*
 * Autor   : Michael Calvert
 * Aufgabe : x.y
 * Datum   : 10.11.2014
 * Status  : in Arbeit
 */
public class JUnitDateTest {

    /*
     * First constructor
     */
    // Tests Constructor for Exceptions
    @Test(expected = DateOutOfRangeException.class)
    public void shouldNotLetYearBeOverTwothousandonehundred() {
        Date d = new Date(15, 12, 2101);
    }

    @Test(expected = DateOutOfRangeException.class)
    public void shouldNotLetYearBeUnderEighteenhundred() {
        Date tester = new Date(15, 12, 1799);
    }

    @Test(expected = InvalidDateException.class)
    public void shouldNotLetDayBeUnderOne() {
        Date tester = new Date(0, 2, 1900);
    }

    @Test(expected = InvalidDateException.class)
    public void shouldNotLetDayBeBiggerThanMonth() {
        Date tester = new Date(29, 2, 1900);
    }

    @Test(expected = InvalidDateException.class)
    public void shouldNotLetDayBeUnderOneOnLeapYear() {
        Date tester = new Date(0, 2, 2000);
    }

    @Test(expected = InvalidDateException.class)
    public void shouldNotLetDayBeBiggerThanMonthOnLeapYear() {
        Date tester = new Date(30, 2, 2000);
    }

    @Test(expected = InvalidDateException.class)
    // nachtraeglich behandelt(ll. 66-74)
    public void shouldNotLetMonthBeUnderOne() {
        Date tester = new Date(23, 0, 2010);
    }

    @Test(expected = InvalidDateException.class)
    // nachtraeglich behandelt(ll. 66-74)
    public void shouldNotLetMonthBeBiggerThanTwelve() {
        Date tester = new Date(23, 13, 2010);
    }

    /*
     * Second constructor
     */
    @Test(expected = DateOutOfRangeException.class)
    public void shouldNotLetYearBeOverTwothousandonehundredOnSecondConstructor() {
        Date tester = new Date(133, 2101);
    }

    @Test(expected = DateOutOfRangeException.class)
    public void shouldNotLetYearBeUnderEighteenhundredOnSecondConstructor() {
        Date tester = new Date(133, 1799);
    }

    @Test(expected = InvalidDateException.class)
    public void shouldNotLetDayBeZeroOnSecondConstructor() {
        Date tester = new Date(0, 1900);
    }

    @Test(expected = InvalidDateException.class)
    public void shouldNotLetDayBeBiggerThreehundredAndsixtyfiveOnSecondConstructor() {
        Date tester = new Date(366, 1900);
    }

    @Test(expected = InvalidDateException.class)
    public void shouldNotLetDayBeUnderOneOnLeapYearOnSecondConstructor() {
        Date tester = new Date(0, 2000);
    }

    @Test(expected = InvalidDateException.class)
    public void shouldNotLetDayBeBiggerThanThreehundredAndSixtysixOnSecondConstructor() {
        Date tester = new Date(367, 2000);
    }

    @Test
    public void shouldCreateDateInJanuary() {
        Date d = new Date(17, 1986);
        assertEquals(17, d.getDay());
        assertEquals(1, d.getMonth());
        assertEquals(1986, d.getYear());
    }

    /*
     * End of constructor testing
     */
    @Test
    public void getLengthOfMonthShouldReturnLengthOfMonth() {
        try {
            for (int i = 1; i < Date.lengthOfMonths.length; i++) {
                assertEquals("month " + i + " has "
                        + Date.lengthOfMonths[i - 1] + " days ",
                             Date.lengthOfMonths[i - 1],
                             Date.getLengthOfMonth(i, 1995));
            }
        } catch (Exception e) {
            System.out.println("Index wrong");
        }
    }

    @Test(expected = InvalidDateException.class)
    public void shouldNotReturnLengthOfMonthBelowOne() {
        Date.getLengthOfMonth(0, 1986);
    }

    @Test(expected = InvalidDateException.class)
    public void shouldNotReturnLengthOfMonthOverTwelve() {
        Date.getLengthOfMonth(13, 1986);
    }

    @Test
    public void testIsLeapYear() {
        assertTrue("2000 is a leap year", Date.isLeapYear(2000));
        assertTrue("1996 is a leap year", Date.isLeapYear(1996));
        assertFalse("2100 is not a leap year", Date.isLeapYear(2100));
        assertFalse("1998 is not a leap year", Date.isLeapYear(1998));
    }

    // @Test(expected = InvalidDateException.class)
    // public void shouldThrowExceptionIfYearUnderZero() {
    // Date.isLeapYear(-1);
    // }
    @Test
    public void testTommorrowMonthEndYearEnd() {
        Date tester = new Date(30, 11, 2014);
        assertEquals("11/30/2014 --> 12/01/2014", 1, tester.tomorrow().getDay());
        assertEquals("11/30/2014 --> 12/01/2014", 12, tester.tomorrow()
                     .getMonth());
        tester = new Date(31, 12, 2014);
        assertEquals("12/31/2014 --> 01/01/2015", 2015, tester.tomorrow()
                     .getYear());
    }

    @Test
    public void testTommorrowMonthMid() {
        Date tester = new Date(15, 11, 2014);
        assertEquals(16, tester.tomorrow().getDay());
        assertEquals(11, tester.tomorrow()
                     .getMonth());
    }

    @Test
    public void testYesterday() {

        Date tester = new Date(1, 1, 2015);
        assertEquals(31, tester.yesterday().getDay());
        assertEquals(12, tester.yesterday().getMonth());
        assertEquals(2014, tester.yesterday().getYear());

        tester = new Date(2, 2, 2015);
        assertEquals(1, tester.yesterday().getDay());
        assertEquals(2, tester.yesterday().getMonth());
        assertEquals(2015, tester.yesterday().getYear());

        tester = new Date(1, 2, 2015);
        assertEquals(31, tester.yesterday().getDay());
        assertEquals(1, tester.yesterday().getMonth());
        assertEquals(2015, tester.yesterday().getYear());
    }

    @Test(expected = Exception.class)
    // Gets DateOutOfRangeException and ignores InvalidDateException
    public void yesterdayShouldThrowExceptionWhenDateIsFirstOfEighteenhundred() {
        Date tester = new Date(1, 1, 1800);
        tester.yesterday().getWeekday();
    }

    @Test(expected = Exception.class)
    // Gets DateOutOfRangeException and ignores InvalidDateException
    public void tomorrowShouldThrowExceptionWhenDateIsLastOfTwentyFirstCentury() {
        Date tester = new Date(31, 12, 2100);
        tester.tomorrow().getWeekday();
    }

    @Test
    public void getWeekdayShouldReturnNameOfDoomsDayAndNameOfGivenDay() {
        Date d = new Date(26, 9, 1979);
        assertEquals("09/26/1979 was a Wednesday", "Wed", d.getWeekday());
        d = new Date(31, 12, 2100);
        assertEquals("12/31/2100 was a Friday", "Fri", d.getWeekday());
        d = new Date(1, 1, 1800);
        assertEquals("01/01/1800 was a Wednesday", "Wed", d.getWeekday());
        d = new Date(1, 1, 2004);
        assertEquals("01/01/2004 was a Thursday", "Thu", d.getWeekday());
    }

    @Test
    public void equalsShouldReturnTrue() {
        Date d1 = new Date(19, 3, 1986);
        Date d2 = new Date(19, 3, 1986);
        assertTrue(d1.equals(d2));
    }

    @Test
    public void equalsShouldReturnFalse() {
        Date d1 = new Date(18, 3, 1986);
        Date d2 = new Date(19, 3, 1986);
        assertFalse(d1.equals(d2));
        Date d3 = new Date(19, 3, 1987);
        assertFalse(d2.equals(d3));
        Date d4 = new Date(19, 4, 1986);
        assertFalse(d2.equals(d4));
    }
}
