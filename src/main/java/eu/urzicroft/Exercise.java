package eu.urzicroft;

public class Exercise {
    private final int name;
    private int weight;
    private int reps;
    private int sets;

    public Exercise(int name, int weight, int reps, int sets) {
        this.name = name;
        this.weight = weight;
        this.reps = reps;
        this.sets = sets;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getReps() {
        return reps;
    }

    public int getSets() {
        return sets;
    }
}
