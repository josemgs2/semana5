package com.dossis.curso3semana5.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.dossis.curso3semana5.pojo.Mascota;

import java.util.ArrayList;

public class TablaMascotas {

    private static final String TABLA_MASCOTAS="TMASCOTAS";
    private static final String TABLA_MASCOTAS_COLUMN_ID="Id";
    private static final String TABLA_MASCOTAS_COLUMN_NOMBRE="Nombre";
    private static final String TABLA_MASCOTAS_COLUMN_LIKES="Likes";
    private static final String TABLA_MASCOTAS_COLUMN_IDFOTO="IdFoto";

    public static final String SQL_CREATE_TABLA_MASCOTAS = String.format(
            "CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY, %s TEXT, %s INTEGER, %s TEXT)",
            TABLA_MASCOTAS,
            TABLA_MASCOTAS_COLUMN_ID,
            TABLA_MASCOTAS_COLUMN_NOMBRE,
            TABLA_MASCOTAS_COLUMN_LIKES,
            TABLA_MASCOTAS_COLUMN_IDFOTO);

    public static final String UPDATE_LIKES_BY_ID="UPDATE "+ TABLA_MASCOTAS +
            " SET "+ TABLA_MASCOTAS_COLUMN_LIKES + " = "+ TABLA_MASCOTAS_COLUMN_LIKES + " + 1 " +
            " WHERE "+TABLA_MASCOTAS_COLUMN_ID+" = ";

    public static final String SELECT_ORDER_ID ="SELECT * FROM " + TABLA_MASCOTAS +
                                                " ORDER BY " + TABLA_MASCOTAS_COLUMN_ID;
    public static final String SELECT_5_FAVORITOS ="SELECT * FROM "+TABLA_MASCOTAS+
                                                " ORDER BY " +TABLA_MASCOTAS_COLUMN_LIKES+" DESC LIMIT 5";

    public void crearTabla(SQLiteDatabase db)
    {
        db.execSQL(TablaMascotas.SQL_CREATE_TABLA_MASCOTAS);

    }
    public void addLike(Context ctx, int id) {
        DatabaseHelper dbHelper = new DatabaseHelper(ctx);
        SQLiteDatabase db= dbHelper.getWritableDatabase();
        db.execSQL(UPDATE_LIKES_BY_ID + id);
        db.close();
    }

    public ArrayList<Mascota> getMascotasOrderedId(Context context)
    {
        return getQueryMascotas(context,SELECT_ORDER_ID);
    }

    public ArrayList<Mascota> getMascotasOrderedLikes(Context context)
    {
        return getQueryMascotas(context,SELECT_5_FAVORITOS);
    }

    private ArrayList<Mascota> getQueryMascotas(Context context, String query){
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db= dbHelper.getReadableDatabase();

        Cursor cursor= db.rawQuery(query,null);
        ArrayList<Mascota> mascotas = new ArrayList<>();
        while(cursor.moveToNext()) {
            mascotas.add(new Mascota(cursor.getInt(cursor.getColumnIndex(TABLA_MASCOTAS_COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndex(TABLA_MASCOTAS_COLUMN_NOMBRE)),
                    cursor.getInt(cursor.getColumnIndex(TABLA_MASCOTAS_COLUMN_LIKES)),
                    cursor.getInt(cursor.getColumnIndex(TABLA_MASCOTAS_COLUMN_IDFOTO))));
        }
        db.close();
        return mascotas;
    }
    public void insertMascota(Context ctx,int id, String nombre, int idFoto)
    {
        DatabaseHelper dbHelper = new DatabaseHelper(ctx);
        SQLiteDatabase db= dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(TABLA_MASCOTAS_COLUMN_ID, id);
        cv.put(TABLA_MASCOTAS_COLUMN_NOMBRE, nombre);
        cv.put(TABLA_MASCOTAS_COLUMN_LIKES, 0);
        cv.put(TABLA_MASCOTAS_COLUMN_IDFOTO, idFoto);
        db.insert(TABLA_MASCOTAS, null, cv);
        db.close();
    }

}
