import src.PrintSpooler;

/**
 * Main class to demonstrate the Singleton Print Spooler.
 */
public class Main {
    public static void main(String[] args) {
        PrintSpooler spooler1 = PrintSpooler.getInstance();
        PrintSpooler spooler2 = PrintSpooler.getInstance();

        // Validate singleton behavior
        System.out.println("spooler1 == spooler2 ? " + (spooler1 == spooler2));

        // Add jobs
        spooler1.addJob("Report.pdf");
        spooler2.addJob("Invoice.docx");

        // Process jobs
        spooler1.processNextJob();
        spooler2.processNextJob();
        spooler1.processNextJob(); // empty case
    }
}
