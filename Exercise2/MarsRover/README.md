# Mars Rover Simulation 

## Overview
The **Mars Rover Simulation** is a console-based Java application that simulates the movement of a rover on a 2D grid.  
The rover can **move forward, turn left, turn right**, and interact with **obstacles** placed on the grid.  
The project demonstrates clean code design using **Command, Composite, and Observer** design patterns, and follows SOLID principles.

---

## Features
- Define grid dimensions (e.g., `5 x 5`).
- Place obstacles at chosen coordinates.
- Set a starting position and direction for the rover.
- Execute a sequence of commands:
  - `M` → Move forward
  - `L` → Turn left
  - `R` → Turn right
- Detect collisions with **obstacles** or **grid boundaries**.
- Display rover actions with meaningful logs.
- Keep track of **encountered obstacles**.
- Patterns implemented:
  - Command
  - Composite
  - Observer

---

## Key Components

### Grid
- Represents the exploration area (a rectangular grid).
- Tracks **obstacles**.
- Provides methods for validating boundaries and obstacle positions.

### Rover
- Holds the rover’s **position, direction, and status**.
- Executes actions (move, turn left, turn right).
- Maintains a record of obstacles encountered.

### Commands
- Implemented using the **Command Pattern**.
- Each command encapsulates a single rover action.
- `CommandFactory` maps user input (`M`, `L`, `R`) to actual commands.

### Obstacles
- Implemented using the **Composite Pattern**.
- Represented as independent grid components.

---

## Design Patterns

### Command Pattern
- Encapsulates rover actions (`MoveCommand`, `TurnLeftCommand`, `TurnRightCommand`).
- Makes the system extensible (e.g., adding a `JumpCommand` later).

### Composite Pattern
- Treats the **grid** and its **obstacles** as part of a uniform structure (`GridComponent`).
- Simplifies obstacle management.

### Observer Pattern
- Listeners like `ConsoleRoverObserver` receive real-time notifications about rover actions (moves, turns, obstacle hits).

---

## Example Simulation

1. **Enter Grid Dimensions**
- Enter grid size (rows cols): 5 5

2. **Set Obstacles**
- Enter number of obstacles: 2 Enter obstacle 1 (row col): 1 2 Enter obstacle 2 (row col): 3 3

3. **Set Starting Position and Direction**
Enter starting position (row col direction[N/E/S/W]): 0 0 N

4. **Enter Commands**
Enter command sequence (M/L/R): MMRMLM

5. **Output**
[Rover] Initialized at (0,0) facing North [Rover] Moved to (0,1) [Rover] Moved to (0,2) [Rover] Turned right. Now facing East [Rover] Moved to (1,2) -> Obstacle detected! Rover stopped.

---

## Final Status

Final Rover Status: Position: (1,2) Direction: East Status: Blocked: Obstacle detected

Encountered Obstacles: (1,2)

---

## Installation & Run

1. **Clone the repository:**
  ```bash
  git clone https://github.com/vishvavaakinii/EI_2025-2026_Coding_Exercises.git
  cd EI_2025-2026_Coding_Exercises/Exercise2/MarsRover
  ```

2. **Compile the project:**
  ```bash
  javac -d out src/**/*.java
  ```

3. **Run the simulation:**
  ```bash
  java -cp out MarsRover
  ```
## Contact
-  Vishva Vaakini I K
-  vish0vaks@gmail.com
