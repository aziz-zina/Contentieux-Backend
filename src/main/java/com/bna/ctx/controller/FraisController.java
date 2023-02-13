package com.bna.ctx.controller;

import java.util.List;

import javax.persistence.OrderBy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bna.ctx.model.Frais;
import com.bna.ctx.model.Risque;
import com.bna.ctx.model.requestBody;
import com.bna.ctx.service.FraisService;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class FraisController {

	@Autowired
	private FraisService fraisService;

	@PostMapping(value = "/getFrais")
	public @ResponseBody Frais getFrais(@RequestBody requestBody rb) {
		return fraisService.getFrais(rb.getId());
	}

	@PostMapping(value = "/addFrais")
	public @ResponseBody Frais addFrais(@RequestBody Frais frais) {
		// System.out.println(frais.getRisque().toString());
		return fraisService.addFrais(frais);
	}

	@PostMapping(value = "/updateFrais")
	public @ResponseBody Frais updateFrais(@RequestBody Frais frais) {
		return fraisService.updateFrais(frais);
	}

	@PostMapping(value = "/deleteFrais")
	public @ResponseBody Frais deleteFrais(@RequestBody requestBody rb) {
		return fraisService.deleteFrais(rb.getId());
	}

	@ResponseBody
	@OrderBy
	@GetMapping(value = "/getAllFraisEnAttente")
	public List<Frais> getAllFraisEnAttente() {
		return fraisService.getAllFraisEnAttente();
	}

	@OrderBy
	@PostMapping(value = "/getAllFraisByRisque")
	public @ResponseBody List<Frais> getAllFrais(@RequestBody Risque risque) {
		return fraisService.getAllFraisByRisque(risque);
	}
	
	@PostMapping(value = "/updateFraisValide")
	public @ResponseBody Frais updateFraisValide(@RequestBody Frais frais) {
		return fraisService.updateEtatFraisToValide(frais);
	}
	
	@PostMapping(value = "/updateFraisRefuse")
	public @ResponseBody Frais updateFraisRefuse(@RequestBody Frais frais) {
		return fraisService.updateEtatFraisToRefuse(frais);
	}
}
