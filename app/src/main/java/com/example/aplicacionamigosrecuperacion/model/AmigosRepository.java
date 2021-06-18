package com.example.aplicacionamigosrecuperacion.model;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.aplicacionamigosrecuperacion.model.dao.AmigoDao;
import com.example.aplicacionamigosrecuperacion.model.dao.LlamadaDao;
import com.example.aplicacionamigosrecuperacion.model.entity.Amigo;
import com.example.aplicacionamigosrecuperacion.model.entity.Llamadas;
import com.example.aplicacionamigosrecuperacion.model.entity.NumeroLlamadas;
import com.example.aplicacionamigosrecuperacion.model.room.AmigoDataBase;
import com.example.aplicacionamigosrecuperacion.util.UtilThread;

import java.util.Calendar;
import java.util.List;

public class AmigosRepository {

    private AmigoDataBase db;

    private AmigoDao amigoDao;

    private LlamadaDao llamadaDao;

    private LiveData<List<NumeroLlamadas>> liveNumeroLlamadas;

    private LiveData<List<Amigo>> liveListaAmigos;

    public AmigosRepository(Context context) {
        db = AmigoDataBase.getDb(context);
        amigoDao = db.getAmigoDao();
        llamadaDao = db.getLlamadaDao();

        liveListaAmigos = amigoDao.getAllLive();
    }

    public LiveData<List<Amigo>> getLiveListaAmigos() {
        return liveListaAmigos;
    }

    public LiveData<List<NumeroLlamadas>> getLiveNumeroLlamadas() {
        return liveNumeroLlamadas;
    }

    public void insert(Amigo amigo) {

        UtilThread.threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                amigoDao.insert(amigo);
            }
        });
    }

    public void update(Amigo amigo) {

        UtilThread.threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                amigoDao.update(amigo);
            }
        });
    }

    public void delete(int id) {

        UtilThread.threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                amigoDao.deleteMio(id);
            }
        });
    }

    public void getAmigonum(String telefono) {

        UtilThread.threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                Log.v("zzzz", telefono);
                int a = amigoDao.getNumero(telefono);
                Calendar calendar = Calendar.getInstance();
                int dia = calendar.get(Calendar.DAY_OF_MONTH);
                int mes = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);
                String fecha = dia + "/" + mes + "/" + year;
                Llamadas llamadas = new Llamadas(a, fecha);
                llamadaDao.insert(llamadas);
            }
        });
    }
}
