package com.bna.ctx.model;

import java.io.Serializable;


public class requestBody implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5875425462754960403L;
	
	public int id;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public requestBody(int id) {
		super();
		this.id = id;
	}

	public requestBody() {
		super();
	}
	
	
}
