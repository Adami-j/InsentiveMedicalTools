package com.example.insentivetest.modele.patient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "dossierpatient")
public class Dossierpatient {
    @Id
    @Column(name = "id_dossierpatient", nullable = false)
    private Integer id;

    @Column(name = "taille")
    private Integer taille;

    @Column(name = "poids", length = 50)
    private String poids;

    @Column(name = "datevalidite")
    private LocalDate datevalidite;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTaille() {
        return taille;
    }

    public void setTaille(Integer taille) {
        this.taille = taille;
    }

    public String getPoids() {
        return poids;
    }

    public void setPoids(String poids) {
        this.poids = poids;
    }

    public LocalDate getDatevalidite() {
        return datevalidite;
    }

    public void setDatevalidite(LocalDate datevalidite) {
        this.datevalidite = datevalidite;
    }

}