package src;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Singleton class representing a Print Spooler. Ensures only one instance
 * handles all print jobs.
 */
public class PrintSpooler {

    // Eager initialization ensures thread safety
    private static final PrintSpooler INSTANCE = new PrintSpooler();

    private final Queue<String> printQueue = new LinkedList<>();

    // Private constructor prevents instantiation
    private PrintSpooler() {
        System.out.println("Print Spooler initialized...");
    }

    // Global access point
    public static PrintSpooler getInstance() {
        return INSTANCE;
    }

    /**
     * Add a document to the print queue.
     *
     * @param document - non-null, non-empty document name
     */
    public synchronized void addJob(String document) {
        if (document == null || document.isBlank()) {
            throw new IllegalArgumentException("Document name must not be null or empty.");
        }
        printQueue.add(document);
        System.out.println("Added job: " + document);
    }

    /**
     * Process the next job in the queue.
     */
    public synchronized void processNextJob() {
        if (printQueue.isEmpty()) {
            System.out.println("No jobs in the queue.");
            return;
        }
        String job = printQueue.poll();
        System.out.println("Printing job: " + job);
    }
}
