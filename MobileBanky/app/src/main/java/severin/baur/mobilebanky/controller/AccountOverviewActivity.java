package severin.baur.mobilebanky.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import severin.baur.mobilebanky.R;
import severin.baur.mobilebanky.model.dao.AccountDao;
import severin.baur.mobilebanky.model.entity.Account;
import severin.baur.mobilebanky.model.persitance.AppDatabase;

public class AccountOverviewActivity extends AppCompatActivity {

    private Account account;

    private TextView balance;
    private TextView iban;
    private TextView name;
    private ImageButton logoutButton;
    private Button makePaymentButton;
    private Button myTransactionsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_overview);
        AccountDao accountDao = AppDatabase.getAppDb(getApplicationContext()).getAccountDao();
        account = accountDao.getAccountById(getIntent().getExtras().getInt("accountId"));
        findItems();
        setupItems();
    }

    private void findItems(){
        balance = findViewById(R.id.balance);
        iban = findViewById(R.id.iban);
        name = findViewById(R.id.accountoverview_name);
        logoutButton = findViewById(R.id.logoutButton);
        makePaymentButton = findViewById(R.id.makepayment_button);
        myTransactionsButton = findViewById(R.id.mytransactions_button);
    }

    private void setupItems(){
        balance.setText(account.getBalance() + "CHF");
        iban.setText("IBAN: " + account.getIban());
        name.setText(account.getFullName());
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        makePaymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPaymentDialog();
            }
        });
        myTransactionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPaymentActivity(account.getId());
            }
        });
    }

    private void openPaymentActivity(int accountId){
        Bundle bundle = new Bundle();
        Intent intent = new Intent(this, PaymentActivity.class);
        intent.putExtra("accountId", accountId);
        startActivity(intent);
    }

    private void openPaymentDialog(){
        PaymentDialog paymentDialog = new PaymentDialog(account.getId());
        paymentDialog.show(getSupportFragmentManager(), "payment dialog");
    }
}
