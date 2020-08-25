package duke;

import duke.command.*;

public class Parser {
    public Command parse(String input) throws DukeException {
        String[] splitInput = input.split(" ", 2);
        String command = splitInput[0];
        String details = splitInput.length < 2 ? null : splitInput[1];
        String[] parsedDetails;

        switch (command) {
        case "list":
            return new ListCommand();
        case "done":
            return new DoneCommand(Integer.parseInt(details) - 1);
        case "todo":
            return new ToDoCommand(details);
        case "deadline":
            parsedDetails = details.split(" /by ", 2);
            if (parsedDetails.length < 2) {
                throw DukeException.badDeadlineDate();
            }
            return new DeadlineCommand(parsedDetails[0], parsedDetails[1]);
        case "event":
            parsedDetails = details.split(" /at ", 2);
            if (parsedDetails.length < 2) {
                throw DukeException.badEventDate();
            }
            return new EventCommand(parsedDetails[0], parsedDetails[1]);
        case "delete":
            return new DeleteCommand(Integer.parseInt(details) - 1);
        default:
            throw DukeException.badCommand();
        }
    }
}