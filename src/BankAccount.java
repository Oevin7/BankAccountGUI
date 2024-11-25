public class BankAccount {
    protected String firstName;
    protected String lastName;
    protected int accountID;
    protected double balance;

    public BankAccount(String firstName, String lastName, int accountID, double balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountID = accountID;
        this.balance = balance;
    }

    public BankAccount() {
        this.firstName = "N/A";
        this.lastName = "N/A";
        this.accountID = 0;
        this.balance = 0;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdrawal(double amount) {
        this.setBalance(this.getBalance() - amount);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAccountID() {
        return this.accountID;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setAccountID(int accountID) {
        if (accountID > 0) {
            this.accountID = accountID;
        } else {
            System.out.println("Account ID cannot be negative.");
        }
    }

    public void accountSummary() {
        System.out.println("Name: " + this.firstName + " " + this.lastName);
        System.out.println("Account ID: " + this.accountID);
        System.out.println("Balance: " + this.balance);
    }

}
