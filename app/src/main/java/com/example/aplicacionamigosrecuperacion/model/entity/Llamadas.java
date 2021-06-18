package com.example.aplicacionamigosrecuperacion.model.entity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "llamadas")
public class Llamadas {

    @PrimaryKey(autoGenerate = true)
    public int idLlamadas;

    @NonNull
    @ColumnInfo
    public int idAmigo;

    @Nullable
    @ColumnInfo
    public String fechaLlamada;

    public Llamadas() { this(0, ""); }

    public Llamadas(int idAmigo, @Nullable String fechaLlamada) {
        this.idAmigo = idAmigo;
        this.fechaLlamada = fechaLlamada;
    }

    public int getIdLlamadas() {
        return idLlamadas;
    }

    public void setIdLlamadas(int idLlamadas) {
        this.idLlamadas = idLlamadas;
    }

    public int getIdAmigo() {
        return idAmigo;
    }

    public void setIdAmigo(int idAmigo) {
        this.idAmigo = idAmigo;
    }

    @Nullable
    public String getFechaLlamada() {
        return fechaLlamada;
    }

    public void setFechaLlamada(@Nullable String fechaLlamada) {
        this.fechaLlamada = fechaLlamada;
    }

    @Override
    public String toString() {
        return "Llamadas{" +
                "idLlamadas=" + idLlamadas +
                ", idAmigo=" + idAmigo +
                ", fechaLlamada='" + fechaLlamada + '\'' +
                '}';
    }
}
