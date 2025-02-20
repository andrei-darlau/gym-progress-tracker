package eu.urzicroft;

import java.util.ArrayList;

// can also be called Split
public class Split {
    private final String name;
    private final int nrDays;
    private final ArrayList<Day> days;
    private boolean done;

    public Split(String name, int nrDays) {
        this.name = name;
        this.nrDays = nrDays;
        this.days = new ArrayList<>(nrDays);

        for (int i = 0; i < nrDays; i++) {
            this.days.add(null); // Add null placeholders
        }
    }

    public void addDayAtIndex(Day day, int idx) {
        this.days.set(idx, day);
    }

    public boolean isDone() {
        return done;
    }

    public void setDone() {
        this.done = true;
    }

    public ArrayList<Day> getDays() {
        return days;
    }

    public Day getDay(String date) {
        return days.stream().filter(dayInstance -> dayInstance.getDate().equals(date)).
                findFirst()
                .orElseThrow(() -> new RuntimeException("Workout hasn't been added"));
    }
}
