package com.bna.ctx.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bna.ctx.model.DebiteurCtx;
import com.bna.ctx.model.Risque;
import com.bna.ctx.repository.DebiteurCtxRepository;
import com.bna.ctx.service.DebiteurCtxService;

@Service
public class DebiteurCtxServiceImpl implements DebiteurCtxService {

	@Autowired
	private DebiteurCtxRepository debiteurCtxRepository;

	// Add
	@Override
	public DebiteurCtx addDebiteurCtx() {
		DebiteurCtx debiteurCtx = new DebiteurCtx("ouvert", "Aziz", "Zina", 123.0);
		debiteurCtxRepository.save(debiteurCtx);
		return debiteurCtx;
	}

	@Override
	public DebiteurCtx addDebiteurCtxRequestBody(DebiteurCtx debiteurCtx) {
		debiteurCtxRepository.save(debiteurCtx);
		return debiteurCtx;
	}

	// Get
	@Override
	public DebiteurCtx getDebiteurCtxById() {
		DebiteurCtx debiteurCtx = debiteurCtxRepository.findById(10).get();
		return debiteurCtx;
	}

	@Override
	public DebiteurCtx getDebiteurCtxByIdfromUrl(int Id) {
		DebiteurCtx debiteurCtx = debiteurCtxRepository.findById(Id).get();
		return debiteurCtx;
	}

	// Update
	@Override
	public DebiteurCtx updateDebiteurCtx(DebiteurCtx debiteurCtx) {
		debiteurCtxRepository.save(debiteurCtx);
		return debiteurCtx;
	}

	// Delete
	@Override
	public DebiteurCtx deleteDebiteurCtx(int Id) {
		DebiteurCtx debiteurCtx = debiteurCtxRepository.findById(Id).get();
		debiteurCtxRepository.deleteById(Id);
		return debiteurCtx;
	}

	@Override
	public List<DebiteurCtx> getAllDebiteur() {
		return debiteurCtxRepository.findAll();
	}

	@Override
	public List<DebiteurCtx> getAllDebuteurOuvert() {
		return debiteurCtxRepository.findByEtatCtxContaining("Ouvert");
	}

	@Override
	public DebiteurCtx getDebiteurCtxByRisque(int numRisque) {
		return debiteurCtxRepository.findByLesRisquesNumRisque(numRisque);
	}
}
