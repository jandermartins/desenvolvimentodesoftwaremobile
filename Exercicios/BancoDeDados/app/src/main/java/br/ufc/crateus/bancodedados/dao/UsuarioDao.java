package br.ufc.crateus.bancodedados.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.ufc.crateus.bancodedados.model.Usuario;

@Dao
public interface UsuarioDao {


    @Query("SELECT * FROM usuario")
    List<Usuario> getAll();

    @Query("SELECT * FROM Usuario WHERE id IN (:UsuarioIds)")
    List<Usuario> loadAllByIds(int[] UsuarioIds);

    @Query("SELECT * FROM Usuario WHERE id = :UsuarioId")
    Usuario getById(int UsuarioId);

    @Query("SELECT * FROM Usuario WHERE primeiro_nome LIKE :first AND " +
            "segundo_nome LIKE :last LIMIT 1")
    Usuario findByName(String first, String last);

    @Insert
    void insertAll(Usuario... Usuarios);

    @Insert
    void insert(Usuario Usuario);

    @Delete
    void delete(Usuario Usuario);

    @Update
    void update(Usuario Usuario);
}
