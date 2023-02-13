package com.bna.ctx.model;

import java.io.Serializable;
import java.util.Date;

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

@Entity
@Table(name = "Frais")
public class Frais implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4443720704030894076L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "num_Frais", nullable = false, columnDefinition = "number(6,0)")
	@Comment("numéro du frais")
	private int numFrais;

	@Column(name = "type_Frais")
	@Comment("type du frais")
	private String typeFrais;

	@Column(name = "montant_Frais")
	@Comment("montant du Frais")
	private double montantFrais;

	@Column(name = "date_Frais")
	@Comment("date du frais")
	private Date dateFrais;

	@Column(name = "etat_Frais")
	@Comment("etat du frais")
	private String etatFrais;

	@Column(name = "num_piece")
	@Comment("numero du piece")
	private int numPiece;

	@Column(name = "CIN")
	@Comment("numero CIN")
	private int CIN;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@Comment("numero du risque")
	@JoinColumn(name = "numRisque")
	protected Risque risque;

	public int getNumFrais() {
		return numFrais;
	}

	public void setNumFrais(int numFrais) {
		this.numFrais = numFrais;
	}

	public String getTypeFrais() {
		return typeFrais;
	}

	public void setTypeFrais(String typeFrais) {
		this.typeFrais = typeFrais;
	}

	public double getMontantFrais() {
		return montantFrais;
	}

	public void setMontantFrais(double montantFrais) {
		this.montantFrais = montantFrais;
	}

	public Date getDateFrais() {
		return dateFrais;
	}

	public void setDateFrais(Date dateFrais) {
		this.dateFrais = dateFrais;
	}

	public String getEtatFrais() {
		return etatFrais;
	}

	public void setEtatFrais(String etatFrais) {
		this.etatFrais = etatFrais;
	}

	public int getNumPiece() {
		return numPiece;
	}

	public void setNumPiece(int numPiece) {
		this.numPiece = numPiece;
	}

	public int getCIN() {
		return CIN;
	}

	public void setCIN(int cIN) {
		CIN = cIN;
	}

	public Risque getRisque() {
		return risque;
	}

	public void setRisque(Risque risque) {
		this.risque = risque;
	}

	public Frais(int numFrais, String typeFrais, double montantFrais, Date dateFrais, String etatFrais, int numPiece,
			int cIN, Risque risque) {
		super();
		this.numFrais = numFrais;
		this.typeFrais = typeFrais;
		this.montantFrais = montantFrais;
		this.dateFrais = dateFrais;
		this.etatFrais = etatFrais;
		this.numPiece = numPiece;
		CIN = cIN;
		this.risque = risque;
	}

	public Frais() {
		super();
	}

	public Frais(String typeFrais, double montantFrais, Date dateFrais, String etatFrais, int numPiece, int CIN,
			Risque risque) {
		super();
		this.typeFrais = typeFrais;
		this.montantFrais = montantFrais;
		this.dateFrais = dateFrais;
		this.etatFrais = etatFrais;
		this.numPiece = numPiece;
		this.CIN = CIN;
		this.risque = risque;
	}

	@Override
	public String toString() {
		return "Frais [numFrais=" + numFrais + ", typeFrais=" + typeFrais + ", montantFrais=" + montantFrais
				+ ", dateFrais=" + dateFrais + ", etatFrais=" + etatFrais + ", numPiece=" + numPiece + ", CIN=" + CIN
				+ ", risque=" + risque + "]";
	}
}
