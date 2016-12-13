package com.example.rm31456.persistencia;

import android.app.Application;
import android.content.Context;

import com.example.rm31456.persistencia.dao.DBHelper;
import com.example.rm31456.persistencia.dao.DatabaseManager;
import com.facebook.stetho.Stetho;

/**
 * Created by rm31456 on 12/12/2016.
 */
public class MinhaAplicacao extends Application{

   public void onCreate(){
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        DatabaseManager.initializeInstance(new DBHelper(getApplicationContext()));
   }


}
