package com.demands.constructor.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LocalizationDescription {
    @Id
    private long id;
    private String en, ru, kk;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getRu() {
        return ru;
    }

    public void setRu(String ru) {
        this.ru = ru;
    }

    public String getKk() {
        return kk;
    }

    public void setKk(String kk) {
        this.kk = kk;
    }
}
