package src.commands;

import src.core.Rover;
import src.exception.OutOfBoundException;
import src.utils.Logger;

public class MoveCommand implements Command {

    @Override
    public void execute(Rover rover) throws OutOfBoundException {
        rover.move();
        Logger.logCommandWithPosition(getName(), rover.getStatus().position(), rover.getStatus().direction());
    }

    @Override
    public String getName() {
        return "Move";
    }

}
