package eu.urzicroft.command.group;

import eu.urzicroft.MuscleGroup;

public abstract class CommandGroup {
    private MuscleGroup group;
    private final MuscleGroup backup;

    public CommandGroup(MuscleGroup group) {
        this.group = group;
        this.backup = group;
    }

    public void undo() {
        this.group = this.backup;
    }

    public abstract void execute();
}
