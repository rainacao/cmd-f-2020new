package model.task;

import model.time.Time;

public class Task {
    private String name;
    private String description;
    private boolean status;
    private Time endTime;

    public Task(String name, boolean status, String description) {
        this.name=name;
        this.status=status;
        this.description=description;
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

    public void changeStatus() {
        status = !status;
    }

    public void changeName(String s) {
        name = s;
    }

    public void changeDescription(String s) {
        description = s;
    }
}

