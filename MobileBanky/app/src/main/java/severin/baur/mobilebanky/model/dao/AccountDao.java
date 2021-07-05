package severin.baur.mobilebanky.model.dao;

import androidx.room.Dao;
import androidx.room.Query;

import severin.baur.mobilebanky.model.entity.Account;

@Dao
public interface AccountDao {
    @Query("SELECT * FROM account Where id = :accountId")
    Account getAccountById(int accountId);

}
