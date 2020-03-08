package model.task;

import model.time.Time;

public class Task {
    private String name;
    private String description;
    private boolean status;
    private Time time;

    public Task(String name, boolean status, String description, Time time) {
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
}

