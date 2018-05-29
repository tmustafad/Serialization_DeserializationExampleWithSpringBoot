/**
 * 
 */
package com.turkmen.serializability.serializability.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkmen.serializability.serializability.model.SerializedAnimal;

/**
 * @author TTTDEMIRCI
 *
 */
public interface SerializedAnimalRepo extends JpaRepository<SerializedAnimal, Integer> {

}
