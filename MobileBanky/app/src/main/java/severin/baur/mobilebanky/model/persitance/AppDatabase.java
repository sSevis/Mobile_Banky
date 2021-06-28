package severin.baur.mobilebanky.model.persitance;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import severin.baur.mobilebanky.model.dao.TransactionDao;
import severin.baur.mobilebanky.model.entity.Account;
import severin.baur.mobilebanky.model.dao.AccountDao;
import severin.baur.mobilebanky.model.entity.Transaction;

@Database(entities = {Account.class, Transaction.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static final String DB_NAME = "MobileBankyDb";
    private static AppDatabase appDb;

    /**
     * @param context
     * @return
     */
    public static AppDatabase getAppDb(Context context) {
        if (appDb == null) {
            appDb = Room.databaseBuilder(context, AppDatabase.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return appDb;
    }

    public abstract AccountDao getAccountDao();

    public abstract TransactionDao getTransactionDao();
}
