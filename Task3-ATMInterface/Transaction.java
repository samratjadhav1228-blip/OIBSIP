

import java.util.ArrayList;

public class Transaction {

    private ArrayList<String> history;

    public Transaction() {
        history = new ArrayList<String>();
    }

    public void add(String record) {
        history.add(record);
    }

    public void show() {
        if (history.size() == 0) {
            System.out.println("No transactions yet.");
        } else {
            for (int i = 0; i < history.size(); i++) {
                System.out.println(history.get(i));
            }
        }
    }
}