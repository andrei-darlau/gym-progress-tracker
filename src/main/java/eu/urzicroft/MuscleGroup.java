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
    private final HashMap<String, Exercise> exerciseHashMap = new HashMap<>();

    public MuscleGroup(String group) {
        this.group = Name.valueOf(group.toUpperCase());
    }


}
