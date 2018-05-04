package com.example.fatima.cmus;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

public class menu_pantalla extends AppCompatActivity {

    GridLayout mainGrid;  //esta linea es para agregar el evento Onclick en cada una de las opciones del menu

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pantalla);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mainGrid = (GridLayout) findViewById(R.id.mainGrid);  //esta es una sub clase estamos llamando a la clase principal por decirlo asi
        setSingleEvent();   // este es un evento

    }

    private void setSingleEvent() {
        //estos son los item
        for (int i = 0; i < mainGrid.getChildCount(); i++)
        {
            CardView cardView = (CardView)mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //Toast.makeText(menu.this, "click", Toast.LENGTH_SHORT).show(); para visualizar un texto al hacer click agregado por curiosidad
                    //estas son las opciones del menu
                    if (finalI == 0) //es para abrir ingresar los datos
                    {
                        Intent intent = new Intent(menu_pantalla.this,ingresardatos.class); //menu es el activity uno, ingresar datos es donde vamos a ingrear
                        startActivity(intent);
                    }

                    else if (finalI == 1)
                    {
                        Intent intent = new Intent(menu_pantalla.this,buscardatos.class);
                        startActivity(intent);
                    }

                    else if (finalI == 2)
                    {
                        Intent intent = new Intent(menu_pantalla.this,limpiardatos.class);
                        startActivity(intent);
                    }

                    else if (finalI == 3)
                    {
                        Intent intent = new Intent(menu_pantalla.this,Sincronizar.class);
                        startActivity(intent);
                    }

                    else if (finalI == 4)
                    {
                        AlertDialog.Builder dialog= new AlertDialog.Builder(menu_pantalla.this, R.style.color_text);
                        dialog.setIcon(R.mipmap.sicronizar);
                        dialog.setTitle(Html.fromHtml("<font color ='#00BFFF'>Sincronizar Usuarios</font> "));
                        dialog.setMessage("¿Desea continuar con la sincronización?");
                        dialog.setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(menu_pantalla.this,"Sincronización realizada con éxito",Toast.LENGTH_LONG).show();

                            }
                        });
                        dialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();

                            }
                        });
                        AlertDialog alertDialog = dialog.create();
                        alertDialog.show();

                    }

                }
            });

        }


    }


    //para abrir sincronizar datos con cuadro de dialogo

  /*  public void abre_dialogousu (View v){

        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle(R.string.sincronizar_usuarios );
        builder.setMessage(R.string.sincro_usu);
        builder.setPositiveButton(R.string.si, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(menu.this, R.string.continuar, Toast.LENGTH_SHORT).show();

            }
        });

        builder.setNegativeButton(android.R.string.no, null); // aqui falta listener null
        Dialog dialog =builder.create();
        dialog.show();


    }*/



}
