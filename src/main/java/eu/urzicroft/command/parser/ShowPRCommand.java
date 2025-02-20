package eu.urzicroft.command.parser;

import eu.urzicroft.Database;
import eu.urzicroft.Exercise;
import eu.urzicroft.Main;
import eu.urzicroft.MuscleGroup;

import java.util.HashMap;
import java.util.Map;



public class ShowPRCommand implements CommandHandler {
    @Override
    public void handle(String[] args) {
        Database database = Database.getInstance(Main.databasePath);

        for (Map.Entry<MuscleGroup.Name, HashMap<String, Exercise>> muscleGroupEntry : database.getPrs().entrySet()) {
            MuscleGroup.Name name = muscleGroupEntry.getKey();
            HashMap<String, Exercise> exercises = muscleGroupEntry.getValue();

            System.out.println("------ " + name + " ------");

            for (Map.Entry<String, Exercise> exerciseEntry : exercises.entrySet()) {
                String exerciseName = exerciseEntry.getKey();
                Exercise exercise = exerciseEntry.getValue();
                System.out.println(exerciseName + ": " + exercise.getWeight() + " kg, " + exercise.getReps() + " reps");
            }

            System.out.println();
        }
    }

    @Override
    public boolean supports(String command) {
        return "SHOW PR".equalsIgnoreCase(command);
    }
}
