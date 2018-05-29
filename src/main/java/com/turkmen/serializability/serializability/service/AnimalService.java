/**
 * 
 */
package com.turkmen.serializability.serializability.service;

import java.io.IOException;
import java.io.ObjectOutputStream;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.stereotype.Service;

import com.turkmen.serializability.serializability.model.Animal;
import com.turkmen.serializability.serializability.model.SerializedAnimal;
import com.turkmen.serializability.serializability.repository.SerializedAnimalRepo;

/**
 * @author TTTDEMIRCI
 *
 */

@Service
public class AnimalService {

	private SerializedAnimalRepo serializedAnimalRepo;

	public AnimalService(SerializedAnimalRepo serializedAnimalRepo) {
		super();
		this.serializedAnimalRepo = serializedAnimalRepo;
	}

	public void save(Animal animal) {

		byte[] serializedAnimalByteArr = serialize(animal);

		SerializedAnimal serializedAnimal = new SerializedAnimal(serializedAnimalByteArr);

		this.serializedAnimalRepo.save(serializedAnimal);

	}

	private byte[] serialize(Animal animal) {

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

			objectOutputStream.writeObject(animal);

			return byteArrayOutputStream.toByteArray();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
