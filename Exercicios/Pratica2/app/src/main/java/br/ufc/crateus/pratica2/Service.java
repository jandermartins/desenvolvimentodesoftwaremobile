package br.ufc.crateus.pratica2;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface Service {
    @GET("/api/users/")
    Call<List<Model>> getUsers();

    @GET("/api/users/{name}")
    Call<List<Model>> getUser(@Path("name") String name);

    @POST("/api/users")
    Call<List<UserModel2>> postUser(@Body UserModel2 Model);

    @PUT("/api/users/{name}")
    Call<List<Model>> editUser(@Path("name") String name);

    @DELETE("/api/users/{name}")
    Call<List<Model>> deleteUser(@Path("name") String name);
}
