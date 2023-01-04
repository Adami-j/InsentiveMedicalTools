package com.example.insentivetest.service.medecin;

import com.example.insentivetest.modele.medecin.Medecin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface MedecinServiceLocal extends CrudRepository<Medecin,Integer> {

}
