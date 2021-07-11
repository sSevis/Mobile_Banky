package severin.baur.mobilebanky.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Random;

import severin.baur.mobilebanky.R;
import severin.baur.mobilebanky.model.dao.AccountDao;
import severin.baur.mobilebanky.model.entity.Account;
import severin.baur.mobilebanky.model.persitance.AppDatabase;

public class RegisterActivity extends AppCompatActivity{

    private AccountDao accountDao;

    private TextInputEditText name;
    private TextInputEditText email;
    private TextInputEditText password;
    private Button registerButton;
    private TextView loginText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        accountDao = AppDatabase.getAppDb(getApplicationContext()).getAccountDao();
        findItems();
        setupItems();
    }

    private void findItems(){
        name = findViewById(R.id.register_name);
        email = findViewById(R.id.register_email);
        password = findViewById(R.id.register_password);
        registerButton = findViewById(R.id.register_button);
        loginText = findViewById(R.id.login_text);
    }

    private void setupItems(){
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });
    }

    private void register(){
        Account account = new Account();
        account.setFullName(name.getText().toString());
        account.setEmail(email.getText().toString());
        account.setPassword(password.getText().toString());
        account.setIban(generateIban());
        account.setBalance(0);
        int id = accountDao.insert(account).intValue();
        openAccountOverviewActivity(id);
    }

    private String generateIban(){
        Random random = new Random();
        String iban = "CH";
        for (int i = 0; i<19;i++){
            iban += Integer.toString(random.nextInt(10));
        }
        return iban;
    }

    private void openAccountOverviewActivity(int accountId){
        Bundle bundle = new Bundle();
        Intent intent = new Intent(this, AccountOverviewActivity.class);
        intent.putExtra("accountId", accountId);
        startActivity(intent);
    }

    private void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
