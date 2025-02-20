package eu.urzicroft.command.parser;

public interface CommandHandler {
    void handle(String[] args);
    boolean supports(String command);
}
