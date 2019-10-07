package br.ufc.crateus.pratica2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SegundaActivity extends AppCompatActivity {
    Button button;
    Button next;
    RecyclerView recycler2;
    LineAdapter mAdapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        button = (Button) findViewById(R.id.button3);
        next = (Button) findViewById(R.id.btNext);
        recycler2 = (RecyclerView) findViewById(R.id.recycler2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycler2.setLayoutManager(layoutManager);
        mAdapter2 = new LineAdapter(new ArrayList<>(0));
        recycler2.setAdapter(mAdapter2);
        next.setVisibility(View.INVISIBLE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Service service = RetrofitClientInstance.getRetrofitInstance().create(Service.class);
                Call<List<Model>> callGetAll = service.getUsers();
                callGetAll.enqueue(new Callback<List<Model>>() {
                    @Override
                    public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                        for (Model user : response.body()) {
                            mAdapter2.insertItem(user.getNome(), user.getEmail());
                            Log.i("GET ALL", user.toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Model>> call, Throwable t) {
                    }

                });
            next.setVisibility(View.VISIBLE);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TerceiraActivity.class);
                startActivity(intent);
            }
        });
    }
}
