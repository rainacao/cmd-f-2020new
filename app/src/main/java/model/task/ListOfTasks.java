package model.task;

import model.exceptions.NoTaskException;

import java.util.ArrayList;

public class ListOfTasks {
    private ArrayList<Task> lot;

    //EFFECTS: initializes the list of tasks
    public ListOfTasks() {
        lot = new ArrayList<>();
    }

    //MODIFIES: this
    //EFFECTS: adds a new task to list of tasks
    public void addTask(Task t) {
        lot.add(t);
    }

    public Task searchTask(Task t) throws NoTaskException {
        for (Task task: lot) {
            if (t.getName().equalsIgnoreCase((task.getName()))) {
                return task;
            }
        }
        throw new NoTaskException();
    }

    //MODIFIES: this
    //EFFECTS: deletes a task by matching names of given parameter to tasks in lot
    public void deleteTask(Task t) throws NoTaskException {
        Task temp = searchTask(t);
        lot.remove(temp);
    }

    //MODIFIES: this
    //EFFECTS: changes status of a task by matching task name to parameter
    public void changeTaskStatus(Task t) throws NoTaskException {
        Task temp = searchTask(t);
        temp.changeStatus();
    }

    //MODIFIES: this
    //EFFECTS: changes name of a task by matching task name to parameter
    public void changeTaskName(Task t, String newName) throws NoTaskException{
        Task task = searchTask(t);
        task.changeName(newName);
    }


}

