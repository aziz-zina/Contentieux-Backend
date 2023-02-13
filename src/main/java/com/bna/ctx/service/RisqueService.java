package com.bna.ctx.service;

import com.bna.ctx.model.Risque;

public interface RisqueService {

	// add
	Risque addRisque(Risque risque);

	// get
	Risque getRisque(int id);

	// update
	Risque updateRisque(Risque risque);

	// delete
	Risque deleteRisque(int id);
}
