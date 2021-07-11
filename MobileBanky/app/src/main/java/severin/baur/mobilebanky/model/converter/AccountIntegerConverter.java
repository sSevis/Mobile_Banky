package severin.baur.mobilebanky.model.converter;

import androidx.room.ProvidedTypeConverter;
import androidx.room.TypeConverter;

import severin.baur.mobilebanky.MainActivity;
import severin.baur.mobilebanky.model.dao.AccountDao;
import severin.baur.mobilebanky.model.entity.Account;
import severin.baur.mobilebanky.model.persitance.AppDatabase;

@ProvidedTypeConverter
public class AccountIntegerConverter {
    @TypeConverter
    public static Integer AccountToInteger(Account account){
        return account.getId();
    }

    @TypeConverter
    public static Account IntegerToAccount(Integer id){
        AccountDao accountDao = AppDatabase.getAppDb(MainActivity.applicationContext).getAccountDao();
        return accountDao.getAccountById(id);
    }
}
