package com.example.aplicacionamigosrecuperacion.model.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.example.aplicacionamigosrecuperacion.model.AmigosRepository;

public class MyReceiver extends BroadcastReceiver {

    private AmigosRepository repository;
    private static String numeroTelefono;
    @Override
    public void onReceive(Context context, Intent intent) {
        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
        repository = new AmigosRepository(context);
        if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
            numeroTelefono = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
            Log.v("zzzz", numeroTelefono);
            repository.getAmigonum(numeroTelefono);
        }
    }
}
