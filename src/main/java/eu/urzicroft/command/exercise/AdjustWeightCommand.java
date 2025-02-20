package eu.urzicroft.command.exercise;

import eu.urzicroft.Exercise;

public class AdjustWeightCommand extends ExerciseCommand {
    private final int weight;

    public AdjustWeightCommand(Exercise exercise, int weight) {
        super(exercise);
        this.weight = weight;
    }


    @Override
    public void execute() {
        exercise.setWeight(weight);
    }
}
