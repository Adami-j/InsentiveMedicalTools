package com.example.insentivetest.controller.patient;

import com.example.insentivetest.modele.patient.Patient;
import com.example.insentivetest.service.patient.PatientServiceBean;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientRestController {


    private PatientServiceBean patientServiceBean;

    @Autowired
    public PatientRestController(PatientServiceBean patientServiceBean) {
        this.patientServiceBean = patientServiceBean;
    }

    @PostMapping("/getPatientById")
    public Optional<Patient> findById(Integer id) {
        return patientServiceBean.findById(id);
    }

    @GetMapping("/")
    public void homes(HttpServletResponse response) throws IOException {
        response.sendRedirect("/patients.html");
    }

    @GetMapping("/test")
    public void home(HttpServletResponse response) throws IOException {

    }

    @PostMapping("/deletePatientById")
    public void deleteById(Integer id) {
        patientServiceBean.deleteById(id);
    }

    @DeleteMapping("/deletePatient")
    public void delete(Patient patient) {
        patientServiceBean.delete(patient);
    }

    @GetMapping("/countPatients")
    public long count() {
        return patientServiceBean.count();
    }

    public boolean existsById(Integer id) {
        return patientServiceBean.existsById(id);
    }


    public Iterable<Patient> findAllById(Iterable<Integer> ids) {
        return patientServiceBean.findAllById(ids);
    }


    @PostMapping("/saveAllPatients")
    public <S extends Patient> Iterable<S> saveAll(Iterable<S> patients) {
        return patientServiceBean.saveAll(patients);
    }

    @PostMapping("/savePatient")
    public Patient save(Patient patient) {
        if (patient.getSexe() == null || patient.getAdresse() == null || patient.getNom() == null || patient.getPrenom() == null && patient.getSexe().equals("") ||
                patient.getAdresse().equals("") || patient.getNom().equals("") || patient.getPrenom().equals("") || patient.getDatenaissance() == null || patient.getDatenaissance().equals("") ||
                patient.getTelephone() == null || patient.getTelephone().equals("") || patient.getTelephone().length() != 10 || patient.getTelephone().charAt(0) != '0' || patient.getNumsecuritesociale() == null || patient.getNumsecuritesociale().equals("") || patient.getNumsecuritesociale().length() != 15
        || patient.getMail() == null || patient.getMail().equals("") || patient.getMail().length() < 5 || !patient.getMail().contains("@") || !patient.getMail().contains(".")) {
            return null;
        }
        return patientServiceBean.save(patient);
        }

}
