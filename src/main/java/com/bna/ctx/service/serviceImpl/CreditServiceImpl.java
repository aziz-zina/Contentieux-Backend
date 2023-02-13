package com.bna.ctx.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bna.ctx.model.Credit;
import com.bna.ctx.repository.CreditRepository;
import com.bna.ctx.service.CreditService;

@Service
public class CreditServiceImpl implements CreditService {

	@Autowired
	private CreditRepository creditRepository;

	@Override
	public Credit addCredit(Credit credit) {
		creditRepository.save(credit);
		return credit;
	}

	@Override
	public Credit getCredit(int id) {
		return creditRepository.findById(id).get();
	}

	@Override
	public Credit updateCredit(Credit credit) {
		creditRepository.save(credit);
		return credit;
	}

	@Override
	public Credit deleteCredit(int id) {
		Credit credit = creditRepository.findById(id).get();
		creditRepository.deleteById(id);
		return credit;
	}

}
