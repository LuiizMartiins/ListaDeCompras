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
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.AdapterView;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lvLista;
    List<NovaLista> lista;
    AdapterTituloLista adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lvLista = (ListView) findViewById(R.id.lvTituloLista);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this, AddLista.class);
                startActivity(in);
            }

        });

        lvLista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                final NovaLista listaSelecionada = lista.get(position);
                AlertDialog.Builder alerta =
                        new AlertDialog.Builder(MainActivity.this);
                alerta.setTitle("Excluir Lista...");
                alerta.setMessage("Confirma a exclusão da Lista " +
                        listaSelecionada.getTitulo() + "?");
                alerta.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        NovaListaDAO.excluir(listaSelecionada.getId(),
                                MainActivity.this);

                        lista.remove( position);
                        carregarLista();

                        adapter.notifyDataSetChanged();

                    }
                });
                alerta.setNeutralButton("Cancelar", null);
                alerta.show();


                return true;
            }
        });
    }

    private void carregarLista(){

        lista = NovaListaDAO.listar(this);
        adapter = new AdapterTituloLista(this, lista);
        lvLista.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarLista();
    }

}






