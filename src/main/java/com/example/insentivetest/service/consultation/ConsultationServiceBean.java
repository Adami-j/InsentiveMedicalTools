package com.example.insentivetest.service.consultation;

import com.example.insentivetest.modele.consultation.Consulter;
import com.example.insentivetest.modele.medecin.Medecin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultationServiceBean {

    ConsultationServiceLocal consultationServiceLocal;

    public ConsultationServiceBean(ConsultationServiceLocal consultationServiceLocal) {
        this.consultationServiceLocal = consultationServiceLocal;
    }


    public Iterable<Consulter> findAll() {
        return consultationServiceLocal.findAll();
    }

    public void deleteById(Integer id) {
        consultationServiceLocal.deleteById(id);
    }

    public void delete(Consulter consulter) {
        consultationServiceLocal.delete(consulter);
    }

    public void deleteAll() {
        consultationServiceLocal.deleteAll();
    }

    public long count() {
        return consultationServiceLocal.count();
    }

    public boolean existsById(Integer id) {
        return consultationServiceLocal.existsById(id);
    }

    public Iterable<Consulter> findAllById(Iterable<Integer> ids) {
        return consultationServiceLocal.findAllById(ids);
    }

    public void deleteAllById(Iterable<? extends Integer> ids) {
        consultationServiceLocal.deleteAllById(ids);
    }

    public <S extends Consulter> Iterable<S> saveAll(Iterable<S> consulter) {
        return consultationServiceLocal.saveAll(consulter);
    }

    public <S extends Consulter> S save(S consulter) {
        return consultationServiceLocal.save(consulter);
    }


}
