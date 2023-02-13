package com.bna.ctx.service;

import com.bna.ctx.model.Credit;

public interface CreditService {
	// Add
	Credit addCredit(Credit credit);

	// Get
	Credit getCredit(int id);

	// Update
	Credit updateCredit(Credit credit);

	// Delete
	Credit deleteCredit(int id);

}
