package br.ufc.crateus.retrofit;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    UserService userService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userService = RetrofitClientInstance.getRetrofitInstance().create(UserService.class);

        Call<List<UserModel>> listCall = userService.getUsers();
        Call<UserModel> userModelCall = userService.getUser(5);
        Call<UserModel> modelCall = userService.postUser(new UserModel(-1, "jander", "jandermartins"));
        Call<UserModel> putCall = userService.putUser(new UserModel(3, "tututur", "tatata"));
        Call<UserModel> deleteCall = userService.deleteUser(2);

        deleteCall.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                Log.i("Delete", response.body().toString());
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {

            }
        });

        putCall.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                Log.i("Edit", response.body().toString());
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {

            }
        });

        modelCall.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                Log.i("Post", response.body().toString());
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {

            }
        });

        userModelCall.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                Log.i("Main ID 5", response.body().toString());
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {

            }
        });

        listCall.enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                Log.i("Main Todos", response.body().toString());
            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {

            }
        });
    }
}
