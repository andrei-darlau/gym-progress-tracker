package eu.urzicroft.command.group;

import eu.urzicroft.MuscleGroup;

public abstract class GroupCommand {
    private MuscleGroup group;
    private final MuscleGroup backup;

    public GroupCommand(MuscleGroup group) {
        this.group = group;
        this.backup = group;
    }

    public void undo() {
        this.group = this.backup;
    }

    public abstract void execute();
}
