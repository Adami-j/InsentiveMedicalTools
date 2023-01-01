package com.example.insentivetest.service.utilisateur;

import com.example.insentivetest.modele.utilisateur.Utilisateur;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurServiceBean {

    private UtilisateurServiceLocal utilisateurServiceLocal;

    public UtilisateurServiceBean(UtilisateurServiceLocal utilisateurServiceLocal) {
        this.utilisateurServiceLocal = utilisateurServiceLocal;
    }

    public Utilisateur save(Utilisateur utilisateur) {
        if(utilisateur.getEmail()==null||this.findByEmail(utilisateur.getEmail())!=null||utilisateur.getLogin()==null||utilisateur.getMotdepasse()==null || utilisateur.getId()==null){
            return null;
        }else{
            return this.utilisateurServiceLocal.save(utilisateur);
        }
    }

    public Utilisateur findById(Integer id) {
        return utilisateurServiceLocal.findById(id).get();
    }

    public Iterable<Utilisateur> findAll() {
        return utilisateurServiceLocal.findAll();
    }

    public Integer deleteById(Integer id) {
        if(utilisateurServiceLocal.findById(id).isPresent()){
            utilisateurServiceLocal.deleteById(id);
            return 1;

        }else {
            return null;
        }

    }

    public void delete(Utilisateur utilisateur) {
        utilisateurServiceLocal.delete(utilisateur);
    }

    private void deleteAll() {
        utilisateurServiceLocal.deleteAll();
    }

    public long count() {
        return utilisateurServiceLocal.count();
    }

    public boolean existsById(Integer id) {
        return utilisateurServiceLocal.existsById(id);
    }

    public Iterable<Utilisateur> findAllById(Iterable<Integer> ids) {
        return utilisateurServiceLocal.findAllById(ids);
    }

    public void deleteAllById(Iterable<? extends Integer> ids) {
        utilisateurServiceLocal.deleteAllById(ids);
    }

    public <S extends Utilisateur> Iterable<S> saveAll(Iterable<S> utilisateurs) {
        return utilisateurServiceLocal.saveAll(utilisateurs);
    }

    // fonction qui recherche avec une requete un utilisateur par son email et son mot de passe
    public Utilisateur findByEmail(String email) {
        return utilisateurServiceLocal.findByEmail(email);
    }
}
