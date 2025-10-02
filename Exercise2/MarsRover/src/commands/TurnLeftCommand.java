package src.commands;

import src.core.Rover;
import src.utils.Logger;

public class TurnLeftCommand implements Command {

    @Override
    public void execute(Rover rover) {
        rover.turnLeft();
        Logger.logCommandWithPosition(getName(), rover.getStatus().position(), rover.getStatus().direction());
    }

    @Override
    public String getName() {
        return "Turn Left";
    }
}
