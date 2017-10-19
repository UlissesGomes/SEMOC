package model;

import java.io.Serializable;

public class Mesa implements Serializable {

    private int id;
    private String data;
    private String turno;
    private String horario;
    private String eixo;
    private String nomeMesa;
    private String coordenador;
    private String participantes;
    private String local;

    public Mesa() {
    }

    public Mesa(String data, String turno, String horario, String eixo, String nomeMesa, String coordenador, String participantes, String local) {
        this.data = data;
        this.turno = turno;
        this.horario = horario;
        this.eixo = eixo;
        this.nomeMesa = nomeMesa;
        this.coordenador = coordenador;
        this.participantes = participantes;
        this.local = local;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getEixo() {
        return eixo;
    }

    public void setEixo(String eixo) {
        this.eixo = eixo;
    }

    public String getNomeMesa() {
        return nomeMesa;
    }

    public void setNomeMesa(String nomeMesa) {
        this.nomeMesa = nomeMesa;
    }

    public String getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(String coordenador) {
        this.coordenador = coordenador;
    }

    public String getParticipantes() {
        return participantes;
    }

    public void setParticipantes(String participantes) {
        this.participantes = participantes;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
