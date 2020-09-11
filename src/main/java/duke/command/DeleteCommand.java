package duke.command;

import duke.TaskList;
import duke.Ui;
import duke.task.Task;

public class DeleteCommand extends Command {
    private int taskIndex;

    public DeleteCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(TaskList tasks, Ui ui) {
        Task removedTask = tasks.removeTask(taskIndex);
        ui.displayDeleteTask(removedTask, tasks.numTasks());
    }

    @Override
    public String executeWithOutput(TaskList tasks, Ui ui) {
        Task removedTask = tasks.removeTask(taskIndex);
        return ui.getDeleteTaskResponseAsString(removedTask, tasks.numTasks());
    }
}
