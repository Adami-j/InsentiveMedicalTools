package com.example.insentivetest.service.medecin;

import com.example.insentivetest.modele.medecin.Medecin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedecinServiceBean  {

    MedecinServiceLocal medecinServiceLocal;


    public MedecinServiceBean(MedecinServiceLocal medecinServiceLocal) {
        this.medecinServiceLocal = medecinServiceLocal;
    }

    public void save(Medecin medecin) {
        medecinServiceLocal.save(medecin);
    }

    public void saveAll(Iterable<Medecin> medecins) {
        medecinServiceLocal.saveAll(medecins);
    }

    public Optional<Medecin> findById(Integer id) {
        return medecinServiceLocal.findById(id);
    }

    public boolean existsById(Integer id) {
        return medecinServiceLocal.existsById(id);
    }

    public Iterable<Medecin> findAll() {
        return medecinServiceLocal.findAll();
    }

    public Iterable<Medecin> findAllById(Iterable<Integer> ids) {
        return medecinServiceLocal.findAllById(ids);
    }

    public long count() {
        return medecinServiceLocal.count();
    }

    public void deleteById(Integer id) {
        medecinServiceLocal.deleteById(id);
    }

    public void delete(Medecin medecin) {
        medecinServiceLocal.delete(medecin);
    }

    public void deleteAllById(Iterable<? extends Integer> ids) {
        medecinServiceLocal.deleteAllById(ids);
    }

    public void deleteAll(Iterable<? extends Medecin> medecins) {
        medecinServiceLocal.deleteAll(medecins);
    }

    public void deleteAll() {
        medecinServiceLocal.deleteAll();
    }


}
