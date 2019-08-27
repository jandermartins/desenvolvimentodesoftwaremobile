package br.ufc.crateus.pratica1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaPrincipalActivity extends AppCompatActivity {

    final String login2 = "admin";
    final String senha2 = "1234";
    Button btCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        Intent intent = getIntent();
        String login = (String) intent.getStringExtra("login");
        String senha = (String) intent.getStringExtra("senha");
        btCadastrar = (Button) findViewById(R.id.btCadastrar);

        if(login.equals(login2) && senha.equals(senha2)){
            btCadastrar.setVisibility(View.VISIBLE);
            btCadastrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), CadastroActivity.class);
                    startActivity(intent);
                }
            });
        }
        else
            btCadastrar.setVisibility(View.INVISIBLE);
    }
}
