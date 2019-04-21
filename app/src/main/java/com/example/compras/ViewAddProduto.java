package com.example.compras;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class CadastroProduto extends AppCompatActivity {

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

    }
}
