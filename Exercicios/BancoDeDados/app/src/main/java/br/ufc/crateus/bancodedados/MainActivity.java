package br.ufc.crateus.bancodedados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import br.ufc.crateus.bancodedados.app.DataBaseCliente;
import br.ufc.crateus.bancodedados.dao.UsuarioDao;
import br.ufc.crateus.bancodedados.model.Usuario;


public class MainActivity extends AppCompatActivity {

    UsuarioDao usuarioDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuarioDao = DataBaseCliente.getInstance(this).usuarioDao();

        usuarioDao.insert(new Usuario("Jander", "Martins"));

        Log.i("Nome", usuarioDao.getAll().toString());
    }
}