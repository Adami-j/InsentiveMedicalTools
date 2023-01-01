package com.example.insentivetest.modele.patient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;

@Entity
@Table(name = "documentadministratifpatient")
public class Documentadministratifpatient {
    @Id
    @Column(name = "id_documentadministratifpatient", nullable = false)
    private Integer id;

    @Column(name = "datedocumentadministratifpatient")
    private Instant datedocumentadministratifpatient;

    @Column(name = "datevalidite", length = 50)
    private String datevalidite;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getDatedocumentadministratifpatient() {
        return datedocumentadministratifpatient;
    }

    public void setDatedocumentadministratifpatient(Instant datedocumentadministratifpatient) {
        this.datedocumentadministratifpatient = datedocumentadministratifpatient;
    }

    public String getDatevalidite() {
        return datevalidite;
    }

    public void setDatevalidite(String datevalidite) {
        this.datevalidite = datevalidite;
    }

}