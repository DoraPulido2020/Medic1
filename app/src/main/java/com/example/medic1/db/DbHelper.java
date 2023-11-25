package com.example.medic1.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "Medic";
    public static final String TABLE_MEDICOS = "Medicos";

    public DbHelper(Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE usuario ("+
                "idUsuario INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombres TEXT NOT NULL," +
                "apellidos TEXT NOT NULL," +
                "numeroCedula INTEGER NOT NULL," +
                "telefono TEXT NOT NULL," +
                "nombreUsuario TEXT NOT NULL," +
                "contrasena TEXT NOT NULL," +
                "fechaNacimiento TEXT NOT NULL," +
                "correoElectronico TEXT NOT NULL," +
                "tipoSangre TEXT NOT NULL," +
                "genero TEXT NOT NULL," +
                "edad INTEGER NOT NULL," +
                "estado TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE Medicos");
    }


}
