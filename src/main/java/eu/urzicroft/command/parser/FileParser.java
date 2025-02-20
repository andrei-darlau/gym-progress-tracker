package eu.urzicroft.command.parser;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileParser {
    private final CommandRegistry registry;

    public FileParser(CommandRegistry registry) {
        this.registry = registry;
    }

    public void read(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();

            while (line != null) {
                String[] args = line.split(",");
                String command = args[0].trim(); // First argument is the command
                CommandHandler handler = registry.getHandlerFor(command);

                // Pass all arguments to the handler
                try {
                    handler.handle(args);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                line = reader.readLine();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while reading or processing the file.", e);
        }
    }
}