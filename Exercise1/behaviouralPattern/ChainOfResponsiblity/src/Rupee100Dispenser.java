package src;

public class Rupee100Dispenser implements DispenseChain {

    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        if (cur.getAmount() >= 100) {
            int num = cur.getAmount() / 100;
            int remainder = cur.getAmount() % 100;
            System.out.println("Dispensing " + num + " notes of 100");
            if (remainder != 0) {
                this.chain.dispense(new Currency(remainder));
            }
        } else {
            if (cur.getAmount() != 0) {
                System.out.println("Amount cannot be dispensed: " + cur.getAmount());
            }
        }
    }
}
