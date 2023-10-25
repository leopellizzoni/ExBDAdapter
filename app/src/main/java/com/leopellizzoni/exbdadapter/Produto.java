package com.leopellizzoni.exbdadapter;
public class Produto {
    private String nome;
    private String descricao;
    private int codigoImagem;

    private Produto(String nome, String desc, int imagemResourceId) {
        this.nome = nome;
        this.descricao = desc;
        this.codigoImagem = imagemResourceId;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNome() {
        return nome;
    }

    public int getCodigoImagem() {
        return codigoImagem;
    }

    public String toString() {
        return this.nome;
    }
}