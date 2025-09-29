
import java.util.Scanner;
import src.*;

public class Main {

    private DispenseChain c1;

    public Main() {
        // Initialize chain
        this.c1 = new Rupee2000Dispenser();
        DispenseChain c2 = new Rupee500Dispenser();
        DispenseChain c3 = new Rupee200Dispenser();
        DispenseChain c4 = new Rupee100Dispenser();

        // Set chain of responsibility
        c1.setNextChain(c2);
        c2.setNextChain(c3);
        c3.setNextChain(c4);
    }

    public static void main(String[] args) {
        Main atmDispenser = new Main();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: ");
        int amount = scanner.nextInt();

        if (amount % 100 != 0) {
            System.out.println("Amount should be in multiples of 100");
            return;
        }

        atmDispenser.c1.dispense(new Currency(amount));
    }
}
