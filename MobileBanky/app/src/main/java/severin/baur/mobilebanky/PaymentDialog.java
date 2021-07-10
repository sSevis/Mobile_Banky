package severin.baur.mobilebanky;

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

public class PaymentDialog extends AppCompatDialogFragment {
//    private TextInputEditText editTextAmount;
//    private TextInputEditText editTextName;
//    private TextInputEditText editTextIban;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.payment_dialog, null);
        View titleView = inflater.inflate(R.layout.custom_title, null);
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

            }
        });
//        editTextAmount = view.findViewById(R.id.edit_iban);
//        editTextName = view.findViewById(R.id.edit_iban);
//        editTextIban = view.findViewById(R.id.edit_iban);
                return builder.create();
    }
}
