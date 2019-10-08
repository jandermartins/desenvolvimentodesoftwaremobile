package br.ufc.crateus.shoproute;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Cadastro extends AppCompatActivity {

    EditText etName, eTEmail, eTPass, etTel, etCpf;
    Button btCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        etName = (EditText) findViewById(R.id.etName);
        eTEmail= (EditText) findViewById(R.id.eTEmail);
        eTPass = (EditText) findViewById(R.id.eTPass);
        etTel = (EditText) findViewById(R.id.etTel);
        etCpf = (EditText) findViewById(R.id.etCPf);

        btCadastro = (Button) findViewById(R.id.btCadastro);

        btCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Cadastro.this, MenuPrincipal.class);
                startActivity(intent);
            }
        });
    }
}
