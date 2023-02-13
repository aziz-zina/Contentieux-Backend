package com.bna.ctx.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bna.ctx.model.Risque;
import com.bna.ctx.repository.RisqueRepository;
import com.bna.ctx.service.RisqueService;

@Service
public class RisqueServiceImpl implements RisqueService {
	@Autowired
	private RisqueRepository risqueRepository;

	@Override
	public Risque addRisque(Risque risque) {
		risqueRepository.save(risque);
		return risque;
	}

	@Override
	public Risque getRisque(int id) {
		return risqueRepository.findById(id).get();
	}

	@Override
	public Risque updateRisque(Risque risque) {
		risqueRepository.save(risque);
		return risque;
	}

	@Override
	public Risque deleteRisque(int id) {
		Risque risque = risqueRepository.findById(id).get();
		risqueRepository.deleteById(id);
		return risque;
	}
}
