package com.example.insentivetest.modele.medecin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "medecin")
public class Medecin {
    @Id
    @Column(name = "id_medecin", nullable = false)
    private Integer id;

    @Column(name = "nom", length = 50)
    private String nom;

    @Column(name = "prenom", length = 50)
    private String prenom;

    @Column(name = "mail", length = 50)
    private String mail;

    @Column(name = "telephone", length = 50)
    private String telephone;

    @Column(name = "datevalidite")
    private LocalDate datevalidite;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public LocalDate getDatevalidite() {
        return datevalidite;
    }

    public void setDatevalidite(LocalDate datevalidite) {
        this.datevalidite = datevalidite;
    }

}