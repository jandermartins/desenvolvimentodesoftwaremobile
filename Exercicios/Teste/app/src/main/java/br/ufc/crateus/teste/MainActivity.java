package br.ufc.crateus.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    UserService userService;

    EditText etNome, etLogin, etEmail, etSenha;
    Button btCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCadastrar = (Button) findViewById(R.id.btCadastrar);

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userService = RetrofitClientInstance.getRetrofitInstance().create(UserService.class);

                etNome = (EditText) findViewById(R.id.etNome);
                etEmail = (EditText) findViewById(R.id.etEmail);
                etLogin = (EditText) findViewById(R.id.etLogin);
                etSenha = (EditText) findViewById(R.id.etSenha);




                UsuarioModel usuarioModel = new UsuarioModel();
                usuarioModel.setNome(etNome.getText().toString());
                usuarioModel.setEmail(etEmail.getText().toString());
                usuarioModel.setLogin(etLogin.getText().toString());
                usuarioModel.setSenha(etSenha.getText().toString());



                Call<List<UsuarioModel>> usuarioPost = userService.postUsuario(usuarioModel);
                usuarioPost.enqueue(new Callback<List<UsuarioModel>>() {
                    @Override
                    public void onResponse(Call<List<UsuarioModel>> call, Response<List<UsuarioModel>> response) {

                    }

                    @Override
                    public void onFailure(Call<List<UsuarioModel>> call, Throwable t) {

                    }
                });

            }
        });


    }
}
