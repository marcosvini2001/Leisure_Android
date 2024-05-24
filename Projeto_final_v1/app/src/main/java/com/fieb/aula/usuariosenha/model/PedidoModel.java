package com.fieb.aula.usuariosenha.model;

public class PedidoModel {

    private String nome_imagem;
    private String area;
    private String preco;
    private String id;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome_imagem() {
        return nome_imagem;
    }

    public void setNome_imagem(String nome_imagem) {
        this.nome_imagem = nome_imagem;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
}