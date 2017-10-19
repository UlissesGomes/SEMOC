package model;

import java.io.Serializable;

/**
 * Created by Nero on 16/10/2017.
 */

public class Minicurso implements Serializable {
    private int id;
    private String nome;
    private String local;
    private String horario;
    private String professor;
    private String cargaHoraria;
    private String data;

    public Minicurso(){

    }
    public Minicurso(String nome, String local, String horario, String professor, String cargaHoraria, String data) {
        this.nome = nome;
        this.local = local;
        this.horario = horario;
        this.professor = professor;
        this.cargaHoraria = cargaHoraria;
        this.data = data;
    }

    public Minicurso(int id,String nome, String local, String horario, String professor, String cargaHoraria, String data) {
        this.id = id;
        this.nome = nome;
        this.local = local;
        this.horario = horario;
        this.professor = professor;
        this.cargaHoraria = cargaHoraria;
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
