package model.time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Date {
    private static final DateFormat YEAR_FORMAT = new SimpleDateFormat("yyyy");
    private static final DateFormat MONTH_FORMAT = new SimpleDateFormat("MMMM");
    private static final DateFormat DAY_FORMAT = new SimpleDateFormat("dd");
    private static final DateFormat NAME_OF_DAY_FORMAT = new SimpleDateFormat("EEEE");

    private Calendar calendar = Calendar.getInstance();

    private String year;
    private String month;
    private String dayOfTheWeek;
    private String day;

    public Date() {
        year = YEAR_FORMAT.format(calendar);
        month = MONTH_FORMAT.format(calendar);
        dayOfTheWeek = NAME_OF_DAY_FORMAT.format(calendar);
        day = DAY_FORMAT.format(calendar);
    }

    public Date(Calendar calendar) {
        year = YEAR_FORMAT.format(calendar);
        month = MONTH_FORMAT.format(calendar);
        dayOfTheWeek = NAME_OF_DAY_FORMAT.format(calendar);
        day = DAY_FORMAT.format(calendar);
    }

    public void toTomorrow() {
        calendar.add(Calendar.DATE, 1);
    }

    public void toYesterday() {
        calendar.add(Calendar.DATE, -1);
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setDayOfTheWeek(String dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public String getDay() {
        return day;
    }
}
