package com.bna.ctx.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bna.ctx.model.Client;
import com.bna.ctx.model.DebiteurCtx;

@Service
public interface ClientService {
	// Add Client
	Client addClient(Client client);

	// Get Client
	Client getClient(int Id);

	// Get All Clients
	List<Client> getAllClient();

	// Update Client
	Client updateClient(Client client);

	// Delete Client
	Client deleteClient(int Id);

	// Get client non debiteur
	List<Client> getAllClientNonDebiteur();

	// Transform client to debiteur
	void updateCreditToRisque(Client client, int idDebiteur);

	DebiteurCtx updateFromClientToDebiteur(Client client) throws Exception;
}
