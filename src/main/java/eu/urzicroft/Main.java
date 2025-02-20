package eu.urzicroft;

import eu.urzicroft.command.parser.*;

public class Main {
    public static String inputPath = "input.csv";
    public static String databasePath = "database.ser";

    public static void main(String[] args) {
        CommandRegistry registry = new CommandRegistry();

        registry.register(new AddWorkoutCommand());
        registry.register(new CreateSplitCommand());
        registry.register(new AddExerciseCommand());
        registry.register(new DoneCommand());
        registry.register(new ShowPRCommand());
        registry.register(new ShowDayCommand());

        FileParser parser = new FileParser(registry);
        parser.read(inputPath);
    }
}