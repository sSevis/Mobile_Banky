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

    public void setId(int id) {
        this.id = id;
    }

    public Account getSendAccount() {
        return sendAccount;
    }

    public Account getReceiveAccount() {
        return receiveAccount;
    }

    public double getAmount() {
        return amount;
    }

    public void setSendAccount(Account sendAccount) {
        this.sendAccount = sendAccount;
    }

    public void setReceiveAccount(Account receiveAccount) {
        this.receiveAccount = receiveAccount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
