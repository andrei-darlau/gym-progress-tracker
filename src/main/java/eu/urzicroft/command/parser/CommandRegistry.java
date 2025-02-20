package eu.urzicroft.command.parser;

import java.util.ArrayList;
import java.util.List;

public class CommandRegistry {
    private final List<CommandHandler> handlers = new ArrayList<>();

    public void register(CommandHandler handler) {
        handlers.add(handler);
    }

    public CommandHandler getHandlerFor(String command) {
        return handlers.stream()
                .filter(handler -> handler.supports(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unsupported command: " + command));
    }
}
