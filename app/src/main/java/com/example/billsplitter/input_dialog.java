package com.example.billsplitter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import java.util.ArrayList;

public class input_dialog extends AppCompatDialogFragment {

    private input_dialogListener listener;
    private RecyclerView personRecyc;
    private DialogAdapter diAdapt;
    private ArrayList<Person> perData = new ArrayList<>();
    private int pos;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder build = new AlertDialog.Builder(getActivity());
        LayoutInflater inf = getActivity().getLayoutInflater();
        View view = inf.inflate(R.layout.input_dialogue, null);
        personRecyc = view.findViewById(R.id.personRecycler);
        personRecyc.setHasFixedSize(true);
        perData  = (ArrayList<Person>) getArguments().getSerializable("PerData");
        pos = getArguments().getInt("pos");
        personRecyc.setLayoutManager(new LinearLayoutManager(getContext()));
        diAdapt = new DialogAdapter(getContext(), perData);
        personRecyc.setAdapter(diAdapt);

        build.setView(view)
                .setTitle("Assign to : ")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        listener.applyChanges(diAdapt.fetchAssigned());
                    }
                });
        return build.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (input_dialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement inputdialoglistener");
        }

    }

    public interface input_dialogListener {
        void applyChanges(ArrayList<Integer> assigned);
    }
}
