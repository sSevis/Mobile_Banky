package severin.baur.mobilebanky;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import severin.baur.mobilebanky.model.dao.AccountDao;
import severin.baur.mobilebanky.model.persitance.AppDatabase;

public class PaymentActivity extends AppCompatActivity {

    private AccountDao accountDao;
    private ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        accountDao = AppDatabase.getAppDb(getApplicationContext()).getAccountDao();
        backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}
