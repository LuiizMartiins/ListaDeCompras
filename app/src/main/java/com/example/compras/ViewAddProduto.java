package com.example.compras;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ViewAddProduto extends AppCompatActivity {

    private EditText edtNomeProduto;
    private EditText edtQntdProduto;
    private EditText edtValorProduto;
    private Button btnCadastrarProduto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_add_produto);

        edtNomeProduto = (EditText)findViewById(R.id.edtNomeProduto);
        edtQntdProduto = (EditText)findViewById(R.id.edtQntdProduto);
        edtValorProduto = (EditText)findViewById(R.id.edtValorProduto);
        btnCadastrarProduto = (Button)findViewById(R.id.btnCadastrarProduto);

        btnCadastrarProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });

    }

    public void salvar(){
        Produto p = new Produto();
        p.setNomeProduto( edtNomeProduto.getText().toString() );
        p.setQtdProduto(Integer.parseInt(edtQntdProduto.getText().toString()));
        p.setValor(Double.parseDouble(edtValorProduto.getText().toString()));
        ProdutoDAO.inserir( p, getIntent().getExtras().getInt("idLista2"), this );
        this.finish();
    }
}
