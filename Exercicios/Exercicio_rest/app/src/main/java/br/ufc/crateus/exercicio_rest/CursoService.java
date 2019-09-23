package br.ufc.crateus.exercicio_rest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CursoService {

    @GET("/api/cursos")
    Call<List<CursoModel>> getCursos();

    @GET("/api/cursos/{id}")
    Call<List<CursoModel>> getCurso(@Path("id") Integer id);

    @POST("/api/cursos")
    Call<List<CursoModel>> postCurso(@Body CursoModel cursoModel);

    @PUT("/api/cursos/{id}")
    Call<List<CursoModel>> editCurso(@Path("id") Integer id);

    @DELETE("/api/cursos/{id}")
    Call<List<CursoModel>> deleteCurso(@Path("id") Integer id);

}
