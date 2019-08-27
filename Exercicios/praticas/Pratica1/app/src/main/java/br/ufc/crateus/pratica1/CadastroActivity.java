package br.ufc.crateus.pratica1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class CadastroActivity extends AppCompatActivity {

    final String[] profissoes = {"Professor","Estudante", "Pedreiro", "Engenheiro"};

    EditText etIdade, etNome, etEmail, etGenero;
    Spinner spProfissão;
    CheckBox cbConcordo;
    Button btCadastrar;

    String profissao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        etIdade = (EditText) findViewById(R.id.etIdade);
        etNome = (EditText) findViewById(R.id.etNome);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etGenero = (EditText) findViewById(R.id.etGenero);
        btCadastrar = (Button) findViewById(R.id.btCadastrar);
        spProfissão = (Spinner) findViewById(R.id.spProfissão);
        cbConcordo = (CheckBox) findViewById(R.id.cbConcordo);

        ArrayAdapter<String> aa = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, profissoes);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spProfissão.setAdapter(aa);

        spProfissão.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                profissao = profissoes[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://almada-mobile.herokuapp.com/api/users/add" + "?nome" + etNome.getText().toString() + "&email" + etEmail.getText().toString() + "&profissao" + profissao.toString() + "&idade" + etIdade.getText().toString() + "&genero" + etGenero.getText().toString()));
                startActivity(intent);
            }
        });

    }
}
