package src.commands;

import src.core.Rover;

public interface Command {
    void execute(Rover rover) throws Exception;
    String getName(); 
}
 
    
