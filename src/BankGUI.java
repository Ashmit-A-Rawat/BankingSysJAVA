import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

interface CentralBank {
    long getBalance();
    void withdraw(long amount);
    void deposit(long amount);
    void showAccount();
    boolean search(String acc_no);
    String getDetails();
}

class Unb implements CentralBank {
    private String name;
    private String accno;
    private String acc_type;
    private long balance;

    Unb(String name, String accno, String acc_type, long balance) {
        this.name = name;
        this.accno = accno;
        this.acc_type = acc_type;
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public void withdraw(long amount) {
        if (balance >= amount) {
            balance -= amount;
            JOptionPane.showMessageDialog(null, "Balance after withdrawal: " + balance);
        } else {
            JOptionPane.showMessageDialog(null, "Your balance is less than " + amount + "\nTransaction failed...!!");
        }
    }

    public void deposit(long amount) {
        balance += amount;
    }

    public void showAccount() {
        String info = getDetails();
        JOptionPane.showMessageDialog(null, info);
    }

    public boolean search(String ac_no) {
        return accno.equals(ac_no);
    }

    public String getDetails() {
        return "UNB Bank account\n" +
                "Name of account holder: " + name + "\n" +
                "Account no.: " + accno + "\n" +
                "Account type: " + acc_type + "\n" +
                "Balance: " + balance;
    }
}

class Nbd implements CentralBank {
    private String name;
    private String accno;
    private String acc_type;
    private long balance;

    Nbd(String name, String accno, String acc_type, long balance) {
        this.name = name;
        this.accno = accno;
        this.acc_type = acc_type;
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public void withdraw(long amount) {
        if (balance >= amount) {
            balance -= amount;
            JOptionPane.showMessageDialog(null, "Balance after withdrawal: " + balance);
        } else {
            JOptionPane.showMessageDialog(null, "Your balance is less than " + amount + "\nTransaction failed...!!");
        }
    }

    public void deposit(long amount) {
        balance += amount;
    }

    public void showAccount() {
        String info = getDetails();
        JOptionPane.showMessageDialog(null, info);
    }

    public boolean search(String ac_no) {
        return accno.equals(ac_no);
    }

    public String getDetails() {
        return "NBD Bank account\n" +
                "Name of account holder: " + name + "\n" +
                "Account no.: " + accno + "\n" +
                "Account type: " + acc_type + "\n" +
                "Balance: " + balance;
    }
}

class Fgb implements CentralBank {
    private String name;
    private String accno;
    private String acc_type;
    private long balance;

    Fgb(String name, String accno, String acc_type, long balance) {
        this.name = name;
        this.accno = accno;
        this.acc_type = acc_type;
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public void withdraw(long amount) {
        if (balance >= amount) {
            balance -= amount;
            JOptionPane.showMessageDialog(null, "Balance after withdrawal: " + balance);
        } else {
            JOptionPane.showMessageDialog(null, "Your balance is less than " + amount + "\nTransaction failed...!!");
        }
    }

    public void deposit(long amount) {
        balance += amount;
    }

    public void showAccount() {
        String info = getDetails();
        JOptionPane.showMessageDialog(null, info);
    }

    public boolean search(String ac_no) {
        return accno.equals(ac_no);
    }

    public String getDetails() {
        return "FGB Bank account\n" +
                "Name of account holder: " + name + "\n" +
                "Account no.: " + accno + "\n" +
                "Account type: " + acc_type + "\n" +
                "Balance: " + balance;
    }
}

public class BankGUI {
    private ArrayList<CentralBank> accounts;

    public BankGUI() {
        accounts = new ArrayList<>();
        createGUI();
    }

    private void createGUI() {
        JFrame frame = new JFrame("Banking System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(new GridLayout(0, 1));

        JButton createAccountBtn = createButton("Create Account", e -> createAccount());
        JButton displayAccountsBtn = createButton("Display All Accounts", e -> displayAccounts());
        JButton searchAccountBtn = createButton("Search Account", e -> searchAccount());
        JButton depositBtn = createButton("Deposit Amount", e -> depositAmount());
        JButton withdrawBtn = createButton("Withdraw Amount", e -> withdrawAmount());
        JButton removeAccountBtn = createButton("Remove Account", e -> removeAccount());
        JButton checkBalanceBtn = createButton("Check Account Balance", e -> checkAccountBalance());

        frame.add(createAccountBtn);
        frame.add(displayAccountsBtn);
        frame.add(searchAccountBtn);
        frame.add(depositBtn);
        frame.add(withdrawBtn);
        frame.add(removeAccountBtn);
        frame.add(checkBalanceBtn);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

    private JButton createButton(String text, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.addActionListener(actionListener);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setForeground(Color.BLACK);  // Set text color to black

        switch (text) {
            case "Create Account":
                button.setBackground(Color.GREEN);
                break;
            case "Display All Accounts":
                button.setBackground(Color.BLUE);
                break;
            case "Search Account":
                button.setBackground(Color.ORANGE);
                break;
            case "Deposit Amount":
                button.setBackground(Color.CYAN);
                break;
            case "Withdraw Amount":
                button.setBackground(Color.RED);
                break;
            case "Remove Account":
                button.setBackground(Color.MAGENTA);
                break;
            case "Check Account Balance":
                button.setBackground(Color.YELLOW);
                break;
        }

        button.setBorder(BorderFactory.createRaisedBevelBorder());
        return button;
    }

    private void createAccount() {
        String name = JOptionPane.showInputDialog("Enter Name:");
        String accNo = JOptionPane.showInputDialog("Enter Account No:");
        String accType = JOptionPane.showInputDialog("Enter Account Type:");
        long balance = Long.parseLong(JOptionPane.showInputDialog("Enter Initial Balance:"));

        for (CentralBank account : accounts) {
            if (account.search(accNo)) {
                JOptionPane.showMessageDialog(null, "Account with entered accNo already exists.");
                return;
            }
        }

        CentralBank newAccount = null;
        if (balance < 1000) {
            newAccount = new Unb(name, accNo, accType, balance);
        } else if (balance < 2000) {
            newAccount = new Nbd(name, accNo, accType, balance);
        } else if (balance < 3000) {
            newAccount = new Fgb(name, accNo, accType, balance);
        } else {
            JOptionPane.showMessageDialog(null, "Minimum balance requirement not met.");
        }

        if (newAccount != null) {
            accounts.add(newAccount);
            JOptionPane.showMessageDialog(null, "Account created successfully.");
        }
    }

    private void displayAccounts() {
        if (accounts.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No accounts found.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (CentralBank account : accounts) {
                sb.append(account.getDetails()).append("\n\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }

    private void searchAccount() {
        String accNo = JOptionPane.showInputDialog("Enter Account No:");
        boolean found = false;
        for (CentralBank account : accounts) {
            if (account.search(accNo)) {
                account.showAccount();
                found = true;
                break;
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(null, "Account doesn't exist.");
        }
    }

    private void depositAmount() {
        String accNo = JOptionPane.showInputDialog("Enter Account No:");
        boolean found = false;
        for (CentralBank account : accounts) {
            if (account.search(accNo)) {
                long amount = Long.parseLong(JOptionPane.showInputDialog("Enter amount to deposit:"));
                account.deposit(amount);
                JOptionPane.showMessageDialog(null, "Deposit successful!");
                found = true;
                break;
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(null, "Account doesn't exist.");
        }
    }

    private void withdrawAmount() {
        String accNo = JOptionPane.showInputDialog("Enter Account No:");
        boolean found = false;
        for (CentralBank account : accounts) {
            if (account.search(accNo)) {
                long amount = Long.parseLong(JOptionPane.showInputDialog("Enter amount to withdraw:"));
                account.withdraw(amount);
                found = true;
                break;
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(null, "Account doesn't exist.");
        }
    }

    private void removeAccount() {
        String accNo = JOptionPane.showInputDialog("Enter Account No:");
        boolean found = false;
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).search(accNo)) {
                accounts.remove(i);
                JOptionPane.showMessageDialog(null, "Account deleted successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(null, "Account doesn't exist.");
        }
    }

    private void checkAccountBalance() {
        String accNo = JOptionPane.showInputDialog("Enter Account No:");
        boolean found = false;
        for (CentralBank account : accounts) {
            if (account.search(accNo)) {
                long balance = account.getBalance();
                JOptionPane.showMessageDialog(null, "Current Balance: " + balance);
                found = true;
                break;
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(null, "Account doesn't exist.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BankGUI::new);
    }
}
