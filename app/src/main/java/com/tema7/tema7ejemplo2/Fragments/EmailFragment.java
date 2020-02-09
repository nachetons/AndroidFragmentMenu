package com.tema7.tema7ejemplo2.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tema7.tema7ejemplo2.R;

public class EmailFragment extends Fragment {
    private EditText nameEditText;
    private AlertDialog.Builder builder;
    private TextView display;
    private EditText editTextmail;

    public EmailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_email,container,false);



        FloatingActionButton btndiag= (FloatingActionButton) view.findViewById(R.id.btn);
        final TextView display=(TextView)view.findViewById(R.id.display);
        btndiag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                builder = new AlertDialog.Builder(getContext());
                builder.setTitle("EMAIL");
                builder.setMessage("\n"+"Escriba su direccion de correo");

                editTextmail=new EditText(getContext());
                editTextmail.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);

                builder.setView(editTextmail);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {


                    public void  onClick(DialogInterface dialog,int which){
                        int contador = 0;
                        String correo=editTextmail.getText().toString();
                        for (int i = 0; i < correo.length(); i++) {
                            if (correo.charAt(i)=='@' || correo.charAt(i)=='.') {
                                contador = contador + 1;
                            }

                        }
                        if (contador == 2) {
                            display.setText(correo);

                        } else {
                            Toast.makeText(getContext(), "Correo introducido no valido", Toast.LENGTH_SHORT).show();
                        }
                    }

                });
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener(){
                    public  void  onClick(DialogInterface dialog,int which){

                    }
                });
                builder.show();



            }
        });
            /*btndiag.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
            builder = new AlertDialog.Builder(getContext());
                builder.setTitle("EMAIL");
                builder.setMessage("\n"+"Escriba su direccion de correo");


                editTextmail=new EditText(getContext());


                editTextmail.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(editTextmail);


                builder.setPositiveButton("OK", (DialogInterface.OnClickListener) getContext());

                builder.setNegativeButton("Cancelar", (DialogInterface.OnClickListener) getContext());

                builder.show();
            }
        });*/
        return view;
    }





}