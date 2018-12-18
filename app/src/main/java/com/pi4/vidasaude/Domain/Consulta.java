package com.pi4.vidasaude.Domain;


public class Consulta {

    private String nomePaciente;

    private String telefonePaciente;

    private String dataPretendida;

    private String horarioPretendido;


    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getTelefonePaciente() {
        return telefonePaciente;
    }

    public void setTelefonePaciente(String telefonePaciente) {
        this.telefonePaciente = telefonePaciente;
    }

    public String getDataPretendida() {
        return dataPretendida;
    }

    public void setDataPretendida(String dataPretendida) {
        this.dataPretendida = dataPretendida;
    }

    public String getHorarioPretendido() {
        return horarioPretendido;
    }

    public void setHorarioPretendido(String horarioPretendido) {
        this.horarioPretendido = horarioPretendido;
    }

    public Consulta(String nomePaciente, String telefonePaciente, String dataPretendida, String horarioPretendido){
        this.nomePaciente = nomePaciente;
        this.telefonePaciente = telefonePaciente;
        this.dataPretendida = dataPretendida;
        this.horarioPretendido = horarioPretendido;
    }
}
