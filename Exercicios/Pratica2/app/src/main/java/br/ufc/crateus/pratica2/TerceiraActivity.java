package br.ufc.crateus.pratica2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TerceiraActivity extends AppCompatActivity {

    EditText name;
    EditText username;
    EditText profissao;
    EditText data;
    EditText email;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceira);
        name = (EditText) findViewById(R.id.etNome);
        username = (EditText) findViewById(R.id.etUserName);
        profissao = (EditText) findViewById(R.id.etProfissao);
        data = (EditText) findViewById(R.id.etData);
        email = (EditText) findViewById(R.id.etEmail);
        button = (Button) findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Service service = RetrofitClientInstance.getRetrofitInstance().create(Service.class);
                UserModel2 userModel = new UserModel2(name.getText().toString(), email.getText().toString(), profissao.getText().toString(), username.getText().toString(), data.getText().toString());
                Call<List<UserModel2>> callUsers = service.postUser(userModel);
                callUsers.enqueue(new Callback<List<UserModel2>>() {
                    @Override
                    public void onResponse(Call<List<UserModel2>> call, Response<List<UserModel2>> response) {
                        Log.i("Post", response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<List<UserModel2>> call, Throwable t) {

                    }
                });
            }
        });
    }
}
