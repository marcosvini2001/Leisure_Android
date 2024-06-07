package com.fieb.aula.usuariosenha.model;

import java.sql.ResultSet;

public class ImovelModel {

    private String nome_imagem;
    private String area;
    private String preco;
    private String id;

    private String descricao;
    private String cidade;
    private String  bairro;
    private String cep;
    private String  num_residencia;
    private String qtde_quarto;
    private String qtde_banheiro;

    private String Iptu;

    private String qtde_vaga_garagem;
    private String sustentabilidade;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNum_residencia() {
        return num_residencia;
    }

    public void setNum_residencia(String num_residencia) {
        this.num_residencia = num_residencia;
    }

    public String getQtde_quarto() {
        return qtde_quarto;
    }

    public void setQtde_quarto(String qtde_quarto) {
        this.qtde_quarto = qtde_quarto;
    }

    public String getQtde_banheiro() {
        return qtde_banheiro;
    }

    public void setQtde_banheiro(String qtde_banheiro) {
        this.qtde_banheiro = qtde_banheiro;
    }

    public String getQtde_vaga_garagem() {
        return qtde_vaga_garagem;
    }

    public void setQtde_vaga_garagem(String qtde_vaga_garagem) {
        this.qtde_vaga_garagem = qtde_vaga_garagem;
    }

    public String getIptu() {
        return Iptu;
    }

    public void setIptu(String Iptu) {
        this.Iptu = Iptu;
    }

    public String getSustentabilidade() {
        return sustentabilidade;
    }

    public void setSustentabilidade(String sustentabilidade) {
        this.sustentabilidade = sustentabilidade;
    }
}