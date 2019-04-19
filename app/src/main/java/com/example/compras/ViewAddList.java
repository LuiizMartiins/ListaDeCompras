package com.example.compras;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ViewAddList extends AppCompatActivity {

    private EditText edtTitulo;
    private Button btnSalvar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ViewAddLista);

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
        Lista compra = new Lista();
        compra.setTitulo( edtTitulo.getText().toString() );
        ListaDAO.inserir(compra, this);
        this.finish();

    }
}

