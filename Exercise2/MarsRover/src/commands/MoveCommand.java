package src.commands;

import src.core.Rover;
import src.exception.OutOfBoundException;

public class MoveCommand implements Command {
    @Override
    public void execute(Rover rover) throws OutOfBoundException {
        rover.move();
    }
}
