package eu.urzicroft.command.parser;

import eu.urzicroft.*;

public class AddWorkoutCommand implements CommandHandler {
    /**
     * Adds the date of a Workout and ensures that the workout matches the one that corresponds with the first
     * unrecorded one.
     * <p>
     * This method is invoked when the command starts with "ADD WORKOUT" (case-insensitive).
     *
     * @param args An array of strings containing the parameters for creating the split:
     *             <ul>
     *             <li><strong>[0]:</strong> The command keyword ("ADD WORKOUT").</li>
     *             <li><strong>[1]:</strong> The date of the workout. </li>
     *             <li><strong>[2]:</strong> The current day of the split. </li>
     *             </ul>
     * <p>
     * Example usage:
     * <pre>
     * String[] args = {"ADD WORKOUT", "14.02.2025", "PUSH"};
     * </pre>
     */
    @Override
    public void handle(String[] args) {
        Database database = Database.getInstance(Main.databasePath);

        Day day = database.getFirstFreeDay();

        if (!day.getName().equalsIgnoreCase(args[2]))
            throw new RuntimeException("The first free day doesn't match the split");

        day.setDate(args[1]);
    }

    @Override
    public boolean supports(String command) {
        return "ADD WORKOUT".equalsIgnoreCase(command);
    }
}
