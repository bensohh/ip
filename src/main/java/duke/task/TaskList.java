package duke.task;

import java.util.ArrayList;

/**
 * Simulates the list used to store the Tasks added by the user
 * and provide basic operations similar to a to-do list.
 *
 * @author bensohh
 * @version CS2103T AY 22/23 Sem 1 (G01)
 */
public class TaskList {
    private ArrayList<Task> taskList;

    /**
     * Overloaded Constructor to create an instance of TaskList when provided with
     * a list of tasks (there are existing data stored in a local txt file).
     *
     * @param taskInStorage ArrayList of tasks retrieved from a local txt file
     */
    public TaskList(ArrayList<Task> taskInStorage) {
        this.taskList = taskInStorage;
    }

    /**
     * Constructor to create an instance of TaskList when there are no data stored
     * locally.
     */
    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    /**
     * Adds a task to the TaskList.
     *
     * @param task Task to be added into the list
     */
    public void add(Task task) {
        this.taskList.add(task);
    }

    /**
     * Removes a task from the TaskList.
     *
     * @param taskNumber Specified task to be removed
     */
    public void delete(int taskNumber) {
        this.taskList.remove(taskNumber);
    }

    /**
     * Returns the size of the TaskList.
     *
     * @return Integer representing the number of tasks in the TaskList
     */
    public int size() {
        return this.taskList.size();
    }

    /**
     * Retrieves the specified task.
     *
     * @param taskIndex Specified task to retrieve from the TaskList
     * @return Task corresponding to the number that was specified
     */
    public Task getTask(int taskIndex) {
        return this.taskList.get(taskIndex);
    }

    /**
     * Checks if the TaskList is empty.
     *
     * @return true if the TaskList is empty, otherwise return false
     */
    public boolean isEmpty() {
        return this.taskList.isEmpty();
    }

    /**
     * Iterate through the TaskList to find tasks with matching keywords.
     *
     * @param keyWord String representing the keyWord to search
     * @return String representation of the compiled tasks
     */
    public String findTasks(String keyWord) {
        StringBuilder tasksWithKeyWord = new StringBuilder();
        for (int i = 0; i < this.size(); i++) {
            String taskInfo = this.getTask(i).toString();
            if (taskInfo.contains(keyWord)) {
                tasksWithKeyWord.append("\n")
                        .append(i + 1)
                        .append(". ")
                        .append(taskInfo);
            }
        }
        return tasksWithKeyWord.toString();
    }
}
