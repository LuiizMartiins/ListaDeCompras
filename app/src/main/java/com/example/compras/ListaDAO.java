package com.example.compras;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ListaDAO {

    public static final void inserir(Lista compra, Context context){
        Banco banco = new Banco(context);
        ContentValues valores = new ContentValues();
        valores.put("titulo", compra.getTitulo() );
        SQLiteDatabase db = banco.getWritableDatabase();
        db.insert("ListaDeCompra", null, valores);
    }

    public static final void excluir(int idCompra, Context context){
        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getWritableDatabase();
        db.delete("ListaDeCompra", "id = "+idCompra, null);
    }

    public static final List<Lista> listar(Context context){
        List<Lista> lista = new ArrayList<>();
        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getReadableDatabase();
        String sql = "SELECT * FROM ListaDeCompra ORDER BY id DESC ";
        Cursor cursor = db.rawQuery(sql, null);
        if ( cursor.getCount() > 0 ){
            cursor.moveToFirst();
            do{
                Lista compra = new Lista();
                compra.setId( cursor.getInt( 0 ) );
                compra.setTitulo( cursor.getString( 1 ) );
                lista.add( compra );
            }while ( cursor.moveToNext() );
        }
        return lista;
    }

}
