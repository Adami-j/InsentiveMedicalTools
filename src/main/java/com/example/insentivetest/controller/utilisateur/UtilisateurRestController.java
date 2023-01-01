package com.example.insentivetest.controller.utilisateur;

import com.example.insentivetest.modele.utilisateur.Utilisateur;
import com.example.insentivetest.service.utilisateur.UtilisateurServiceBean;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.MessageDigest;

@RestController("/")
public class UtilisateurRestController {

    private UtilisateurServiceBean utilisateurServiceBean;

    @Autowired
    public UtilisateurRestController(UtilisateurServiceBean utilisateurServiceBean) {
        this.utilisateurServiceBean = utilisateurServiceBean;
    }

    // methode qui redirige vers la page d'acceuil get
    @GetMapping("/")
    public void home(HttpServletResponse response) throws IOException {
        response.sendRedirect("/index.html");

    }



    @GetMapping("/utilisateurs")
    public Iterable<Utilisateur> getUtilisateurs() {
        return utilisateurServiceBean.findAll();
    }

    @GetMapping("/utilisateur")
    public Utilisateur getUtilisateur(@PathVariable Integer id) {
        return utilisateurServiceBean.findById(id);
    }

    @PostMapping(path = "/ajouterutilisateur", consumes = "application/x-www-form-urlencoded")
    public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
        System.out.println(utilisateur.toString());
        if(utilisateur.getEmail()!=null&&utilisateurServiceBean.findByEmail(utilisateur.getEmail())==null&&utilisateur.getLogin()!=null&&utilisateur.getMotdepasse()!=null){

            utilisateur.setMotdepasse(sha256(utilisateur.getMotdepasse()));

            System.out.println(Integer.getInteger(sha256(utilisateur.getEmail())));
            utilisateur.setId(1);

            utilisateur.setActive(true);

            return utilisateurServiceBean.save(utilisateur);
        }

        return null;
    }

    @DeleteMapping("/utilisateur")
    public void deleteUtilisateur(@PathVariable Integer id) {
        utilisateurServiceBean.deleteById(id);
    }

    @PutMapping("/utilisateur")
    public Utilisateur updateUtilisateur(@RequestBody Utilisateur utilisateur) {
        return utilisateurServiceBean.save(utilisateur);
    }

    // fonction d'encriptage du mot de passe de l'utilisateur avec le sha256
    public String sha256(String base) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    // fonction de décryptage du mot de passe de l'utilisateur avec le sha256
    public String sha256Decrypt(String base) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    // fonction login thymleaf session utilisateur requestbody httpsession
    @PostMapping(path = "/login",  consumes = "application/x-www-form-urlencoded")
    public String login( Utilisateur utilisateur, HttpSession session,HttpServletResponse response) throws IOException{

        Utilisateur utilisateur1 = utilisateurServiceBean.findByEmail(utilisateur.getEmail());

        if (utilisateur1 != null) {
            if (utilisateur1.getMotdepasse().equals(sha256(utilisateur.getMotdepasse()))) {
                session.setAttribute("utilisateur", utilisateur1);
                response.sendRedirect("/dashboard.html");
                System.out.println(session.getAttribute("utilisateur")+ " est connecté"+ " "+ session.getId()+session.getCreationTime()+session.getLastAccessedTime());

                return "";
            }
          response.sendRedirect("/index.html");

            return "";

        }
        response.sendRedirect("/index.html");
        return "";
    }





}
