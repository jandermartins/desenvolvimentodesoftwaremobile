package br.ufc.crateus.exercicio_rest;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    CursoService cursoService;

    EditText etID, etNome, etDuracao;
    Button btOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etID = (EditText) findViewById(R.id.etID);
        etNome = (EditText) findViewById(R.id.etNome);
        etDuracao = (EditText) findViewById(R.id.etDuracao);
        btOk = (Button) findViewById(R.id.btOk);

        btOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cursoService = RetrofitClientInstance.getRetrofitInstance().create(CursoService.class);

                Integer id = Integer.parseInt(etID.getText().toString());
                String nome = etNome.getText().toString();
                Integer duracao = Integer.parseInt(etDuracao.getText().toString());



                CursoModel cursoModel = new CursoModel(id, nome, duracao);


                Call<List<CursoModel>> callCursos = cursoService.postCurso(cursoModel);
                callCursos.enqueue(new Callback<List<CursoModel>>() {
                    @Override
                    public void onResponse(Call<List<CursoModel>> call, Response<List<CursoModel>> response) {
                        Log.i("Post", response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<List<CursoModel>> call, Throwable t) {

                    }
                });

            }
        });




        Call<List<CursoModel>> listCall = cursoService.getCursos();

        listCall.enqueue(new Callback<List<CursoModel>>() {
            @Override
            public void onResponse(Call<List<CursoModel>> call, Response<List<CursoModel>> response) {
                Log.i("Post", response.body().toString());
            }

            @Override
            public void onFailure(Call<List<CursoModel>> call, Throwable t) {

            }
        });
    }
}
