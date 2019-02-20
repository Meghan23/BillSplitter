package com.example.billsplitter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;

public class input_dialog extends AppCompatDialogFragment {
    int a, b ;
    private input_dialogListener listener;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder build = new AlertDialog.Builder(getActivity());
        LayoutInflater inf = getActivity().getLayoutInflater();
        Bundle bu = getArguments();
        String pa = bu.getString("pa");
        String pb = bu.getString("pb");
        final View view = inf.inflate(R.layout.input_dialogue, null);
        final CheckBox chk1 = view.findViewById(R.id.chk1);
        chk1.setText(pa);
        final CheckBox chk2 = view.findViewById(R.id.chk2);
        chk2.setText(pb);
        build.setView(view)
                .setTitle("Assign this dish to : ")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(chk1.isChecked())
                            a = 1;
                        if(chk2.isChecked())
                            b = 1;
                        listener.applyChanges(a,b);
                    }
                });
        return build.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            listener = (input_dialogListener) context;
        }
        catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "must implement inputdialoglistener");
        }

    }

    public interface input_dialogListener{
        void applyChanges(int a, int b);
    }
}
