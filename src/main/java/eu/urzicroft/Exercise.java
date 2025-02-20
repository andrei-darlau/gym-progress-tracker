package eu.urzicroft;

public class Exercise implements Comparable<Exercise> {
    private final String name;
    private int sets;
    private int reps;
    private int weight;

    public Exercise(String name, int sets, int reps, int weight) {
        this.name = name;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
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

    public String getName() {
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

    @Override
    public int compareTo(Exercise e) {
        if (this.weight > e.getWeight())
            return 1;
        else if (this.weight < e.getWeight())
            return -1;
        else {
            if (this.reps > e.getReps())
                return 1;
            else if (this.reps < e.getReps())
                return -1;
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Exercise: " + this.name + ", weight: " + this.weight + "kg, reps: " + this.reps;
    }
}
