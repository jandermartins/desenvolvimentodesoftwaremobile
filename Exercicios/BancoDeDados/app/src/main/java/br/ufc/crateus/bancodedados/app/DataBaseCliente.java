package br.ufc.crateus.bancodedados.app;

import android.content.Context;

import androidx.room.Room;

public class DataBaseCliente{

    private static AppDatabase db;

    public static AppDatabase getInstance(Context context) {
        if(db == null) {
            db = Room.databaseBuilder(context,
                    AppDatabase.class, "database-name").allowMainThreadQueries().build();
        }
        return db;
    }
}
