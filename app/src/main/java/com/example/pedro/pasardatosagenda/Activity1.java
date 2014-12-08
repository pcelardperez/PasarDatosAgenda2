package com.example.pedro.pasardatosagenda;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;


public class Activity1 extends Activity{

    //ESTA SERÁ UNA NUEVA RAMA

    final ArrayList<Persona> agenda = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1);



        Button btnAñadir = (Button) findViewById(R.id.btnAñadir);
        btnAñadir.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                EditText txnombre = (EditText) findViewById(R.id.txtNombre);
                EditText txnumero = (EditText) findViewById(R.id.txtTelefono);

                String nombre = txnombre.getText().toString();
                int numero = Integer.parseInt(txnumero.getText().toString());


                agenda.add(new Persona(nombre, numero));

                txnombre.setText("");
                txnumero.setText("");

                showToast(nombre, numero);
            }
        });


        Button btnEditar = (Button) findViewById(R.id.btnEditar);
        btnEditar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Activity1.this, Activity2.class);

                EditText txnombreed = (EditText) findViewById(R.id.txtNombreEd);
                String editar = txnombreed.getText().toString();
                for(int i=0; i<agenda.size();i++){
                    if (editar.equals(agenda.get(i).getNombre())) {
                        Persona contacto = agenda.get(i);
                        intent.putExtra("contacto", contacto);
                        startActivityForResult(intent, 1);

                    }
                }


            }

        });

        Button btnBuscar = (Button) findViewById(R.id.btnBuscar);
        btnBuscar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                EditText txnombreed = (EditText) findViewById(R.id.txtNombreEd);
                EditText txnombre = (EditText) findViewById(R.id.txtNombre);
                EditText txtelefono = (EditText) findViewById(R.id.txtTelefono);

                String editar = txnombreed.getText().toString();


                for(int i=0; i<agenda.size();i++){
                    if (editar.equals(agenda.get(i).getNombre())) {
                        txnombre.setText(agenda.get(i).getNombre());
                        txtelefono.setText(Integer.toString(agenda.get(i).getTelefono()));

                    }
                }
            }

        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent datos){
        //Persona contacto = (Persona)datos.getIntent().getExtras().getSerializable("contacto");
        Persona contacto =(Persona) datos.getExtras().getSerializable("contacto");
        for(int i=0; i<agenda.size();i++){
            if(contacto.getNombre().equals(agenda.get(i).getNombre())||contacto.getTelefono()==agenda.get(i).getTelefono()){
                agenda.get(i).setNombre(contacto.getNombre());
                agenda.get(i).setTelefono(contacto.getTelefono());
            }
        }
    }

    protected void showToast(String nombre,int numero){
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        String añadido = getResources().getString(R.string.Añadido);
        String connumero = getResources().getString(R.string.conNumero);
        Toast toast = Toast.makeText(context,añadido+nombre+connumero+numero,duration);
        toast.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
