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
@Table(name = "Debiteur_Ctx")

public class DebiteurCtx implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1785234425699045072L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "num_Ctx", nullable = false, columnDefinition = "number(6,0)")
	@Comment("numero du dossier contentieux")
	private int numCtx;

	@Column(name = "etat_Ctx")
	@Comment("etat du dossier contentieux: ouvert/cloture")
	private String etatCtx;

	@Column(name = "solde_Ctx")
	@Comment("Solde de recouvrement")
	private Double soldeCtx;

	@Column(name = "nom_Ctx")
	@Comment("nom du debiteur")
	private String nomCtx;

	@Column(name = "prenom_Ctx")
	@Comment("prenom du debiteur")
	private String prenomCtx;

	@OneToMany(mappedBy = "debiteurCtx", fetch = FetchType.EAGER)
	@OrderBy
	private Set<Risque> lesRisques;

	public int getNumCtx() {
		return numCtx;
	}

	public void setNumCtx(int numCtx) {
		this.numCtx = numCtx;
	}

	public String getEtatCtx() {
		return etatCtx;
	}

	public void setEtatCtx(String etatCtx) {
		this.etatCtx = etatCtx;
	}

	public Double getSoldeCtx() {
		return soldeCtx;
	}

	public void setSoldeCtx(Double soldeCtx) {
		this.soldeCtx = soldeCtx;
	}

	public String getNomCtx() {
		return nomCtx;
	}

	public void setNomCtx(String nomCtx) {
		this.nomCtx = nomCtx;
	}

	public String getPrenomCtx() {
		return prenomCtx;
	}

	public void setPrenomCtx(String prenomCtx) {
		this.prenomCtx = prenomCtx;
	}

	public DebiteurCtx() {
		super();
	}

	public DebiteurCtx(int numCtx, String etatCtx, Double soldeCtx, String nomCtx, String prenomCtx,
			Set<Risque> lesRisques) {
		super();
		this.numCtx = numCtx;
		this.etatCtx = etatCtx;
		this.soldeCtx = soldeCtx;
		this.nomCtx = nomCtx;
		this.prenomCtx = prenomCtx;
		this.lesRisques = lesRisques;
	}

	public DebiteurCtx(String etat, String nom, String prenom, double solde) {
		this.etatCtx = etat;
		this.nomCtx = nom;
		this.prenomCtx = prenom;
		this.soldeCtx = solde;
	}

	public DebiteurCtx(int numCtx) {
		super();
		this.numCtx = numCtx;
	}

	@Override
	public String toString() {
		return "DebiteurCtx [numCtx=" + numCtx + ", etatCtx=" + etatCtx + ", soldeCtx=" + soldeCtx + ", nomCtx="
				+ nomCtx + ", prenomCtx=" + prenomCtx + "]";
	}

	public Set<Risque> getLesRisques() {
		return lesRisques;
	}

	public void setLesRisques(Set<Risque> lesRisques) {
		this.lesRisques = lesRisques;
	}

}
