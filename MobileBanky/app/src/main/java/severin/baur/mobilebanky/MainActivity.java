package severin.baur.mobilebanky;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.os.Bundle;

import severin.baur.mobilebanky.model.persitance.AppDatabase;

public class MainActivity extends AppCompatActivity {

    public static Context applicationContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        applicationContext = getApplicationContext();
    }
}