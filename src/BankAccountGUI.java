import javax.swing.*;
import java.awt.*;

public class BankAccountGUI {
    private CheckingAccount account;
    private JFrame frame;
    private JPanel panel;
    private JLabel nameField;
    private double balance;
    private JLabel balanceField;
    private JButton depositButton;
    private JButton withdrawalButton;

    private JPanel buttonPanel;
    private JPanel basicInfoPanel;
    private GridLayout layout;

    public BankAccountGUI(CheckingAccount account) {
        this.account = account;

        panel = new JPanel(new BorderLayout());
        frame = new JFrame("Bank Account");

        basicInfoPanel = new JPanel(new GridLayout(2, 1, 4, 4));
        nameField = new JLabel("Welcome: " + " " + account.firstName + " " + account.lastName);

        layout = new GridLayout(4, 2);
        basicInfoPanel.setLayout(layout);
        balance = account.getBalance();

        basicInfoPanel.add(nameField);

        balanceField = new JLabel();
        balanceField.setText("Your balance: " + balance);
        basicInfoPanel.add(balanceField);

        panel.add(basicInfoPanel, BorderLayout.NORTH);

        withdrawalButton = new JButton("Withdrawal");
        depositButton = new JButton("Deposit");

        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawalButton);

        depositButton.addActionListener(e -> {
           JOptionPane amount = new JOptionPane();
           String input = (String) JOptionPane.showInputDialog(null, "Enter amount to deposit: ");
           double amountToDeposit = Double.parseDouble(input);
           account.deposit(amountToDeposit);
           balance = account.getBalance();
           balanceField.setText("Your balance: " + balance);
        });

        withdrawalButton.addActionListener(e -> {
            JOptionPane amount = new JOptionPane();
            String input = (String) JOptionPane.showInputDialog(null, "Enter amount to withdrawal: ");
            double amountToDeposit = Double.parseDouble(input);
            account.withdrawal(amountToDeposit);
            balance = account.getBalance();

            if (account.getBalance() > 0) {
                balanceField.setText("Your balance: " + balance);
            } else {
                balanceField.setText("Your balance: " + balance + " (Overdraft)");
            }

        });

        panel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

    }

    public static void main(String[] args) {
        CheckingAccount account = new CheckingAccount("Kevin", "Schmidt", 1, 0.0, 0.5);
        BankAccountGUI gui = new BankAccountGUI(account);
    }
}
