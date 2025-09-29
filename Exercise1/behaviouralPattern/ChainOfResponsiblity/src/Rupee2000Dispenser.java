package src;

public class Rupee2000Dispenser implements DispenseChain {

    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        if (cur.getAmount() >= 2000) {
            int num = cur.getAmount() / 2000;
            int remainder = cur.getAmount() % 2000;
            System.out.println("Dispensing " + num + " notes of 2000");
            if (remainder != 0) {
                this.chain.dispense(new Currency(remainder));
            }
        } else {
            this.chain.dispense(cur);
        }
    }
}
