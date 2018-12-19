package com.pi4.vidasaude.Domain;

import java.io.Serializable;

public class Medico implements Serializable {

    private String ID;
    private String MED_NOME;
    private String MED_CRM;
    private String FK_ESP;

    public String getFK_ESP() {
        return FK_ESP;
    }

    public void setFK_ESP(String FK_ESP) {
        this.FK_ESP = FK_ESP;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMED_NOME() {
        return MED_NOME;
    }

    public void setMED_NOME(String MED_NOME) {
        this.MED_NOME = MED_NOME;
    }

    public String getMED_CRM() {
        return MED_CRM;
    }

    public void setMED_CRM(String MED_CRM) {
        this.MED_CRM = MED_CRM;
    }
}
