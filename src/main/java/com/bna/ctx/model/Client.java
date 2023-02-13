package com.bna.ctx.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Comment;

@Entity
@Table(name="Client")

public class Client implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -108028303639907524L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="num_Client", nullable = false, columnDefinition = "number(6,0)")
	@Comment("numéro du client")
	private int idClient;
	
	@Column(name="nom_Client")
	@Comment("nom du client")
	private String nomClient;
	
	@Column(name="prenom_Client")
	@Comment("prenom du client")
	private String prenomClient;
	
	@Column(name="etat_Client")
	@Comment("etat du client")
	private String etatClient;
	
	@OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
	@OrderBy
	private Set<Credit> lesCredit;
	
	
	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getPrenomClient() {
		return prenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	public String getEtatClient() {
		return etatClient;
	}

	public void setEtatClient(String etatClient) {
		this.etatClient = etatClient;
	}

	public Set<Credit> getLesCredit() {
		return lesCredit;
	}

	public void setLesCredit(Set<Credit> lesCredit) {
		this.lesCredit = lesCredit;
	}

	public Client(int idClient, String nomClient, String prenomClient, String etatClient, Set<Credit> lesCredit) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.etatClient = etatClient;
		this.lesCredit = lesCredit;
	}

	public Client() {
		super();
	}

	public Client(String nomClient, String prenomClient, String etatClient, Set<Credit> lesCredit) {
		super();
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.etatClient = etatClient;
		this.lesCredit = lesCredit;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nomClient=" + nomClient + ", prenomClient=" + prenomClient
				+ ", etatClient=" + etatClient + ", lesCredit=" + lesCredit + "]";
	}
}
