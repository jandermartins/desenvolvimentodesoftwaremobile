package br.ufc.crateus.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserService {
    @GET("/users")
    Call<List<UserModel>> getUsers();

    @GET("/users/{id}")
    Call<UserModel> getUser(@Path("id") Integer id);

    @POST("/users")
    Call<UserModel> postUser(@Body UserModel user);

    @PUT("/users/{id}")
    Call<UserModel> putUser(@Body UserModel user);

    @DELETE("/users/{id}")
    Call<UserModel> deleteUser(@Path("id") Integer id);
}
