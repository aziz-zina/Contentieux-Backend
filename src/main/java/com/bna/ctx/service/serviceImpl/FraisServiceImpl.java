package com.bna.ctx.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bna.ctx.model.DebiteurCtx;
import com.bna.ctx.model.Frais;
import com.bna.ctx.model.Risque;
import com.bna.ctx.repository.FraisRepository;
import com.bna.ctx.service.DebiteurCtxService;
import com.bna.ctx.service.FraisService;
import com.bna.ctx.service.RisqueService;

@Service
public class FraisServiceImpl implements FraisService {

	@Autowired
	private FraisRepository fraisRepository;

	@Autowired
	private RisqueService risqueService;
	
	@Autowired
	private DebiteurCtxService debiteurCtxService;

	@Transactional(rollbackFor = Exception.class)
	@Override
	public Frais addFrais(Frais frais) {
		fraisRepository.save(frais);
		Risque risque = risqueService.getRisque(frais.getRisque().getNumRisque());
		System.out.println(risque.toString());
		risque.setFraisTotales(risque.getFraisTotales() + frais.getMontantFrais());
		risque.setSoldePrincipal(risque.getFraisTotales() + risque.getMontantInitial());
		risqueService.updateRisque(risque);
		System.out.println(risqueService.getRisque(frais.getRisque().getNumRisque()));
		return frais;
	}

	@Override
	public Frais getFrais(int id) {
		return fraisRepository.findById(id).get();
	}

	@Override
	public Frais updateFrais(Frais frais) {
		fraisRepository.save(frais);
		return frais;
	}

	@Override
	public Frais deleteFrais(int id) {
		Frais frais = fraisRepository.findById(id).get();
		fraisRepository.deleteById(id);
		return frais;
	}

	@Override
	public List<Frais> getAllFraisEnAttente() {
		return fraisRepository.findByEtatFraisContaining("En attente");
	}

	@Override
	public List<Frais> getAllFraisByRisque(Risque risque) {
		return fraisRepository.findByRisqueNumRisque(risque.getNumRisque());
	}

	@Override
	public Frais updateEtatFraisToValide(Frais frais) {
		Risque risque = frais.getRisque();
		DebiteurCtx debiteur =  debiteurCtxService.getDebiteurCtxByRisque(risque.getNumRisque());
		risque.setDebiteurCtx(debiteur);
		frais.setEtatFrais("Validé");
		risqueService.updateRisque(risque);
		this.updateFrais(frais);
		return frais;
	}

	@Override
	public Frais updateEtatFraisToRefuse(Frais frais) {
		Risque risque = frais.getRisque();
		DebiteurCtx debiteur =  debiteurCtxService.getDebiteurCtxByRisque(risque.getNumRisque());
		risque.setDebiteurCtx(debiteur);
		frais.setEtatFrais("Refusé");
		risqueService.updateRisque(risque);
		this.updateFrais(frais);
		return frais;
	}

}
