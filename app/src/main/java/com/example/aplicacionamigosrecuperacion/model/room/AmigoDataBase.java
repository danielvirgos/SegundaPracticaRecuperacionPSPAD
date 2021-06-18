package com.example.aplicacionamigosrecuperacion.model.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.aplicacionamigosrecuperacion.model.dao.AmigoDao;
import com.example.aplicacionamigosrecuperacion.model.dao.LlamadaDao;
import com.example.aplicacionamigosrecuperacion.model.entity.Amigo;
import com.example.aplicacionamigosrecuperacion.model.entity.Llamadas;

@Database(entities = {Amigo.class, Llamadas.class}, version = 4, exportSchema = false)
public abstract class AmigoDataBase extends RoomDatabase {

    public abstract AmigoDao getAmigoDao();
    public abstract LlamadaDao getLlamadaDao();

    private volatile static AmigoDataBase INSTANCE;

    public static AmigoDataBase getDb(final Context context) {
        if(INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AmigoDataBase.class, "dbamigos").fallbackToDestructiveMigration().build();
        }
        return INSTANCE;
    }
}
