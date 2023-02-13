package com.bna.ctx.service;

import com.bna.ctx.model.Utilisateur;

public interface UtilisateurService {
	
	//get user
	Utilisateur getUser(int matricule);
	
	//Verifier User
	Utilisateur verifyUser(Utilisateur utilisateur) throws Exception;
}
