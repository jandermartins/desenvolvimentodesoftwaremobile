package br.ufc.crateus.teste;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserService {

    @GET("/teste/usuario")
    Call<List<UsuarioModel>> getUsuarios();

    @GET("/teste/usuario/{id}")
    Call<UsuarioModel> getUsuario(@Path("id") Integer id);

    @POST("/teste/usuario")
    Call<List<UsuarioModel>> postUsuario(@Body UsuarioModel usuarioModel);

    @PUT("/teste/usuario/{id}")
    Call<UsuarioModel> editUsuario(@Path("id") Integer id);

    @DELETE("/teste/usuario/{id}")
    Call<UsuarioModel> deleteUsuario(@Path("id") Integer id);
}
