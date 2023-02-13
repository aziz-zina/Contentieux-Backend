package com.bna.ctx.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bna.ctx.model.Client;
import com.bna.ctx.model.Credit;
import com.bna.ctx.model.DebiteurCtx;
import com.bna.ctx.model.Risque;
import com.bna.ctx.repository.ClientRepository;
import com.bna.ctx.service.ClientService;
import com.bna.ctx.service.DebiteurCtxService;
import com.bna.ctx.service.RisqueService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private DebiteurCtxService debiteurCtxService;

	@Autowired
	private RisqueService risqueService;

//	@Autowired
//	public A a = new A();

	@Override
	public Client addClient(Client client) {
		clientRepository.save(client);
		return client;
	}

	@Override
	public Client getClient(int Id) {
		return clientRepository.findById(Id).get();
	}

	@Override
	public Client updateClient(Client client) {
		clientRepository.save(client);
		return client;
	}

	@Override
	public Client deleteClient(int Id) {
		Client client = clientRepository.findById(Id).get();
		clientRepository.deleteById(Id);
		return client;
	}

	@Override
	public List<Client> getAllClient() {
		return clientRepository.findAll();
	}

	@Override
	public List<Client> getAllClientNonDebiteur() {
		return clientRepository.findByEtatClientNotContaining("Debiteur");
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public DebiteurCtx updateFromClientToDebiteur(Client client) throws Exception {
		Client c = new Client(client.getIdClient(), client.getNomClient(), client.getPrenomClient(), "Debiteur",
				client.getLesCredit());
		this.updateClient(c);
		// System.out.println(c.getLesCredit());
		DebiteurCtx ctx = debiteurCtxService.addDebiteurCtxRequestBody(
				new DebiteurCtx("Ouvert", client.getNomClient(), client.getPrenomClient(), 0));

		this.updateCreditToRisque(client, ctx.getNumCtx());
		return ctx;
	}

	@Override
	public void updateCreditToRisque(Client client, int idDebiteur) {
		DebiteurCtx ctx = new DebiteurCtx(idDebiteur);
		for (Credit credit : client.getLesCredit()) {
			if (credit.getEtatCredit().equals("Non payé")) {
				Risque r = new Risque(credit.getSoldeCredit(), 0, credit.getSoldeCredit(), "Ouvert", ctx);
				risqueService.addRisque(r);
			}
		}

	}

}
