package model.time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Time {
    private static final DateFormat HOUR_FORMAT = new SimpleDateFormat("hh");
    private static final DateFormat MINUTE_FORMAT = new SimpleDateFormat("mm");
    private static final DateFormat TIME_CONVENTION_FORMAT = new SimpleDateFormat("aa");

    private static final Calendar CURRENT_DATE = Calendar.getInstance();

    private String hour;
    private String minute;
    private String timeConvention;

    public Time() {
        hour = HOUR_FORMAT.format(CURRENT_DATE);
        minute = MINUTE_FORMAT.format(CURRENT_DATE);
        timeConvention = TIME_CONVENTION_FORMAT.format(CURRENT_DATE);
    }

    public Time(String hour, String minute, String timeConvention) {
        this.hour = hour;
        this.minute = minute;
        this.timeConvention = timeConvention;
    }

    public int getTimeValue() {
        int hourIn24Format = 0;
        if (this.timeConvention.equals("PM")) {
            hourIn24Format = Integer.parseInt(hour) + 12;
        }
        String preTimeValue = hourIn24Format + minute;
        return Integer.parseInt(preTimeValue);
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public void setTimeConvention(String timeConvention) {
        this.timeConvention = timeConvention;
    }

    public String getHour() {
        return hour;
    }

    public String getMinute() {
        return minute;
    }

    public String getTimeConvention() {
        return timeConvention;
    }

}
