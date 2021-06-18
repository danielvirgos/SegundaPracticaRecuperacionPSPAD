package com.example.aplicacionamigosrecuperacion.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.aplicacionamigosrecuperacion.model.entity.Llamadas;

import java.util.List;

@Dao
public interface LlamadaDao {

    @Query("delete from llamadas")
    void deleteAll();

    @Query("select * from llamadas where idLlamadas = :id")
    Llamadas get(int id);

    @Insert
    void insert(Llamadas llamada);

    @Update
    void update(Llamadas llamada);

    @Delete
    void delete(Llamadas llamada);

    @Query("delete from llamadas where idLlamadas = :id")
    void deleteMio(int id);

    @Query("select * from llamadas")
    LiveData<List<Llamadas>> getAllLive();

    /*@Query("select amigos.*, count(llamadas.idLlamadas) from amigos left join llamadas on amigos.id = llamadas.idAmigo " +
            "group by amigos.id, amigos.telefono, amigos.nombre,amigos.fechaNac order by llamadas.fechaLlamada")
    LiveData<List<NumeroLlamadas>> getAllNumeroLlamadas();*/
}
