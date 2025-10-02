package src.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {

    // Log command execution with position and direction
    public static void logCommandWithPosition(String commandName, src.core.Position position, src.core.Direction direction) {
        info(commandName + " executed at position: " + position + " facing: " + direction);
    }

    // Log obstacle detection with position and optional message
    public static void logObstacleDetected(src.core.Position position, String message) {
        info("OBSTACLE DETECTED at position: " + position + (message != null ? ". " + message : ""));
    }

    // Log all encountered obstacles
    public static void logEncounteredObstacles(java.util.Set<src.core.Position> obstacles) {
        if (obstacles == null || obstacles.isEmpty()) {
            info("No obstacles encountered.");
        } else {
            info("Encountered obstacles: " + obstacles);
        }
    }

    public static void logRoverStatus(src.core.RoverStatus status) {
        info("ROVER STATUS: " + status);
    }

    private static String logFile = "C:\\git\\EI_2025-2026_Coding_Exercises\\Exercise2\\MarsRover\\src\\utils\\rover.log";
    // Only file logging is performed

    public static void setLogFile(String filePath) {
        logFile = filePath;
    }

    public static void setLogToConsole(boolean value) {
        // Method removed; console logging is not supported
    }

    public static void info(String message) {
        log("INFO", message, null);
    }

    public static void error(String message, Exception e) {
        log("ERROR", message, e);
    }

    public static void debug(String message) {
        log("DEBUG", message, null);
    }

    private static void log(String level, String message, Exception e) {
        StringBuilder sb = new StringBuilder();
        sb.append(LocalDateTime.now())
                .append(" [").append(level).append("] ")
                .append(message);
        if (e != null) {
            sb.append(" Exception: ").append(e.toString());
            for (StackTraceElement ste : e.getStackTrace()) {
                sb.append("\n    at ").append(ste.toString());
            }
        }
        sb.append(System.lineSeparator());
        try (FileWriter writer = new FileWriter(logFile, true)) {
            writer.write(sb.toString());
        } catch (IOException ioEx) {
            System.err.println("Logging failed: " + ioEx.getMessage());
        }
        // Console logging disabled; only file logging is performed
    }
}
