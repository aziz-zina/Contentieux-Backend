package com.bna.ctx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bna.ctx.model.Risque;
import com.bna.ctx.model.requestBody;
import com.bna.ctx.service.RisqueService;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class RisqueController {

	@Autowired
	private RisqueService risqueService;

	@PostMapping(value = "/getRisque")
	public @ResponseBody Risque getRisque(@RequestBody requestBody rb) {
		return risqueService.getRisque(rb.getId());
	}

	@PostMapping(value = "/addRisque")
	public @ResponseBody Risque addRisque(@RequestBody Risque risque) {
		return risqueService.addRisque(risque);
	}

	@PostMapping(value = "/updateRisque")
	public @ResponseBody Risque updateRisque(@RequestBody Risque risque) {
		return risqueService.updateRisque(risque);
	}

	@PostMapping(value = "/deleteRisque")
	public @ResponseBody Risque deleteRisque(@RequestBody requestBody rb) {
		return risqueService.deleteRisque(rb.getId());
	}

	@ResponseBody
	@GetMapping("/getRisqueById/{urlParameter}")
	public Risque getRisqueCtxById(@PathVariable(value = "urlParameter") int urlParameter) {
		return risqueService.getRisque(urlParameter);
	}
}
