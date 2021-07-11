package severin.baur.mobilebanky.controller;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.google.android.material.textfield.TextInputEditText;

import severin.baur.mobilebanky.R;
import severin.baur.mobilebanky.model.dao.AccountDao;
import severin.baur.mobilebanky.model.dao.TransactionDao;
import severin.baur.mobilebanky.model.entity.Account;
import severin.baur.mobilebanky.model.entity.Transaction;
import severin.baur.mobilebanky.model.persitance.AppDatabase;

public class PaymentDialog extends AppCompatDialogFragment {
    private int accountId;
    private AccountDao accountDao;
    private TransactionDao transactionDao;

   //private TextInputEditText editTextAmount;
   //private TextInputEditText editTextName;
   //private TextInputEditText editTextIban;
   private View view;
   private AlertDialog.Builder builder;
   private View titleView;

    public PaymentDialog(int accountId) {
        this.accountId = accountId;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        accountDao = AppDatabase.getAppDb(getContext()).getAccountDao();
        transactionDao = AppDatabase.getAppDb(getContext()).getTransactionDao();
        findItems();
        setupItems();
        return builder.create();
    }

    private void setupItems(){
        builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.payment_dialog, null);
        titleView = inflater.inflate(R.layout.custom_title, null);
        builder.setView(view)
                .setCustomTitle(titleView)
                .setNegativeButton("Abbrechen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Senden", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //insertTransaction(editTextIban.getText().toString(), Double.parseDouble(editTextAmount.getText().toString()));
                    }
                });
    }

    private void insertTransaction(String iban, double amount){
        Transaction transaction = new Transaction();
        Account receiveAccount = accountDao.getAccountByIban(iban);
        transaction.setReceiveAccount(receiveAccount);
        Account sendAccount = accountDao.getAccountById(accountId);
        transaction.setSendAccount(sendAccount);
        transaction.setAmount(amount);
        transactionDao.insert(transaction);
    }

    private void findItems(){
        //editTextAmount = view.findViewById(R.id.edit_iban);
        //editTextName = view.findViewById(R.id.edit_iban);
        //editTextIban = view.findViewById(R.id.edit_iban);
    }
}
