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
    String largo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);
        final Persona contacto = (Persona) getIntent().getExtras().getSerializable("contacto");

        final EditText txnombreed = (EditText) findViewById(R.id.txtNombreEd);
        final EditText txnumeroed = (EditText) findViewById(R.id.txtTelefonoEd);

        txnombreed.setText(contacto.getNombre());
        largo = contacto.getNombre().toString();
        txnumeroed.setText(Integer.toString(contacto.getTelefono()));

        showToast();

        Button btnOk = (Button) findViewById(R.id.btnOK);
        btnOk.setOnClickListener(new View.OnClickListener() {
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

        Button btnBorrar = (Button) findViewById(R.id.btnBorrar);
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = txnombreed.getText().toString();
                int tel = Integer.parseInt(txnumeroed.getText().toString());
                Persona p = new Persona(nom, tel);
                Intent intent = new Intent(Activity2.this, ActivityBorrar.class);
                Bundle reci = new Bundle();
                reci.putString("largo", largo);
                reci.putSerializable("contacto", p);
                intent.putExtras(reci);
                startActivityForResult(intent, 1);
            }
        });
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK) {
            setResult(1,data);
            finish();
        }
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
