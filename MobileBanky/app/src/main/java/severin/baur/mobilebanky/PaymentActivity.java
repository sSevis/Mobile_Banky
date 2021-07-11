package severin.baur.mobilebanky;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import severin.baur.mobilebanky.model.dao.AccountDao;
import severin.baur.mobilebanky.model.persitance.AppDatabase;

public class PaymentActivity extends AppCompatActivity {

    private AccountDao accountDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        accountDao = AppDatabase.getAppDb(getApplicationContext()).getAccountDao();
    }
}
