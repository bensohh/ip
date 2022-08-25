public class Parser {
    //The important keywords to check against with the user-input
    public static final String EXITCOMMAND = "bye";
    public static final String LISTCOMMAND = "list";
    public static final String MARKCOMMAND = "mark";
    public static final String UNMARKCOMMAND = "unmark";
    public static final String DELETECOMMAND = "delete";

    //The Strings representing the 3 types of Tasks
    public static final String TODO = "todo";
    public static final String DEADLINE = "deadline";
    public static final String EVENT = "event";

    public Parser() {
    }

    public static Command parse(String fullCommand) throws DukeException {

        if (fullCommand.isEmpty() || fullCommand.isBlank()) {
            String error_msg = "__________________________________________________\n" +
                    "Please enter valid inputs, empty strings or blanks are not valid!";
            throw new DukeException(error_msg);
        }

        //To obtain the first word in the user-input, used to check for keyword/command
        String[] array = fullCommand.split(" ", 2);
        String firstText = array[0];

        if (fullCommand.equals(EXITCOMMAND)) {
            return new ExitCommand();
        } else if (fullCommand.equals(LISTCOMMAND)) {
            return new ListCommand();
        } else if (firstText.equals(DELETECOMMAND)) {
            if (array.length == 1) {
                String error_msg = "__________________________________________________\n" +
                        "OOPS!!! The task number for deleting must be specified!";
                throw new DukeException(error_msg);
            }
            return new DeleteCommand(array[1]);
        } else if (firstText.equals(MARKCOMMAND)) {
            if (array.length == 1) {
                String error_msg = "__________________________________________________\n" +
                        "OOPS!!! The task number for marking must be specified!";
                throw new DukeException(error_msg);
            }
            return new MarkCommand(array[1]);
        } else if (firstText.equals(UNMARKCOMMAND)) {
            if (array.length == 1) {
                String error_msg = "__________________________________________________\n" +
                        "OOPS!!! The task number for unmarking must be specified!";
                throw new DukeException(error_msg);
            }
            return new UnmarkCommand(array[1]);
        } else if (firstText.equals(TODO)) {
            if (array.length == 1) {
                String error_msg = "__________________________________________________\n" +
                        "OOPS!!! The description of a todo cannot be empty.";
                throw new DukeException(error_msg);
            }
            return new AddCommand(0, array[1]);
        } else if (firstText.equals(DEADLINE)) {
            if (array.length == 1) {
                String error_msg = "__________________________________________________\n" +
                        "OOPS!!! The description of a deadline cannot be empty.";
                throw new DukeException(error_msg);
            }
            return new AddCommand(1, array[1]);
        } else if (firstText.equals(EVENT)) {
            if (array.length == 1) {
                String error_msg = "__________________________________________________\n" +
                        "OOPS!!! The description of a event cannot be empty.";
                throw new DukeException(error_msg);
            }
            return new AddCommand(2, array[1]);
        } else {
            return new WrongCommand();
        }

    }
}
