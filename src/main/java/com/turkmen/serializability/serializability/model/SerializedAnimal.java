/**
 * 
 */
package com.turkmen.serializability.serializability.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author TTTDEMIRCI
 *
 */

@Entity
@Table
public class SerializedAnimal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private byte[] serializedAnimal;

	public SerializedAnimal(byte[] serializedAnimal) {
		super();

		this.serializedAnimal = serializedAnimal;
	}

	public SerializedAnimal() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public byte[] getSerializedAnimal() {
		return serializedAnimal;
	}

	public void setSerializedAnimal(byte[] serializedAnimal) {
		this.serializedAnimal = serializedAnimal;
	}

}
