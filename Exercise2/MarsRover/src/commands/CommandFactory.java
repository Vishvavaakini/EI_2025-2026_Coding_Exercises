package src.commands;

import java.util.*;
import java.util.function.Supplier;

public class CommandFactory {

    private static final Map<Character, Supplier<Command>> commands = new HashMap<>();

    static {
        register('M', MoveCommand::new);
        register('L', TurnLeftCommand::new);
        register('R', TurnRightCommand::new);
    }

    public static void register(char key, Supplier<Command> supplier) {
        commands.put(key, supplier);
    }

    public static Command create(char key) {
        Supplier<Command> supplier = commands.get(key);
        if (supplier == null) {
            throw new IllegalArgumentException("Invalid command: " + key);
        }
        return supplier.get();
    }
}
