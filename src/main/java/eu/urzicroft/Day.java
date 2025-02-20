package eu.urzicroft;

import java.util.ArrayList;
import java.util.Map;

public class Day {
    private final String name;
    private String date;
    private final ArrayList<MuscleGroup> groups = new ArrayList<>();
    private boolean done = false;

    public Day(String name) {
        this.name = name;
    }

    public void addMuscleGroup(MuscleGroup group) {
        this.groups.add(group);
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone() {
        this.done = true;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public MuscleGroup getMuscleGroup(String muscleGroupString) {
        MuscleGroup.Name name = MuscleGroup.Name.valueOf(muscleGroupString.toUpperCase());

        return groups.stream()
                .filter(group -> group.getGroup().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("The day doesn't have the specified muscle group"));
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        // Iterate through each muscle group
        for (MuscleGroup g : groups) {
            string.append("----- ").append(g.getGroup()).append(" -----\n");

            // Iterate through each exercise in the muscle group
            for (Map.Entry<String, Exercise> exerciseEntry : g.getExercises().entrySet()) {
                String exerciseName = exerciseEntry.getKey();
                Exercise exercise = exerciseEntry.getValue();

                // Append exercise details to the StringBuilder
                string.append(exerciseName)
                        .append(": ")
                        .append(exercise.getWeight())
                        .append(" kg, ")
                        .append(exercise.getReps())
                        .append(" reps\n");
            }
        }

        // Return the final string representation
        return string.toString();
    }
}
