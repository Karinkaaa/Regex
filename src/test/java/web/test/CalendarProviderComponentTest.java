package test.java.web.test;

import main.java.date_time.entities.Day;
import main.java.date_time.entities.Month;
import main.java.date_time.exceptions.InvalidDayInYearException;
import main.java.date_time.exceptions.InvalidFiscalDateFormatException;
import main.java.web.components.CalendarProviderComponent;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalendarProviderComponentTest {

    private CalendarProviderComponent calendar;

    @Before
    public void beforeEachTest() {
        calendar = new CalendarProviderComponent();
    }

    @Test
    public void getMonths() throws InvalidFiscalDateFormatException {

        List<Month> list = calendar.getMonths(201907, 201909);
        Assert.assertEquals(2, list.size());

        Map<Integer, String> daysOfWeek = new HashMap<>();
        daysOfWeek.put(1, "MONDAY");
        daysOfWeek.put(2, "TUESDAY");
        daysOfWeek.put(3, "WEDNESDAY");
        daysOfWeek.put(4, "THURSDAY");
        daysOfWeek.put(5, "FRIDAY");
        daysOfWeek.put(6, "SATURDAY");
        daysOfWeek.put(0, "SUNDAY");

        int countDaysInMonth = 31;
        int countDaysInWeek = 7;

        List<Day> days = new ArrayList<>(countDaysInMonth);
        int index;

        for (int i = 1; i <= countDaysInMonth; i++) {

            index = i % countDaysInWeek;
            days.add(new Day(index, i, daysOfWeek.get(index)));
        }

        Month month = new Month("JULY", 7, 2019, days);
        Assert.assertEquals(month, list.get(0));
    }

    @Test
    public void isValidatedFiscalDate() {

        Assert.assertTrue(calendar.isValidatedFiscalDate(201905));

        int lessOneHundredThousands = 100000;
        Assert.assertFalse(calendar.isValidatedFiscalDate(lessOneHundredThousands));

        int moreOneMillion = 1000000;
        Assert.assertFalse(calendar.isValidatedFiscalDate(moreOneMillion));
    }

    @Test
    public void getDayInfo() throws InvalidDayInYearException {

        Day day = new Day(6, 26, "SATURDAY");
        Assert.assertEquals(day, calendar.getDayInfo(2019, 26));
    }

    @Test
    public void getMonthsFormatted() throws InvalidFiscalDateFormatException {


        List<String> list = new ArrayList<>();

        for (int i = 1; i <= 31; i++) {
            list.add((i < 10 ? "0" + i : i) + "-янв-2019");
        }
        for (int i = 1; i <= 28; i++) {
            list.add((i < 10 ? "0" + i : i) + "-фев-2019");
        }

        Assert.assertEquals(list.size(), calendar.getMonthsFormatted(201901, 201902).size());
        Assert.assertEquals(list, calendar.getMonthsFormatted(201901, 201902));
    }
}