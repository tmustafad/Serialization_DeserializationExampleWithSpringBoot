/**
 * 
 */
package com.turkmen.serializability.serializability.service;

import java.util.List;

import com.turkmen.serializability.serializability.model.Animal;

/**
 * @author TTTDEMIRCI
 *
 */
public interface IAnimalService {
	
	void save(Animal animal) throws Exception;
	
	List<Animal> getAnimals() throws Exception;

}
