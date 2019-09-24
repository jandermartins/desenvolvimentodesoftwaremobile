package br.ufc.crateus.aula_teste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.JsonArray;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SegundaTela extends AppCompatActivity {

    Button button, btProximo;
    UserService service;
    RecyclerView recyclerView;
    private LineAdapterUsuario lineAdapterUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);

        recyclerView = (RecyclerView) findViewById(R.id.rvUsuario);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        lineAdapterUsuario = new LineAdapterUsuario(new ArrayList<Usuario>(0));

        recyclerView.setAdapter(lineAdapterUsuario);

        button = (Button) findViewById(R.id.btOk);

         service = RetrofitClientInstance.getRetrofitInstance().create(UserService.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<List<Usuario>> getUsuario = service.getUsers();
                getUsuario.enqueue(new Callback<List<Usuario>>() {
                    @Override
                    public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {

                        for (int i = 0; i < response.body().size(); i++){

                            Usuario usuario = new Usuario(response.body().get(i));


                        }

                        lineAdapterUsuario.insertItem(response);

                    }

                    @Override
                    public void onFailure(Call<List<Usuario>> call, Throwable t) {

                    }
                });
            }
        });
    }
}
