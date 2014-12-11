package com.example.pedro.pasardatosagenda;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class Activity3 extends ListActivity {

    ArrayList<Persona> agenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3);
        agenda = (ArrayList<Persona>) getIntent().getSerializableExtra("array");
        setListAdapter(new ArrayAdapter<Persona>(this, android.R.layout.simple_list_item_1, agenda));
    }


    public void onListItemClick(ListView parent, View v, int posicion, long id){
        Intent i = new Intent(Activity3.this, ActivityBorrar.class);
        i.putExtra("contacto", agenda.get(posicion));
        startActivityForResult(i, 1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        /*if (resultCode == RESULT_OK) {
            Persona person = (Persona) data.getExtras().getSerializable("contacto");
            String nombre = data.getExtras().getString("largo");
            for (Persona p1 : agenda) {
                if (p1.getNombre().toString().equalsIgnoreCase(nombre)) {
                    p1.setNombre(person.getNombre().toString());
                    p1.setTelefono(person.getTelefono());
                }
            }

            Intent i = new Intent();
            i.putExtra("array", agenda);
            setResult(RESULT_OK, i);
            finish();
        }
        */
        if (resultCode ==RESULT_OK) {
            Persona person = (Persona) data.getExtras().getSerializable("contacto");
            String nombre = data.getExtras().getString("largo");
            for (Persona p1 : agenda) {
                if (p1.getNombre().toString().equalsIgnoreCase(nombre)) {
                    agenda.remove(p1);
                }
            }
            Intent i = new Intent();
            i.putExtra("array", agenda);
            setResult(RESULT_OK, i);
            finish();

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity3, menu);
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
