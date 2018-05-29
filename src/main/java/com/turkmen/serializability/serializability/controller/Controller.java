/**
 * 
 */
package com.turkmen.serializability.serializability.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkmen.serializability.serializability.model.Animal;
import com.turkmen.serializability.serializability.service.AnimalService;

/**
 * @author TTTDEMIRCI
 *
 */
@RestController
@RequestMapping("/serializeAnimal")
public class Controller {
	
	private AnimalService animalService;
	

	
	
	public Controller(AnimalService animalService) {
		super();
		this.animalService = animalService;
	}



	@PostMapping
	public String post(@RequestBody final Animal animal) {
		animalService.save(animal);
		
		return "animal is saved!";
	}

}
