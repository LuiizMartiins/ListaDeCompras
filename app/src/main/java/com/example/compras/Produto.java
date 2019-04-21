package com.example.compras;

public class Produto {

    private int    idProduto;
    private String nomeProduto;
    private int    qtdProduto;
    private double valorProduto;

    public Produto() {
    }

    public Produto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Produto(String nomeProduto, int qtdProduto) {
        this.nomeProduto = nomeProduto;
        this.qtdProduto = qtdProduto;
    }

    public Produto(String nomeProduto, double valor) {
        this.nomeProduto = nomeProduto;
        this.valorProduto = valor;
    }

    public Produto(int qtdProduto, double valor) {
        this.qtdProduto = qtdProduto;
        this.valorProduto = valor;
    }

    public Produto(String nomeProduto, int qtdProduto, double valor) {
        this.nomeProduto = nomeProduto;
        this.qtdProduto = qtdProduto;
        this.valorProduto = valor;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public double getValor() {
        return valorProduto;
    }

    public void setValor(double valor) {
        this.valorProduto = valor;
    }
}
