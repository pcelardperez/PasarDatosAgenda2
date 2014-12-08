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


public class Activity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);
        final Persona contacto = (Persona)getIntent().getExtras().getSerializable("contacto");

        final EditText txnombreed = (EditText) findViewById(R.id.txtNombreEd);
        final EditText txnumeroed = (EditText) findViewById(R.id.txtTelefonoEd);

        txnombreed.setText(contacto.getNombre());
        txnumeroed.setText(Integer.toString(contacto.getTelefono()));

        showToast();

        Button btnOk = (Button) findViewById(R.id.btnOK);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contacto.setNombre(txnombreed.getText().toString());
                contacto.setTelefono(Integer.parseInt(txnumeroed.getText().toString()));
                Intent intent = new Intent();
                intent.putExtra("contacto",contacto);
                setResult(RESULT_OK,intent);
                finish();

            }
        });


    }

    protected void showToast(){
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        String edita = getResources().getString(R.string.ToastEdita);
        Toast toast = Toast.makeText(context,edita, duration);
        toast.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity2, menu);
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
