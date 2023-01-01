package com.example.insentivetest.service.patient;

import com.example.insentivetest.modele.patient.Patient;

import java.util.Optional;

public class PatientServiceBean {

    private PatientServiceLocal patientServiceLocal;

    public PatientServiceBean(PatientServiceLocal patientServiceLocal) {
        this.patientServiceLocal = patientServiceLocal;
    }

    public Patient save(Patient patient) {
        return patientServiceLocal.save(patient);
    }

    public Optional<Patient> findById(Integer id) {
        return patientServiceLocal.findById(id);
    }

    public Iterable<Patient> findAll() {
        return patientServiceLocal.findAll();
    }

    public void deleteById(Integer id) {
        patientServiceLocal.deleteById(id);
    }

    public void delete(Patient patient) {
        patientServiceLocal.delete(patient);
    }

    public void deleteAll() {
        patientServiceLocal.deleteAll();
    }

    public long count() {
        return patientServiceLocal.count();
    }

    public boolean existsById(Integer id) {
        return patientServiceLocal.existsById(id);
    }

    public Iterable<Patient> findAllById(Iterable<Integer> ids) {
        return patientServiceLocal.findAllById(ids);
    }

    public void deleteAllById(Iterable<? extends Integer> ids) {
        patientServiceLocal.deleteAllById(ids);
    }

    public <S extends Patient> Iterable<S> saveAll(Iterable<S> patients) {
        return patientServiceLocal.saveAll(patients);
    }



}

