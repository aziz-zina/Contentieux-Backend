package com.bna.ctx.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
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
@Table(name = "Risque")

public class Risque implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8286605175316985357L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "num_Risque", nullable = false, columnDefinition = "number(6,0)")
	@Comment("numéro du Risque")
	private int numRisque;

	@Column(name = "montant_initial")
	@Comment("le montant initial")
	private double montantInitial;

	@Column(name = "frais_totales")
	@Comment("la somme des frais")
	private double fraisTotales;

	@Column(name = "Solde_Principal")
	@Comment("le solde principal")
	private double soldePrincipal;

	@Column(name = "etat_Risque", length = 15)
	@Comment("etat du risque")
	private String etatRisque;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@Comment("Id du debiteur de ce risque")
	@JoinColumn(name = "numCtx")
	protected DebiteurCtx debiteurCtx;

	public int getNumRisque() {
		return numRisque;
	}

	public void setNumRisque(int numRisque) {
		this.numRisque = numRisque;
	}

	public double getMontantInitial() {
		return montantInitial;
	}

	public void setMontantInitial(double montantInitial) {
		this.montantInitial = montantInitial;
	}

	public double getFraisTotales() {
		return fraisTotales;
	}

	public void setFraisTotales(double fraisTotales) {
		this.fraisTotales = fraisTotales;
	}

	public double getSoldePrincipal() {
		return soldePrincipal;
	}

	public void setSoldePrincipal(double soldePrincipal) {
		this.soldePrincipal = soldePrincipal;
	}

	public String getEtatRisque() {
		return etatRisque;
	}

	public void setEtatRisque(String etatRisque) {
		this.etatRisque = etatRisque;
	}

	public DebiteurCtx getDebiteurCtx() {
		return debiteurCtx;
	}

	public void setDebiteurCtx(DebiteurCtx debiteurCtx) {
		this.debiteurCtx = debiteurCtx;
	}

	public Risque(int numRisque, double montantInitial, double fraisTotales, double soldePrincipal, String etatRisque,
			DebiteurCtx debiteurCtx) {
		super();
		this.numRisque = numRisque;
		this.montantInitial = montantInitial;
		this.fraisTotales = fraisTotales;
		this.soldePrincipal = soldePrincipal;
		this.etatRisque = etatRisque;
		this.debiteurCtx = debiteurCtx;
	}

	public Risque(double montantInitial, double fraisTotales, double soldePrincipal, String etatRisque,
			DebiteurCtx debiteurCtx) {
		super();
		this.montantInitial = montantInitial;
		this.fraisTotales = fraisTotales;
		this.soldePrincipal = soldePrincipal;
		this.etatRisque = etatRisque;
		this.debiteurCtx = debiteurCtx;
	}

	public Risque(int numRisque, double fraisTotales, double soldePrincipal) {
		super();
		this.numRisque = numRisque;
		this.fraisTotales = fraisTotales;
		this.soldePrincipal = soldePrincipal;
	}

	public Risque(int numRisque) {
		super();
		this.numRisque = numRisque;
	}

	public Risque() {
		super();
	}

	@Override
	public String toString() {
		return "Risque [numRisque=" + numRisque + ", montantInitial=" + montantInitial + ", fraisTotales="
				+ fraisTotales + ", soldePrincipal=" + soldePrincipal + ", etatRisque=" + etatRisque + ", debiteurCtx="
				+ debiteurCtx + "]";
	}

}
