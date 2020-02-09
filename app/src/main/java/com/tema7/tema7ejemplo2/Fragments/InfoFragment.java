package com.tema7.tema7ejemplo2.Fragments;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tema7.tema7ejemplo2.R;

public class InfoFragment extends Fragment {
    private AlertDialog.Builder builder;

    public InfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info,container,false);



        FloatingActionButton btndiag= (FloatingActionButton) view.findViewById(R.id.btn);
        btndiag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Informacion");
                builder.setMessage("\n"+"Este dialogo de alerta es solo para mostrar mensaje informativo" +
                        " normal al usuario, nada con lo que interactuar");



                builder.setPositiveButton("Entendido", new DialogInterface.OnClickListener() {


                    public void  onClick(DialogInterface dialog,int which){




                    }
                });
                builder.show();



            }
        });
        return view;
    }

}