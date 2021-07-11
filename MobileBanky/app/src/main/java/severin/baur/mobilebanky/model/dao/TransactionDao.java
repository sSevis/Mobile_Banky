package severin.baur.mobilebanky.model.dao;

import androidx.room.Dao;
import androidx.room.Insert;

import severin.baur.mobilebanky.model.entity.Transaction;

@Dao
public interface TransactionDao {
    @Insert
    Long insert(Transaction transaction);
}
