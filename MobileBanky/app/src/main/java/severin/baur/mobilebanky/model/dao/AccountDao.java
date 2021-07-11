package severin.baur.mobilebanky.model.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import severin.baur.mobilebanky.model.entity.Account;

@Dao
public interface AccountDao {
    @Query("SELECT * FROM account Where id = :accountId")
    Account getAccountById(int accountId);

    @Query("SELECT * FROM account WHERE email = :email")
    Account getAccountByEmail(String email);

    @Insert
    Long insert(Account account);

    @Query("SELECT * FROM account WHERE iban = :iban")
    Account getAccountByIban(String iban);
}
