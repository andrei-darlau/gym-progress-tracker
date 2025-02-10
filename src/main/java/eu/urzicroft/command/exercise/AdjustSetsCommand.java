package eu.urzicroft.command.exercise;

import eu.urzicroft.Exercise;

public class AdjustSetsCommand extends CommandExercise {
    private final int sets;

    public AdjustSetsCommand(Exercise exercise, int sets) {
        super(exercise);
        this.sets = sets;
    }

    @Override
    public void execute() {
        this.exercise.setReps(sets);
    }
}
