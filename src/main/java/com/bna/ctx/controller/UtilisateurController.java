package com.bna.ctx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bna.ctx.model.Utilisateur;
import com.bna.ctx.service.UtilisateurService;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class UtilisateurController {
	@Autowired
	private UtilisateurService utilisateurService;
	
	@ResponseBody
	@GetMapping("/getUser/{urlParameter}")
	public Utilisateur getUser(@PathVariable(value="urlParameter") int urlParameter) {
		return utilisateurService.getUser(urlParameter);
	}
	
	@PostMapping("/verifyUser")
	public @ResponseBody Utilisateur verifyUser( @RequestBody Utilisateur user) throws Exception {
		return this.utilisateurService.verifyUser(user);
	}
}
