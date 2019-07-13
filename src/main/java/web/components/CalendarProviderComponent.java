package main.java.web.components;

import main.java.date_time.entities.Day;
import main.java.date_time.entities.Month;
import main.java.date_time.exceptions.InvalidDayInYearException;
import main.java.date_time.exceptions.InvalidFiscalDateFormatException;
import main.java.date_time.interfaces.CalendarInputValidator;
import main.java.date_time.interfaces.ICalendarProvider;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Component
public class CalendarProviderComponent implements ICalendarProvider, CalendarInputValidator {

    private Day getDay(LocalDate date) {

        Day day = new Day();
        day.setNumInWeek(date.getDayOfWeek().getValue());
        day.setNumInMonth(date.getDayOfMonth());
        day.setName(date.getDayOfWeek().name());
        return day;
    }

    private Month getMonth(LocalDate date) {

        int lengthOfMonth = date.lengthOfMonth();
        List<Day> days = new ArrayList<>(lengthOfMonth);
        Month month = new Month(date.getMonth().name(), date.getMonthValue(), date.getYear(), days);

        for (int i = 0; i < lengthOfMonth; i++) {
            days.add(getDay(date));
            date = date.plus(1, ChronoUnit.DAYS);
        }
        return month;
    }

    @Override
    public List<Month> getMonths(int fiscalDateFrom, int fiscalDateTo) throws InvalidFiscalDateFormatException {

        if (isValidatedFiscalDate(fiscalDateFrom) && isValidatedFiscalDate(fiscalDateTo)) {

            Period period = Period.between(getLocalDate(fiscalDateFrom), getLocalDate(fiscalDateTo));

            int years = Math.abs(period.getYears());
            int countOfMonths = Math.abs(period.getMonths()) + years * 12;

            List<Month> listMonths = new ArrayList<>(countOfMonths);
            LocalDate date = getLocalDate(fiscalDateFrom);

            for (int i = 0; i < countOfMonths; i++) {

                listMonths.add(getMonth(date));
                date = date.plus(1, ChronoUnit.MONTHS);
            }
            return listMonths;
        }
        throw new InvalidFiscalDateFormatException("Invalidated fiscal date format!");
    }

    @Override
    public Day getDayInfo(int year, int dayInYear) throws InvalidDayInYearException {

        LocalDate date = LocalDate.of(year, 1, 1);
        int countDaysInYear = date.lengthOfYear();

        if (dayInYear < 1 || dayInYear > countDaysInYear)
            throw new InvalidDayInYearException("Invalidated day in year!");

        date = date.plus(dayInYear - 1, ChronoUnit.DAYS);
        return getDay(date);
    }

    @Override
    public List<String> getMonthsFormatted(int fiscalDateFrom, int fiscalDateTo) throws InvalidFiscalDateFormatException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

        if (isValidatedFiscalDate(fiscalDateFrom) && isValidatedFiscalDate(fiscalDateTo)) {

            Period period = Period.between(getLocalDate(fiscalDateFrom), getLocalDate(fiscalDateTo));
            int years = Math.abs(period.getYears());
            int countOfMonths = Math.abs(period.getMonths()) + years * 12;

            List<String> list = new ArrayList<>();
            LocalDate date = getLocalDate(fiscalDateFrom);

            for (int i = 0; i <= countOfMonths; i++) {

                for (int j = 0; j < date.getDayOfMonth(); j++) {

                    list.add(date.format(formatter));
                    date = date.plus(1, ChronoUnit.DAYS);
                }
            }
            return list;
        }
        throw new InvalidFiscalDateFormatException("Invalidated fiscal date format!");
    }

    @Override
    public boolean isValidatedFiscalDate(int fiscalDate) {

        int startBound = 100000;
        int endBound = 1000000;
        int divider = 100;
        int countMonths = 12;

        if (fiscalDate >= startBound && fiscalDate < endBound) {

            int year = fiscalDate / divider;
            int month = fiscalDate % divider;

            return (year > 0 && month > 0 && month <= countMonths);
        }
        return false;
    }

    private LocalDate getLocalDate(int fiscalDate) {

        if (isValidatedFiscalDate(fiscalDate))
            return LocalDate.of(fiscalDate / 100, fiscalDate % 100, 1);

        return null;
    }
}