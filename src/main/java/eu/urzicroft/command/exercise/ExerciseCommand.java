package eu.urzicroft.command.exercise;

import eu.urzicroft.Exercise;

public abstract class ExerciseCommand {
    public Exercise exercise;
    public final Exercise backup;

    public ExerciseCommand(Exercise exercise) {
        this.exercise = exercise;
        this.backup = exercise;
    }

    public void undo() {
        this.exercise = this.backup;
    }

    public abstract void execute();
}
