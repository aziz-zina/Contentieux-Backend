package com.bna.ctx.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Comment;

@Entity
@Table(name = "Utilisateur")
public class Utilisateur implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6533977502904499229L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "matricule_user", nullable = false, columnDefinition = "number(6,0)")
	@Comment("Matricule de l'utilisateur")
	private int matricule;

	@Column(name = "mot_de_passe")
	@Comment("Mot de passe de l'utilisateur")
	private String password;
	
	@Column(name = "nom_user")
	@Comment("nom de l'utilisateur")
	private String nomUser;
	
	@Column(name = "prenom_user")
	@Comment("prenom de l'utilisateur")
	private String prenomUser;
	
	@Column(name = "grade")
	@Comment("grade de l'utilisateur")
	private String grade;

	public int getMatricule() {
		return matricule;
	}

	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNomUser() {
		return nomUser;
	}

	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}

	public String getPrenomUser() {
		return prenomUser;
	}

	public void setPrenomUser(String prenomUser) {
		this.prenomUser = prenomUser;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Utilisateur(int matricule, String password, String nomUser, String prenomUser, String grade) {
		super();
		this.matricule = matricule;
		this.password = password;
		this.nomUser = nomUser;
		this.prenomUser = prenomUser;
		this.grade = grade;
	}

	public Utilisateur() {
		super();
	}

	@Override
	public String toString() {
		return "Utilisateur [matricule=" + matricule + ", password=" + password + ", nomUser=" + nomUser
				+ ", prenomUser=" + prenomUser + ", grade=" + grade + "]";
	}
	
}
