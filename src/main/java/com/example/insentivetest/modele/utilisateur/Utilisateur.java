package com.example.insentivetest.modele.utilisateur;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {

    @Id
    @Column(name = "id_utilisateur", nullable = false)
    private Integer id;

    @Column(name = "login", length = 50)
    private String login;

    @Column(name = "motdepasse", length = 50)
    private String motdepasse;

    @Column(name = "datevalidite")
    private LocalDate datevalidite;

    @Column(name = "active")
    private Boolean active;


    @Column(name = "email", length = 50)
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public LocalDate getDatevalidite() {
        return datevalidite;
    }

    public void setDatevalidite(LocalDate datevalidite) {
        this.datevalidite = datevalidite;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", motdepasse='" + motdepasse + '\'' +
                ", datevalidite=" + datevalidite +
                ", active=" + active +
                ", email='" + email + '\'' +
                '}';
    }
}