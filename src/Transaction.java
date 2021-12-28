class Transaction implements Runnable {

    private String transactionType;
    private double amount;
    private Account account;

    public Transaction(String transactionType, double amount, Account account) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.account = account;
    }

    @Override
    public void run() {
        if (transactionType.equalsIgnoreCase("withdraw"))
            account.withdraw(amount);
        else
            account.deposit(amount);
    }
}