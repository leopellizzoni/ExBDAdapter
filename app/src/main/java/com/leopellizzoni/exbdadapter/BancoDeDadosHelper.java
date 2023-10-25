package com.leopellizzoni.exbdadapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoDeDadosHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "bdInfo";
    private static final int DB_VERSION = 1;

    public static final String TABELA_PRODUTOS = "PRODUTOS";

    BancoDeDadosHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion);
    }

    private static void insert(SQLiteDatabase db, String name, String description, int resourceId) {
        ContentValues valoresInsert = new ContentValues();
        valoresInsert.put("NAME", name);
        valoresInsert.put("DESCRIPTION", description);
        valoresInsert.put("IMAGE_RESOURCE_ID", resourceId);

        db.insert(TABELA_PRODUTOS, null, valoresInsert);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("CREATE TABLE "+ TABELA_PRODUTOS +" (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "DESCRIPTION TEXT, "
                + "IMAGE_RESOURCE_ID INTEGER);");

        insert(db, "Café com Leite", "Café com leite importado.", R.drawable.latte);
        insert(db, "Café Expresso", "Café de minas gerias.", R.drawable.cappuccino);
        insert(db, "Café Gelado", "Café de minas gerias mas servido gelado.", R.drawable.filter);

        db.execSQL("ALTER TABLE "+ TABELA_PRODUTOS + " ADD COLUMN FAVORITE NUMERIC;");
    }
}