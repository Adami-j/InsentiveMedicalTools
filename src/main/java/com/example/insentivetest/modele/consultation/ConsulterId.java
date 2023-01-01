package com.example.insentivetest.modele.consultation;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ConsulterId implements Serializable {
    private static final long serialVersionUID = 9060231829267362627L;
    @Column(name = "id_salle", nullable = false)
    private Integer idSalle;

    @Column(name = "id_rendezvous", nullable = false)
    private Integer idRendezvous;

    @Column(name = "id_medecin", nullable = false)
    private Integer idMedecin;

    @Column(name = "id_patient", nullable = false)
    private Integer idPatient;

    public Integer getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(Integer idSalle) {
        this.idSalle = idSalle;
    }

    public Integer getIdRendezvous() {
        return idRendezvous;
    }

    public void setIdRendezvous(Integer idRendezvous) {
        this.idRendezvous = idRendezvous;
    }

    public Integer getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(Integer idMedecin) {
        this.idMedecin = idMedecin;
    }

    public Integer getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Integer idPatient) {
        this.idPatient = idPatient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ConsulterId entity = (ConsulterId) o;
        return Objects.equals(this.idRendezvous, entity.idRendezvous) &&
                Objects.equals(this.idMedecin, entity.idMedecin) &&
                Objects.equals(this.idPatient, entity.idPatient) &&
                Objects.equals(this.idSalle, entity.idSalle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRendezvous, idMedecin, idPatient, idSalle);
    }

}