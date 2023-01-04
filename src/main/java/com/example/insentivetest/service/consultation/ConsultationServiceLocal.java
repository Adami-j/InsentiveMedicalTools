package com.example.insentivetest.service.consultation;

import com.example.insentivetest.modele.consultation.Consulter;
import com.example.insentivetest.modele.medecin.Medecin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationServiceLocal extends CrudRepository<Consulter,Integer> {
}
