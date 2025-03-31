package eu.urzicroft.command.parser;

import eu.urzicroft.Database;
import eu.urzicroft.Day;
import eu.urzicroft.Main;

public class DoneCommand implements CommandHandler {
    /**
     * Marks a workout on a specific date as completed.
     * <p>
     * This method is invoked when the command starts with "DONE" (case-insensitive).
     *
     * @param args An array of strings containing the parameters for marking the workout as done:
     *             <ul>
     *             <li><strong>[0]:</strong> The command keyword ("DONE").</li>
     *             <li><strong>[1]:</strong> The date of the workout in the format "DD.MM.YYYY".</li>
     *             </ul>
     * <p>
     * Example usage:
     * <pre>
     * String[] args = {"DONE", "19.02.2024"};
     * </pre>
     */
    @Override
    public void handle(String[] args) {
        Database database = Database.getInstance(Main.databasePath);

        Day day = database.getDay(args[1]);
        day.setDone();

        database.getFirstFreeSplit().areAllDaysDone();
    }

    @Override
    public boolean supports(String command) {
        return "DONE".equalsIgnoreCase(command);
    }
}
