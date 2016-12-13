package com.example.rm31456.persistencia;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conectado();
    }

    public void logar(View v){
        String usuario = ((EditText) findViewById(R.id.edtLogin)).getText().toString();
        String senha = ((EditText) findViewById(R.id.edtSenha)).getText().toString();
        CheckBox cbManterConectado = (CheckBox) findViewById(R.id.cbManterConectado);

        if (usuario.equals("admi") && senha.equals("123")){
            salvarPreferencias(usuario, true);
            abrirTela();
        }


    }

    private void conectado(){
        SharedPreferences settings = getSharedPreferences("", MODE_PRIVATE);

        if (settings.getBoolean("manterConectado",false)){
            abrirTela();
        }
    }

    private void salvarPreferencias(String usuario, boolean isChecked){

        SharedPreferences settings = getSharedPreferences("", MODE_PRIVATE);

        SharedPreferences.Editor editor = settings.edit();
        editor.putString("usuario", usuario);
        editor.putBoolean("manterConectado", isChecked);
        editor.commit();

    }

    private void abrirTela(){
        startActivity(new Intent(this, LivrosActivity.class));
        finish();
    }
}
