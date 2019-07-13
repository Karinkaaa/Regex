package main.java.date_time.interfaces;

import main.java.date_time.entities.Day;
import main.java.date_time.entities.Month;
import main.java.date_time.exceptions.InvalidDayInYearException;
import main.java.date_time.exceptions.InvalidFiscalDateFormatException;

import java.util.List;

public interface ICalendarProvider {

    List<Month> getMonths(int fiscalDateFrom, int fiscalDateTo) throws InvalidFiscalDateFormatException;

    Day getDayInfo(int year, int dayInYear) throws InvalidDayInYearException;

    List<String> getMonthsFormatted(int fiscalDateFrom, int fiscalDateTo) throws InvalidFiscalDateFormatException;
}
