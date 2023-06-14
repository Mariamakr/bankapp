package gr.aueb.cf.model;

import gr.aueb.cf.exceptions.InsufficientBalanceExceptions;
import gr.aueb.cf.exceptions.NegativeAmountException;
import gr.aueb.cf.exceptions.SsnNotValidException;

public class OverDraftAccount extends Account {
    public OverDraftAccount() {
    }

    public OverDraftAccount(User holder, String iban, double balance) {

        super(holder, iban, balance);
    }

    @Override
    public void withdraw(double amount, String ssn)
            throws SsnNotValidException, NegativeAmountException {
        try {
            if (amount < 0) throw new NegativeAmountException(amount);
            if (!isSsnValid(ssn)) throw new SsnNotValidException(ssn);

            setBalance(getBalance() - amount);
        } catch (SsnNotValidException | NegativeAmountException e) {
            System.out.println("Error: withdraw");

            throw e;
        }
    }
}
