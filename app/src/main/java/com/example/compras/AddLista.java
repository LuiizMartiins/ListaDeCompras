package com.example.compras;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddLista extends AppCompatActivity {

    private EditText edtTitulo;
    private Button btnSalvar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lista);

        edtTitulo = (EditText)findViewById(R.id.edtTitulo);
        btnSalvar = (Button)findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
            }
        });
    }
    private void salvar(){
        NovaLista compra = new NovaLista();
        compra.setTitulo( edtTitulo.getText().toString() );
        NovaListaDAO.inserir(compra, this);
        this.finish();

    }
}

