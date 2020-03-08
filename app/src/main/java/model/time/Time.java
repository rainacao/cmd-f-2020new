package model.time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
    private static final DateFormat HOUR_FORMAT = new SimpleDateFormat("HH");
    private static final DateFormat MINUTE_FORMAT = new SimpleDateFormat("mm");

    private static final Date CURRENT_DATE = new Date();

    private String hour;
    private String minute;

    public Time() {
        hour = HOUR_FORMAT.format(CURRENT_DATE);
        minute = MINUTE_FORMAT.format(CURRENT_DATE);
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public String getHour() {
        return hour;
    }

    public String getMinute() {
        return minute;
    }
}
