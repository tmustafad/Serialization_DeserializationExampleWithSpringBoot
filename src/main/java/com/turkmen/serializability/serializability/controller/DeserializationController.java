/**
 * 
 */
package com.turkmen.serializability.serializability.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkmen.serializability.serializability.model.Animal;
import com.turkmen.serializability.serializability.service.IAnimalService;

/**
 * @author TTTDEMIRCI
 *
 */

@RestController
@RequestMapping("/deserializeAnimal")
public class DeserializationController {

	private IAnimalService animalService;

	public DeserializationController(IAnimalService animalService) {
		super();
		this.animalService = animalService;
	}

	@GetMapping
	public List<Animal> getAnimals() throws Exception {
		return animalService.getAnimals();
	}
}
