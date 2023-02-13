package com.bna.ctx.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Comment;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Credit")

public class Credit implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8039670023964038247L;


	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="num_Credit", nullable = false, columnDefinition = "number(6,0)")
	@Comment("numéro du Credit")
	private int numCredit;
	
	
	@Column(name="Solde_Credit")
	@Comment("le solde du credit")
	private double soldeCredit;
	
	@Column(name="etat_Credit")
	@Comment("etat du Credit")
	private String etatCredit;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@Comment("Id du client")
	@JoinColumn(name = "idClient")
	protected Client client;

	public int getNumCredit() {
		return numCredit;
	}

	public void setNumCredit(int numCredit) {
		this.numCredit = numCredit;
	}

	public double getSoldeCredit() {
		return soldeCredit;
	}

	public void setSoldeCredit(double soldeCredit) {
		this.soldeCredit = soldeCredit;
	}

	public String getEtatCredit() {
		return etatCredit;
	}

	public void setEtatCredit(String etatCredit) {
		this.etatCredit = etatCredit;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Credit(int numCredit, double soldeCredit, String etatCredit, Client client) {
		super();
		this.numCredit = numCredit;
		this.soldeCredit = soldeCredit;
		this.etatCredit = etatCredit;
		this.client = client;
	}

	public Credit() {
		super();
	}

	@Override
	public String toString() {
		return "Credit [numCredit=" + numCredit + ", soldeCredit=" + soldeCredit + ", etatCredit=" + etatCredit
				+ ", client=" + client + "]";
	}
	
}
