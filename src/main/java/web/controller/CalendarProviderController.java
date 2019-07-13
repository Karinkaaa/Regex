package main.java.web.controller;

import main.java.date_time.exceptions.InvalidDayInYearException;
import main.java.date_time.exceptions.InvalidFiscalDateFormatException;
import main.java.date_time.interfaces.ICalendarProvider;
import main.java.web.components.CalendarProviderComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("calendar")
public class CalendarProviderController {

    static Logger logger = LoggerFactory.getLogger("main.controller");

    private ICalendarProvider calendarProvider = new CalendarProviderComponent();

    @RequestMapping("get-months")
    @ResponseBody
    public String getMonths(int fiscalDateFrom, int fiscalDateTo) {

        logger.info("Get months...");

        try {
            return calendarProvider.getMonths(fiscalDateFrom, fiscalDateTo).toString();
        } catch (InvalidFiscalDateFormatException e) {
            logger.error(e.getMessage());
            return e.getMessage();
        }
    }

    @RequestMapping("get-day-info")
    @ResponseBody
    public String getDayInfo(int year, int dayInYear) {

        logger.info("Get day info...");
        try {
            return calendarProvider.getDayInfo(year, dayInYear).toString();
        } catch (InvalidDayInYearException e) {
            logger.error(e.getMessage());
            return e.getMessage();
        }
    }

    @RequestMapping("get-months-formatted")
    @ResponseBody
    public String getMonthsFormatted(int fiscalDateFrom, int fiscalDateTo) {

        logger.info("Get months formatted...");

        try {
            return calendarProvider.getMonthsFormatted(fiscalDateFrom, fiscalDateTo).toString();
        } catch (InvalidFiscalDateFormatException e) {
            logger.error(e.getMessage());
            return e.getMessage();
        }
    }
}
