package com.example.harol.lanchonetedeliciatarefas;

public class Produtos {
    private int _id;
    private String nome;
    private String preço;
    private String descrição;
    private String imagem;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public Produtos(int _id, String nome, String preço, String descrição, String imagem) {
        this._id = _id;
        this.nome = nome;
        this.preço = preço;
        this.descrição = descrição;
        this.imagem = imagem;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreço() {
        return preço;
    }

    public void setPreço(String preço) {
        this.preço = preço;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

}
