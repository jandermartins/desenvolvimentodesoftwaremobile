package br.ufc.crateus.bancodedados.app;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import br.ufc.crateus.bancodedados.dao.UsuarioDao;
import br.ufc.crateus.bancodedados.model.Usuario;

@Database(entities = {Usuario.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UsuarioDao usuarioDao();
}
