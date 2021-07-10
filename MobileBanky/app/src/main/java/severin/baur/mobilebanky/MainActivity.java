package severin.baur.mobilebanky;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import severin.baur.mobilebanky.model.persitance.AppDatabase;

public class MainActivity extends AppCompatActivity {
private Button button;
    public static Context applicationContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        applicationContext = getApplicationContext();
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                openDialog();
            }
        });
    }
    public void openDialog(){
        PaymentDialog paymentDialog = new PaymentDialog();
        paymentDialog.show(getSupportFragmentManager(), "payment dialog");
    }

}