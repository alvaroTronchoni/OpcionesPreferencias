package alvaro.pm.opcionespreferencias;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Pantalla1 extends AppCompatActivity {

    private RelativeLayout layout;
    private TextView texto;
    private TextView email;
    private TextView nombre;
    private TextView apellidos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);

        layout = (RelativeLayout) findViewById(R.id.rl);
        texto  = (TextView) findViewById(R.id.ejemplo);
        email = (TextView) findViewById(R.id.email);
        nombre = (TextView) findViewById(R.id.nombre);
        apellidos = (TextView) findViewById(R.id.apellidos);

        comprovarPrefs();
    }

    @Override
    protected void onResume() {
        super.onResume();
        comprovarPrefs();
    }

    public void comprovarPrefs(){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        if(pref != null){
            switch (pref.getString("colorFondo","")){
                case "rojo":
                    layout.setBackgroundColor(getResources().getColor(R.color.rojo));
                    break;
                case "amarillo":
                    layout.setBackgroundColor(getResources().getColor(R.color.amarillo));
                    break;
                case "verde":
                    layout.setBackgroundColor(getResources().getColor(R.color.verde));
                    break;
            }
            switch (pref.getString("colorLetra","")){
                case "blanco":
                    texto.setTextColor(getResources().getColor(R.color.blanco));
                    break;
                case "negro":
                    texto.setTextColor(getResources().getColor(R.color.negro));
                    break;
                case "azul":
                    texto.setTextColor(getResources().getColor(R.color.azul));
                    break;
            }

            email.setText(pref.getString("email",""));
            nombre.setText(pref.getString("nombre",""));
            apellidos.setText(pref.getString("apellidos",""));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.confi:
                abrirPref();
                return true;
            default:
                return false;
        }
    }

    public void abrirPref(){
        Intent i = new Intent(Pantalla1.this,Preferencias.class);
        startActivity(i);
    }


}
