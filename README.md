## Description

The **Gym Progress Tracker** is a Java application designed to help you manage your workout routines, create customized splits, and track your progress. It records your personal records (PRs) for various exercises, allowing you to monitor your strength improvements over time.

This project was developed as a learning experience to explore **Design Patterns** and **Functional Programming** concepts in Java.

## Commands

The application follows the **Command Design Pattern**, enabling users to interact with the system through structured commands. All commands are stored in a `.csv` file. By default, the input file is located at `input.csv` and can be modified externally without changing the source code.

> Each command has an example usage in its implementation: `src/main/java/eu.urzicroft/parser/<command_name>`

I have provided you with an example `input.csv` in the git repo.

### Available Commands

#### **Create Split**
Creates a new **Split** object and adds it to the database. After execution, the application waits for the user to specify workout days (in the order they were listed).

#### **Add Workout**
Adds a workout to a specific day in the split. The command must contain the next day in the sequence; otherwise, an exception will be thrown.

#### **Add Exercise**
Records an exercise in the database. If a new PR is detected, the system updates the record instead of duplicating it. This allows for later modifications in case of input errors.

#### **Done**
Marks the completion of exercise entries for a specific day, allowing you to move on to the next workout.

#### **Show Day**
Displays all exercises performed on a specified day.

#### **Show PR**
Retrieves and displays all personal records. The system prioritizes PRs based on weight lifted; if the weight remains the same but the rep count increases, the record updates accordingly.

## Database Implementation

The application features a **primitive database** implemented using the **Singleton Design Pattern**. The database is initialized at application launch and is not stored in a traditional **SQL/MongoDB** database.

> **Important:** Since workout data is only stored in `input.csv`, ensure the file is continuously updated. **Deleting entries will result in permanent data loss.**

## Future Improvements (TODOs)
- Implement **adjust commands** to allow users to modify specific exercises.
- Improve **data persistence** to prevent accidental loss of workout history.
- Enhance **user interaction** by introducing a graphical interface or CLI improvements.