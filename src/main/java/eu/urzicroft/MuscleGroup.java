package eu.urzicroft;

import java.util.HashMap;

public class MuscleGroup {
    public enum Name {
        CHEST,
        BACK,
        BICEPS,
        TRICEPS,
        SHOULDERS,
        LEGS
    }

    private final Name group;
    private final HashMap<String, Exercise> exercises = new HashMap<>();

    public MuscleGroup(String group) {
        this.group = Name.valueOf(group.toUpperCase());
    }

    public void addExercise(Exercise exercise) {
        exercises.put(exercise.getName(), exercise);
    }

    public Name getGroup() {
        return group;
    }

    public HashMap<String, Exercise> getExercises() {
        return exercises;
    }
}