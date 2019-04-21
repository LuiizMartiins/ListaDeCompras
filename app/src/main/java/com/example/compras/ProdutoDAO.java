package com.example.compras;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public static final void inserir(Produto item, int idLista, Context context) {
        Banco banco = new Banco(context);
        ContentValues valores = new ContentValues();
        valores.put("nomeProduto", item.getNomeProduto());
        valores.put("qtdProduto", item.getQtdProduto());
        valores.put("valorProduto", item.getValor());
        valores.put("idListaFK", idLista);
        System.out.println("Numero sendo inseridos no banco: Nome:" + item.getNomeProduto() + " - Qtd:" + item.getQtdProduto() + "- Valor:" + item.getValor() + " - idLista:"+ idLista);
        SQLiteDatabase db = banco.getWritableDatabase();
        db.insert("ListaDeProdutos", null, valores);
    }

    public static final void excluir(int idProduto, Context context) {
        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getWritableDatabase();
        db.delete("ListaDeProdutos", "id = " + idProduto, null);
    }

    public static final List<Produto> listar(Context context, int idLista) {
        List<Produto> listaProdutos = new ArrayList<>();
        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getReadableDatabase();

        String sql = "SELECT * FROM ListaDeProdutos WHERE idListaFK = " + idLista;
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                Produto item = new Produto();
                item.setIdProduto(cursor.getInt(0));
                item.setNomeProduto(cursor.getString(2));
                item.setQtdProduto(cursor.getInt(3));
                item.setValor(cursor.getDouble(4));
                System.out.println("DAO: Retornando o resultado do SELECT - a lista de produtos - Resultado:" + cursor.getInt(0)+ cursor.getInt(1)  +cursor.getInt(2) + cursor.getInt(3) + cursor.getInt(4));
                listaProdutos.add(item);

            } while (cursor.moveToNext());
        }

        return listaProdutos;
    }

}
