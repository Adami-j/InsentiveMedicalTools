package com.example.insentivetest.modele.patient;

import com.example.insentivetest.modele.consultation.Consulter;
import com.example.insentivetest.modele.medecin.Medecin;
import com.example.insentivetest.modele.utilisateur.Utilisateur;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;


@Entity
@Table(name = "Patient")
public class Patient {

    @Id
    @Column(name = "id_Patient", nullable = false)
    private Integer id;

    @Column(name = "sexe")
    private Boolean sexe;

    @Column(name = "nom", length = 50)
    private String nom;

    @Column(name = "prenom", length = 50)
    private String prenom;

    @Column(name = "datenaissance")
    private LocalDate datenaissance;

    @Column(name = "numsecuritesociale", length = 50)
    private String numsecuritesociale;

    @Column(name = "adresse", length = 50)
    private String adresse;

    @Column(name = "telephone", length = 50)
    private String telephone;

    @Column(name = "mail", length = 50)
    private String mail;

    @Column(name = "datevalidite", length = 50)
    private String datevalidite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medecin")
    private Medecin idMedecin;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_dossierpatient", nullable = false)
    private Dossierpatient idDossierpatient;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur idUtilisateur;

    @OneToMany
    private Set<Consulter> consulters = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "concerner",
            joinColumns = @JoinColumn(name = "id_patient"),
            inverseJoinColumns = @JoinColumn(name = "id_documentadministratifpatient"))
    private Set<Documentadministratifpatient> documentadministratifpatients = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Documentadministratifpatient> getDocumentadministratifpatients() {
        return documentadministratifpatients;
    }

    public void setDocumentadministratifpatients(Set<Documentadministratifpatient> documentadministratifpatients) {
        this.documentadministratifpatients = documentadministratifpatients;
    }

    public Set<Consulter> getConsulters() {
        return consulters;
    }

    public void setConsulters(Set<Consulter> consulters) {
        this.consulters = consulters;
    }

    public Utilisateur getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Utilisateur idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Dossierpatient getIdDossierpatient() {
        return idDossierpatient;
    }

    public void setIdDossierpatient(Dossierpatient idDossierpatient) {
        this.idDossierpatient = idDossierpatient;
    }

    public Medecin getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(Medecin idMedecin) {
        this.idMedecin = idMedecin;
    }

    public String getDatevalidite() {
        return datevalidite;
    }

    public void setDatevalidite(String datevalidite) {
        this.datevalidite = datevalidite;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumsecuritesociale() {
        return numsecuritesociale;
    }

    public void setNumsecuritesociale(String numsecuritesociale) {
        this.numsecuritesociale = numsecuritesociale;
    }

    public LocalDate getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(LocalDate datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Boolean getSexe() {
        return sexe;
    }

    public void setSexe(Boolean sexe) {
        this.sexe = sexe;
    }
}
