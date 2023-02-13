package com.bna.ctx.service;

import java.util.List;

import com.bna.ctx.model.DebiteurCtx;

public interface DebiteurCtxService {
	// ajouter un débiteur
	DebiteurCtx addDebiteurCtx();

	DebiteurCtx addDebiteurCtxRequestBody(DebiteurCtx debiteurCtx);

	// Récupérer un débiteur
	DebiteurCtx getDebiteurCtxById();

	DebiteurCtx getDebiteurCtxByIdfromUrl(int Id);

	// Get All Debiteur
	List<DebiteurCtx> getAllDebiteur();

	List<DebiteurCtx> getAllDebuteurOuvert();

	// Modifier un débiteur
	DebiteurCtx updateDebiteurCtx(DebiteurCtx debiteurCtx);

	// Supprimer un débiteur
	DebiteurCtx deleteDebiteurCtx(int Id);

	// Get debiteur By Risque
	DebiteurCtx getDebiteurCtxByRisque(int numRisque);
}
