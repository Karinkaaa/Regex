package main.java.date_time.application;

import main.java.date_time.exceptions.InvalidFiscalDateFormatException;
import main.java.web.components.CalendarProviderComponent;

import java.util.List;

public class DateTimeApp {
    public static void main(String[] args) throws InvalidFiscalDateFormatException {

        CalendarProviderComponent cpc = new CalendarProviderComponent();

        List<String> list = cpc.getMonthsFormatted(201901, 201903);

        for (String str : list)
            System.out.println(str);

    }
}
