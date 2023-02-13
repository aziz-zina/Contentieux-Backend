package com.bna.ctx.service.serviceImpl;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bna.ctx.model.Utilisateur;
import com.bna.ctx.repository.UtilisateurRepository;
import com.bna.ctx.service.UtilisateurService;

@Service
public class UtilisateurServiceImpl implements UtilisateurService{

	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Override
	public Utilisateur getUser(int matricule) {
		return utilisateurRepository.findById(matricule).get();
	}

	@Override
	public Utilisateur verifyUser(Utilisateur utilisateur) throws Exception {
		try {
			Utilisateur user = this.getUser(utilisateur.getMatricule());
			if(!(utilisateur.getPassword().equals(user.getPassword()))) {
				throw new Exception("Mot de passe incorrect");
			}
			return user;
		}catch(NoSuchElementException ex) {
			throw new Exception("L'utilisateur n'existe pas");
		}
	}
	
	
}
