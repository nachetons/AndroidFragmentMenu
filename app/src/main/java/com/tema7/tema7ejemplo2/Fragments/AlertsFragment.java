package com.tema7.tema7ejemplo2.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tema7.tema7ejemplo2.Activities.MainActivity;
import com.tema7.tema7ejemplo2.R;

public class AlertsFragment extends Fragment{
    private AlertDialog.Builder builder;
    Switch mibtn;
    String seleccion;


    public AlertsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        final View view = inflater.inflate(R.layout.fragment_alerts,container,false);

        mibtn=(Switch)view.findViewById(R.id.miswitch);
        FloatingActionButton btndiag= (FloatingActionButton) view.findViewById(R.id.btnalert);
        //final Switch boton=(Switch)view.findViewById(R.id.miswitch);
        final TextView display=(TextView)view.findViewById(R.id.displayalert);


        btndiag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                builder = new AlertDialog.Builder(getContext());
                builder.setTitle("ALERTA");
                builder.setMessage("\n"+"Escriba su direccion de correo"+"\n"+"\n"+"\n"+"Habilitar/Deshabilitar alertas");

                LayoutInflater inflater1=getActivity().getLayoutInflater();
                final View dialogView = inflater1.inflate(R.layout.switch_nav_options,null);

                mibtn=(Switch)dialogView.findViewById(R.id.miswitch);


                builder.setView(dialogView);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
                    public  void  onClick(DialogInterface dialog,int which){
                        if (mibtn.isChecked()){
                            display.setText("Alerta Habilitada");
                        }else{
                            display.setText("Alerta Deshabilitada");
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
        return view;
    }

}