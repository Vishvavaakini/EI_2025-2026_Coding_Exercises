package src.commands;

import src.core.Rover;
import src.utils.Logger;

public class TurnRightCommand implements Command {

    @Override
    public void execute(Rover rover) {
        rover.turnRight();
        Logger.logCommandWithPosition(getName(), rover.getStatus().position(), rover.getStatus().direction());
    }

    @Override
    public String getName() {
        return "Turn Right";
    }
}
