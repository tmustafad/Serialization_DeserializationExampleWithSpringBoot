/**
 * 
 */
package com.turkmen.serializability.serializability.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkmen.serializability.serializability.model.Animal;
import com.turkmen.serializability.serializability.service.AnimalServiceImpl;

/**
 * @author TTTDEMIRCI
 *
 */
@RestController
@RequestMapping("/serializeAnimal")
public class SerializationController {
	
	private AnimalServiceImpl animalService;
	

	
	
	public SerializationController(AnimalServiceImpl animalService) {
		super();
		this.animalService = animalService;
	}



	@PostMapping
	public String post(@RequestBody final Animal animal) throws Exception {
		animalService.save(animal);
		
		return "animal is saved!";
	}

}
