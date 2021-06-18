package com.example.aplicacionamigosrecuperacion.model.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.aplicacionamigosrecuperacion.model.entity.Amigo;

import java.util.List;

@Dao
public interface AmigoDao {

    @Query("delete from amigos")
    void deleteAll();

    @Query("select * from amigos where id = :id")
    Amigo get(int id);

    @Insert
    void insert(Amigo agenda);

    @Update
    void update(Amigo agenda);

    @Delete
    void delete(Amigo agenda);

    @Query("delete from amigos where id = :id")
    void deleteMio(int id);

    @Query("select id from amigos where telefono = :num")
    int getNumero(String num);

    @Query("select * from amigos")
    LiveData<List<Amigo>> getAllLive();
}
