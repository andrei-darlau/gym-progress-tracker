package eu.urzicroft;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Database implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private static Database instance;
    private final ArrayList<Split> splits = new ArrayList<>();
    private final HashMap<MuscleGroup.Name, HashMap<String, Exercise>> prs = new HashMap<>();

    private Database() {}

    /**
     * Method to load the Database instance from a file if it exists.
     *
     * @param filePath Path to the serialized file.
     * @return The loaded Database instance or a new instance if the file doesn't exist.
     */
    public static Database getInstance(String filePath) {
        if (instance == null) {
            File file = new File(filePath);

            if (file.exists()) {
                try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                    instance = (Database) in.readObject();
                } catch (IOException | ClassNotFoundException e) {
                    System.err.println("Error loading database from file: " + e.getMessage());
                }
            } else {
                // new Instance because the class was never initialized
                instance = new Database();
            }
        }

        return instance;
    }

    /**
     * Method to store the Database instance to a file.
     *
     *
     * @param filePath Path to the serialized file.
     */
    public static void storeDatabase(String filePath) {
        if (instance == null)
            return;

        File file = new File(filePath);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(instance);
        } catch (IOException e) {
            System.err.println("Error writing database to file: " + e.getMessage());
        }
    }

    public void addWeek(Split split) {
        splits.add(split);
    }

    public ArrayList<Split> getWeeks() {
        return splits;
    }

    public Day getFirstFreeDay() {
        Database database = Database.getInstance(Main.databasePath);

        Split split = database.getWeeks().stream()
                .filter(splitInstance -> !splitInstance.isDone())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("All splits are recorded."));

        return split.getDays().stream()
                .filter(dayInstance -> !dayInstance.isDone())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("There are no free days in this split"));
    }

    public Day getDay(String date) {
        Database database = Database.getInstance(Main.databasePath);

        Split split = database.getWeeks().stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Day doesn't exist."));

        return split.getDay(date);
    }

    public void addNewPR(MuscleGroup.Name name, Exercise exercise) {
        HashMap<String, Exercise> muscleGroupPRs = prs.computeIfAbsent(name, k -> new HashMap<>());

        Exercise oldExercise = muscleGroupPRs.get(exercise.getName());

        if (oldExercise == null || exercise.compareTo(oldExercise) > 0) {
            muscleGroupPRs.put(exercise.getName(), exercise);
        }
    }

    public HashMap<MuscleGroup.Name, HashMap<String, Exercise>> getPrs() {
        return prs;
    }
}
