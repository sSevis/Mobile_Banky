package severin.baur.mobilebanky.model.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Transaction {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private Account sendAccount;

    private Account receiveAccount;

    private double amount;

    public int getId() {
        return id;
    }

    public Transaction setId(int id) {
        this.id = id;
        return this;
    }

    public Account getSendAccount() {
        return sendAccount;
    }

    public Transaction setSendAccount(Account sendAccount) {
        this.sendAccount = sendAccount;
        return this;
    }

    public Account getReceiveAccount() {
        return receiveAccount;
    }

    public Transaction setReceiveAccount(Account receiveAccount) {
        this.receiveAccount = receiveAccount;
        return this;
    }

    public double getAmount() {
        return amount;
    }

    public Transaction setAmount(double amount) {
        this.amount = amount;
        return this;
    }
}
