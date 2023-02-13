package com.bna.ctx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bna.ctx.model.Client;
import com.bna.ctx.model.DebiteurCtx;
import com.bna.ctx.model.requestBody;
import com.bna.ctx.service.ClientService;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {

	@Autowired
	private ClientService clientService;

	/*
	 * @ResponseBody
	 * 
	 * @PostMapping(value = "/getClient") public Client getClient(@RequestBody
	 * requestBody rb) { return clientService.getClient(rb.getId()); }
	 */

	@ResponseBody
	@GetMapping("/getClient/{urlParameter}")
	public Client getClient(@PathVariable(value = "urlParameter") int urlParameter) {
		return clientService.getClient(urlParameter);
	}

	@PostMapping(value = "/addClient")
	public @ResponseBody Client addClient(@RequestBody Client client) {
		return clientService.addClient(client);
	}

	@PostMapping(value = "/updateClient")
	public @ResponseBody Client updateClient(@RequestBody Client client) {
		return clientService.updateClient(client);
	}

	@PostMapping(value = "/deleteClient")
	public @ResponseBody Client deleteClient(@RequestBody requestBody rb) {
		return clientService.deleteClient(rb.getId());
	}

	@ResponseBody
	@GetMapping(value = "/getAllClient")
	public List<Client> getAllClient() {
		return clientService.getAllClient();
	}

	@ResponseBody
	@GetMapping(value = "/getAllClientNonDebiteur")
	public List<Client> getAllClientNonDebiteur() {
		return clientService.getAllClientNonDebiteur();
	}

	@PostMapping(value = "/transformerClientDebiteur")
	public @ResponseBody DebiteurCtx updateFromClientToDebiteur(@RequestBody Client client) throws Exception {
		return clientService.updateFromClientToDebiteur(client);
	}

}
