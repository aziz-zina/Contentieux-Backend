package com.bna.ctx.service;

import java.util.List;

import com.bna.ctx.model.Frais;
import com.bna.ctx.model.Risque;

public interface FraisService {
	// add
	Frais addFrais(Frais frais);

	// get
	Frais getFrais(int id);

	// update
	Frais updateFrais(Frais frais);

	// delete
	Frais deleteFrais(int id);

	// Get client en Attente
	List<Frais> getAllFraisEnAttente();
	
	//get les frais d'un risque
	List<Frais> getAllFraisByRisque(Risque risque);
	
	//Set etat risque to validé 
	Frais updateEtatFraisToValide(Frais frais);
	
	//Set etat risque to refusé 
	Frais updateEtatFraisToRefuse(Frais frais);
}
