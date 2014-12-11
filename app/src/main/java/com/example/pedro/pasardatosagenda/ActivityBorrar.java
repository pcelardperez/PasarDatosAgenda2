package com.example.pedro.pasardatosagenda;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class ActivityBorrar extends Activity {
    String largo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_borrar);

        final EditText txnombreed = (EditText) findViewById(R.id.txtNombreEd);
        final EditText txnumeroed = (EditText) findViewById(R.id.txtTelefonoEd);
        final Persona contacto = (Persona)getIntent().getExtras().getSerializable("contacto");

        txnombreed.setText(contacto.getNombre());
        largo=contacto.getNombre().toString();
        txnumeroed.setText(Integer.toString(contacto.getTelefono()));


        Button btnOkBorrar = (Button) findViewById(R.id.btnOKBorrar);
        btnOkBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = txnombreed.getText().toString();
                int tel = Integer.parseInt(txnumeroed.getText().toString());
                Persona p = new Persona(nom, tel);
                Intent intent = new Intent();
                Bundle reci = new Bundle();
                reci.putString("largo", largo);
                reci.putSerializable("contacto", p);
                intent.putExtras(reci);

                setResult(RESULT_OK, intent);
                finish();

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_borrar, menu);
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
