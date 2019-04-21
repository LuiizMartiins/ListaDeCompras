package com.example.compras;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class ListaProduto extends AppCompatActivity {

    ListView lvListaProduto;
    List<Produto> produtos;
    AdapterListaProduto adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produto);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lvListaProduto = (ListView) findViewById(R.id.lvListaProdutos);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(ListaProduto.this, ViewAddProduto.class);
                in.putExtra("idLista2", getIntent().getExtras().getInt("idLista1"));
                startActivity(in);
            }
        });


        lvListaProduto.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                final Produto listaSelecionada = produtos.get(position);
                AlertDialog.Builder alerta =
                        new AlertDialog.Builder(ListaProduto.this);
                alerta.setTitle("Excluir Produto...");
                alerta.setMessage("Confirma a exclusão do Produto " +
                        listaSelecionada.getNomeProduto() + "?");
                alerta.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ProdutoDAO.excluir(listaSelecionada.getIdProduto(),
                                ListaProduto.this);

                        produtos.remove(position);
                        carregarProdutoPorLista();

                        adapter.notifyDataSetChanged();

                    }
                });
                alerta.setNeutralButton("Cancelar", null);
                alerta.show();


                return true;
            }
        });

        /*lvListaProduto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Produto produtoSelecionado = produtos.get(position);
            }*/
    }

    private void carregarProdutoPorLista() {
        produtos = ProdutoDAO.listar(this, getIntent().getExtras().getInt("idLista1"));
        adapter = new AdapterListaProduto(this, produtos);
        lvListaProduto.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarProdutoPorLista();
    }


}