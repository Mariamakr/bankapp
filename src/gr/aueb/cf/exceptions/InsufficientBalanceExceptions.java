package gr.aueb.cf.exceptions;

public class InsufficientBalanceExceptions extends Exception{
    private static final long serialVersionUID = 1L;

    public InsufficientBalanceExceptions(){}
    public InsufficientBalanceExceptions(double balance, double amount) {
        super("Insufficient balance" + balance + "for amount" + amount);
    }
}
