package com.example.aplicacionamigosrecuperacion.model.entity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

public class NumeroLlamadas {

    @Embedded
    Amigo a;

    long cont;

    public Amigo getA() {
        return a;
    }

    public long getCont() {
        return cont;
    }

    public void setA(Amigo a) {
        this.a = a;
    }

    public void setCont(long cont) {
        this.cont = cont;
    }

    @Override
    public String toString() {
        return "NumeroLlamadas{" +
                "a=" + a +
                ", cont=" + cont +
                '}';
    }

    public NumeroLlamadas(Amigo a, long cont) {
        this.a = a;
        this.cont = cont;
    }
}
