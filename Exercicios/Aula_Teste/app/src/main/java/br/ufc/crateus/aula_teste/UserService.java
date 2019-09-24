package br.ufc.crateus.aula_teste;

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
    Call<List<Usuario>> getUsers();

    @GET("/users/{id}")
    Call<Usuario> getUser(@Path("id") Integer id);

    @POST("/users")
    Call<Usuario> postUser(@Body Usuario user);

    @PUT("/users/{id}")
    Call<Usuario> putUser(@Body Usuario user, @Path("id") Integer id);

    @DELETE("/users/{id}")
    Call<Usuario> deleteUser(@Path("id") Integer id);
}
