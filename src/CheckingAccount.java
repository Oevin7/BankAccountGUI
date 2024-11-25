public class CheckingAccount extends BankAccount {
    protected double interestRate;
    protected boolean overdraft;

    public CheckingAccount(String firstName, String lastName, int accountID, double balance, double interestRate) {
        super(firstName, lastName, accountID, balance);
        this.interestRate = interestRate;
        this.overdraft = false;
    }

    public CheckingAccount() {
        super();
        this.interestRate = 2.5;
        this.overdraft = false;
    }

    public void processWithdrawal(double amount) {
        super.withdrawal(amount);
        if (this.getBalance() < 0) {
            System.out.println("Your account went below zero. A $30 fee will be applied");
            this.setBalance(this.getBalance() - 30);
            this.setOverdraft(true);
        } else if (this.getOverdraft() && this.getBalance() >= 0) {
            this.setOverdraft(false);
        }
        System.out.println("Your new balance is: " + "$" + this.getBalance());
    }

    public void applyInterest() {
        this.setBalance(this.getBalance() + (this.getBalance() * (this.getInterestRate() / 100)));
    }

    public boolean getOverdraft() {
        return this.overdraft;
    }

    public void setOverdraft(boolean overdraft) {
        this.overdraft = overdraft;
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public void accountSummary() {
        super.accountSummary();
        System.out.println("Interest Rate: " + this.interestRate + "%");
    }
}
