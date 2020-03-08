package model.time;

import java.util.ArrayList;
import java.util.HashMap;

import model.task.Task;

public class Timetable {
    private HashMap<Integer, Task> timetable;

    public Timetable() {
        timetable = new HashMap<>();
    }

    public void addTask(Task task) {
        int taskValue = Integer.parseInt((task.getTime()).getHour());
        timetable.put(taskValue, task);
    }

    public ArrayList<String> blankTimetable() {
        ArrayList<String> blankTimetable = new ArrayList<>();
        blankTimetable.add("12:00 AM");
        for (int i = 1; i < 12; i++) {
            blankTimetable.add(i + ":00 AM");
        }
        blankTimetable.add("12:00 PM");
        for (int i = 1; i < 12; i++) {
            blankTimetable.add(i + ":00 PM");
        }
        return blankTimetable;
    }

    public HashMap<Integer, Task> getTimetable() {
        return timetable;
    }

}