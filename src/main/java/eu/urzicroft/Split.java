package eu.urzicroft;

import java.util.ArrayList;

public class Split {
    private final String name;
    private final int nrDays;
    private final ArrayList<Day> days;

    public Split(String name, int nrDays) {
        this.name = name;
        this.nrDays = nrDays;
        this.days = new ArrayList<>(nrDays);
    }
}
