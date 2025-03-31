package eu.urzicroft.command.parser;

import eu.urzicroft.*;

public class CreateSplitCommand implements CommandHandler {
    /**
     * Creates a new Split/Split configuration for the next set of workouts.
     * <p>
     * This method is invoked when the command starts with "CREATE SPLIT" (case-insensitive).
     * It initializes a new workout split based on the provided arguments.
     *
     * @param args An array of strings containing the parameters for creating the split:
     *             <ul>
     *             <li><strong>[0]:</strong> The command keyword ("CREATE SPLIT").</li>
     *             <li><strong>[1]:</strong> The name of the split (e.g., "PushPullLegs", "UpperLower").</li>
     *             <li><strong>[2]:</strong> The number of different exercise days in the split (e.g., 3 for Push/Pull/Legs).</li>
     *             <li><strong>[3]:</strong> The number of times the split repeats in a week.</li>
     *             <li><strong>[4+]:</strong> The names of the exercise days (e.g., "Push", "Pull", "Legs").</li>
     *             </ul>
     * <p>
     * Example usage:
     * <pre>
     * String[] args = {"CREATE SPLIT", "PushPullLegs", "3", "2", "Push Chest|Triceps", "Pull Back|Biceps", "Legs Legs"};
     * </pre>
     */
    @Override
    public void handle(String[] args) {
        Database database = Database.getInstance(Main.databasePath);

        String splitName = args[1];
        int diffDays = Integer.parseInt(args[2]);
        int splitReps = Integer.parseInt(args[3]);

        Split split = new Split(splitName, diffDays * splitReps);

        for (int i = 0; i < diffDays; i++) {
            String[] splitArgs = args[4 + i].split(" ");

            String dayName = splitArgs[0];
            String[] muscleGroups = splitArgs[1].split("\\|");

            for (int j = 0; j < splitReps; j++) {
                Day day = new Day(dayName);
                for (String group : muscleGroups)
                    day.addMuscleGroup(new MuscleGroup(group));
                split.addDayAtIndex(day, i + j * diffDays);
            }
        }

        database.addWeek(split);
    }

    @Override
    public boolean supports(String command) {
        return "CREATE SPLIT".equalsIgnoreCase(command);
    }
}
