package eu.urzicroft.command.exercise;

import eu.urzicroft.Exercise;

public class AdjustRepsCommand extends CommandExercise {
    private final int reps;

    public AdjustRepsCommand(Exercise exercise, int reps) {
        super(exercise);
        this.reps = reps;
    }

    @Override
    public void execute() {
        this.exercise.setReps(reps);
    }
}
