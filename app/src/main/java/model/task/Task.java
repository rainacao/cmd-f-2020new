package model.task;

import com.example.cmdf2020new.NotificationActivity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import model.time.Time;

public class Task extends TimerTask {
    private String name;
    private String description;
    private boolean status;
    private Time time;

    public Task(String name, boolean status, String description, Time time)  {
        this.name=name;
        this.status=status;
        this.description=description;
        this.time=time;
    }

    public String getName() {
        return name;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public Time getTime() {
        return time;
    }

    public void changeStatus() {
        status = !status;
    }

    public void changeName(String s) {
        name = s;
    }

    public void changeDescription(String s) {
        description = s;
    }

    public void changeTime(Time t) {
        time = t;
    }


    public void makeReminder() throws ParseException {

        String year = time.getYear();
        String month = time.getNumericalMonth();
        String day = time.getDay();
        String hour = time.getHour();
        String min = time.getMinute();
        String taskTime = year +"-"+month+"-"+day+" "+hour
                +":"+min;
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = dateFormatter.parse(taskTime);

        Timer timer = new Timer();

        timer.schedule(this, date);

    }

    @Override
    public void run() {
        NotificationActivity notification = new NotificationActivity();
        notification.buildNotification(name, description);
    }
}

