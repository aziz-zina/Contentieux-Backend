package com.bna.ctx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bna.ctx.model.Credit;
import com.bna.ctx.model.requestBody;
import com.bna.ctx.service.CreditService;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class CreditController {
	@Autowired
	private CreditService creditService;

	@PostMapping(value = "/getCredit")
	public @ResponseBody Credit getCredit(@RequestBody requestBody rb) {
		return creditService.getCredit(rb.getId());
	}

	@PostMapping(value = "/addCredit")
	public @ResponseBody Credit addRisque(@RequestBody Credit credit) {
		return creditService.addCredit(credit);
	}

	@PostMapping(value = "/updateCredit")
	public @ResponseBody Credit updateRisque(@RequestBody Credit credit) {
		return creditService.updateCredit(credit);
	}

	@PostMapping(value = "/deleteCredit")
	public @ResponseBody Credit deleteRisque(@RequestBody requestBody rb) {
		return creditService.deleteCredit(rb.getId());
	}
}
