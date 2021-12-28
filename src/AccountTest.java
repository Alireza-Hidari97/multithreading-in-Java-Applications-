import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountTest {

    public static void main(String[] args) {

        Account account1 = new Account("Alireza Haidari", 2021);
        Account account2 = new Account("Sepideh Akbari", 100000);
        Account account3 = new Account("Shahram Jalaliniya", 500000);

        Transaction transaction1 = new Transaction("withdraw", 100, account1);
        Transaction transaction2 = new Transaction("deposit", 120, account2);
        Transaction transaction3 = new Transaction("deposit", 10, account3);
        Transaction transaction4 = new Transaction("withdraw", 1000, account3);

        ArrayList<Transaction> transactions = new ArrayList<Transaction>();

        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        transactions.add(transaction4);

        ExecutorService myExecutor = Executors.newFixedThreadPool(4);
        for (Transaction t : transactions) {
            myExecutor.execute(t);
        }
        myExecutor.shutdown();
        while (!myExecutor.isTerminated()) {
        }
    }
}
