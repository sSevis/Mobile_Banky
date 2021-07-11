package severin.baur.mobilebanky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import severin.baur.mobilebanky.model.dao.AccountDao;
import severin.baur.mobilebanky.model.entity.Account;
import severin.baur.mobilebanky.model.persitance.AppDatabase;

public class MainActivity extends AppCompatActivity {

    private AccountDao accountDao;
    public static Context applicationContext;

    private TextInputEditText email;
    private TextInputEditText password;
    private Button loginButton;
    private TextView registerText;
    private TextView errorText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        applicationContext = getApplicationContext();
        accountDao = AppDatabase.getAppDb(getApplicationContext()).getAccountDao();
        insertTestData();
        findItems();
        setupItems();
    }

    private void findItems(){
        email = findViewById(R.id.login_email);
        password = findViewById(R.id.login_password);
        loginButton = findViewById(R.id.loginButton);
        registerText = findViewById(R.id.registration_text);
        errorText = findViewById(R.id.error_text);
    }

    private void setupItems(){
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegisterActivity();
            }
        });
    }

    private void insertTestData(){
        Account account = new Account();
        account.setFullName("John Doe");
        account.setEmail("john.doe@gmail.com");
        account.setPassword("pwd");
        account.setIban("CH4189144542383422238");
        account.setBalance(10000);
        accountDao.insert(account);
    }

    private void loginUser(){
        Account account = accountDao.getAccountsByEmail(email.getText().toString());
        if(account.getPassword().equals(password.getText().toString())){
            errorText.setVisibility(View.INVISIBLE);
            openAccountOverviewActivity();
        }else{
            errorText.setVisibility(View.VISIBLE);
        }
    }

    private void openRegisterActivity(){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    private void openAccountOverviewActivity(){
        Intent intent = new Intent(this, AccountOverviewActivity.class);
        startActivity(intent);
    }

}