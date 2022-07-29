package com.example.ec3;

import android.os.AsyncTask;

public class ToggleProgressBarValido extends AsyncTask <Object, Void, Boolean> {
    private Comunicacion comunicacion;


    public ToggleProgressBarValido(Comunicacion comunicacion) {
        this.comunicacion = comunicacion;
    }


    @Override
    protected void onPreExecute() {
        comunicacion.toggleProgressBar(true);
    }

    @Override
    protected Boolean doInBackground(Object... objects) {
        try {
            //Solo ayuda a mostrar el toggle progressBar
            Thread.sleep((int)objects[2]);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }




}
