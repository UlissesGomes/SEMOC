package model;

import java.io.Serializable;

/**
 * Created by Nero on 13/10/2017.
 */

public class TrabalhosAprovados implements Serializable {

    private int id;
    private String inscricao;
    private String titulo;
    private String responsaveis;

    public TrabalhosAprovados() {

    }

    public TrabalhosAprovados(int id, String inscricao, String titulo, String responsaveis) {
        this.id = id;
        this.inscricao = inscricao;
        this.titulo = titulo;
        this.responsaveis = responsaveis;
    }

    public TrabalhosAprovados(String inscricao, String titulo, String responsaveis) {
        this.inscricao = inscricao;
        this.titulo = titulo;
        this.responsaveis = responsaveis;
    }

    public int getId() {
        return id;
    }

    public String getInscricao() {
        return inscricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResponsaveis() {
        return responsaveis;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setInscricao(String inscricao) {
        this.inscricao = inscricao;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setResponsaveis(String responsaveis) {
        this.responsaveis = responsaveis;
    }
}
