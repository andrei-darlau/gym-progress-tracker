package eu.urzicroft.command.parser;

import eu.urzicroft.Database;
import eu.urzicroft.Day;
import eu.urzicroft.Main;

public class ShowDayCommand implements CommandHandler {
/**
 * Handles the "SHOW DAY" command to display the details of a specific day in the database.
 * <p>
 * This method retrieves the day's information from the database using the provided date and prints its details,
 * including the date, name of the day, and any associated statistics.
 * <p>
 * Command format: "SHOW DAY,date"
 *
 * @param args An array of strings containing the parameters for the command:
 *             <ul>
 *             <li><strong>[0]:</strong> The command keyword ("SHOW DAY").</li>
 *             <li><strong>[1]:</strong> The date of the day to display, in the format "DD.MM.YYYY".</li>
 *             </ul>
 * <p>
 * Example usage:
 * <pre>
 * String[] args = {"SHOW DAY", "19.02.2024"};
 * ShowDayCommand handler = new ShowDayCommand();
 * handler.handle(args);
 * </pre>
 */
    @Override
    public void handle(String[] args) {
        Database database = Database.getInstance(Main.databasePath);

        Day day = database.getDay(args[1]);

        System.out.println("Stats for " + day.getDate() + " (" + day.getName() + ")");
        System.out.println(day);
    }

    @Override
    public boolean supports(String command) {
        return "SHOW DAY".equalsIgnoreCase(command);
    }
}
