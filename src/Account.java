public class Account {

    private final int accountId;
    private final String holderName;
    private double balance;
    private static int numAccounts = 0;


    public Account(String holderName, double initialBalance) {
        this.holderName = holderName;
        accountId = ++numAccounts;
        balance = initialBalance;
        System.out.println("new account created=> account ID: " + accountId
                + ", holder name: " + holderName + ", initial balance: " + balance);
    }


    public synchronized void withdraw(double withdrawAmt) {
        System.out.println(holderName + " " + "is trying to withdraw " + withdrawAmt + "$ from account ID: " + accountId);
        try {

            if (balance >= withdrawAmt) {
                //updating the balance
                balance = balance - withdrawAmt;
                System.out.println(holderName + " " + " successfully completed the withdraw"
                        + ", Now current balance : " + balance + "$");
            } else {
                System.out.println(holderName + " " + "doesn't have enough money to withdraw ");
            }

        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }


    public synchronized void deposit(double depositAmt) {
        System.out.println(holderName + " " + " is trying to deposit " + depositAmt + "$ to account ID: " + accountId);
        try {
            if (depositAmt > 0) {
                balance = balance + depositAmt;
                System.out.println(holderName + " " + " completed the deposit"
                        + ", Now current balance : " + balance + "$");
            } else {
                System.out.println(holderName + " " + "doesn't have enough money to deposit");
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
}




