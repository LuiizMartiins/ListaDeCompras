package com.example.compras;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Banco extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "compras";
    private static final int VERSAO_BANCO = 1;

    public Banco(Context context){
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS ListaDeCompra ( idLista INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, titulo TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS ListaDeProdutos ( idProduto INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "idListaFK INTEGER, nomeProduto TEXT, qtdProduto INTEGER, valorProduto REAL, FOREIGN KEY(idListaFK) references ListaDeCompra(idLista) )");
//

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
