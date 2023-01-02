package com.example.insentivetest.service.utilisateur;

import com.example.insentivetest.modele.utilisateur.Utilisateur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface UtilisateurServiceLocal extends CrudRepository<Utilisateur,Integer> {

    @Query(value = "SELECT * FROM utilisateur WHERE email = ?1", nativeQuery = true)
    Utilisateur findByEmail(String email);
}
