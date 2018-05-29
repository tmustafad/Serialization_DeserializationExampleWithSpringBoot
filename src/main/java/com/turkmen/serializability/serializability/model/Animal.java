/**
 * 
 */
package com.turkmen.serializability.serializability.model;

import java.io.Serializable;

/**
 * @author TTTDEMIRCI
 *
 */
public class Animal implements Serializable{

	
	private static final long serialVersionUID = -8796619172458378159L;
	private String name;
	private String type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
