package eu.urzicroft.command.parser;

import eu.urzicroft.*;

public class AddExerciseCommand implements CommandHandler {
    /**
     * Adds an exercise to a specific workout on a given date and ensures that the exercise details are valid.
     * <p>
     * This method is invoked when the command starts with "ADD EXERCISE" (case-insensitive).
     *
     * @param args An array of strings containing the parameters for adding the exercise:
     *             <ul>
     *             <li><strong>[0]:</strong> The command keyword ("ADD EXERCISE").</li>
     *             <li><strong>[1]:</strong> The date of the workout in the format "DD.MM.YYYY".</li>
     *             <li><strong>[2]:</strong> The muscle group targeted by the exercise (e.g., "Chest", "Back").</li>
     *             <li><strong>[3]:</strong> The name of the exercise (e.g., "Bench Press", "Deadlift").</li>
     *             <li><strong>[4]:</strong> The number of sets performed (integer).</li>
     *             <li><strong>[5]:</strong> The number of reps per set (integer).</li>
     *             <li><strong>[6]:</strong> The weight used for the exercise in kilograms (integer).</li>
     *             </ul>
     * <p>
     * Example usage:
     * <pre>
     * String[] args = {"ADD EXERCISE", "19.02.2024", "Chest", "Bench Press", "3", "8", "80"};
     * </pre>
     */
    @Override
    public void handle(String[] args) {
        Database database = Database.getInstance(Main.databasePath);

        Day day = database.getDay(args[1]);

        if (day.isDone())
            throw new RuntimeException("The date " + day.getDate() + " has already been marked as done.");

        MuscleGroup muscleGroup = day.getMuscleGroup(args[2]);

        Exercise exercise = new Exercise(args[3].toUpperCase(),
                Integer.parseInt(args[4]),
                Integer.parseInt(args[5]),
                Integer.parseInt(args[6]));

        muscleGroup.addExercise(exercise);
        database.addNewPR(MuscleGroup.Name.valueOf(args[2].toUpperCase()), exercise);
    }

    @Override
    public boolean supports(String command) {
        return "ADD EXERCISE".equalsIgnoreCase(command);
    }
}
