package com.example.insentivetest.modele.consultation;

import com.example.insentivetest.modele.patient.Patient;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "consulter")
public class Consulter {
    @EmbeddedId
    private ConsulterId id;

    @MapsId("idPatient")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_patient", nullable = false)
    private Patient idPatient;

    @Column(name = "daterendezvous")
    private Instant daterendezvous;

    @Column(name = "motif", length = 50)
    private String motif;

    public ConsulterId getId() {
        return id;
    }

    public void setId(ConsulterId id) {
        this.id = id;
    }

    public Patient getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Patient idPatient) {
        this.idPatient = idPatient;
    }

    public Instant getDaterendezvous() {
        return daterendezvous;
    }

    public void setDaterendezvous(Instant daterendezvous) {
        this.daterendezvous = daterendezvous;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

}