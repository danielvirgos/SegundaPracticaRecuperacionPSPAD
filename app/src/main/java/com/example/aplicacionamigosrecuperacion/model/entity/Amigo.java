package com.example.aplicacionamigosrecuperacion.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "amigos")
public class Amigo {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    @ColumnInfo(name = "nombre")
    private String nombre;

    @NonNull
    @ColumnInfo(name = "telefono")
    private String telefono;

    @NonNull
    @ColumnInfo(name = "fechaNac")
    private String fechaNac;

    public Amigo() {
        this("", "", "");
    }

    public Amigo(@NonNull String nm, @NonNull String tl) {
        this.nombre = nm;
        this.telefono = tl;
    }

    public Amigo(@NonNull String nm, @NonNull String tl, @NonNull String fn) {
        this.nombre = nm;
        this.telefono = tl;
        this.fechaNac = fn;
    }

    public int getId() {
        return id;
    }

    @NonNull
    public String getNombre() {
        return nombre;
    }

    @NonNull
    public String getTelefono() {
        return telefono;
    }

    @NonNull
    public String getFechaNac() {
        return fechaNac;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(@NonNull String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(@NonNull String telefono) {
        this.telefono = telefono;
    }

    public void setFechaNac(@NonNull String fechaNac) {
        this.fechaNac = fechaNac;
    }

    @Override
    public String toString() {
        return "Amigo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fechaNac='" + fechaNac + '\'' +
                '}';
    }
}
