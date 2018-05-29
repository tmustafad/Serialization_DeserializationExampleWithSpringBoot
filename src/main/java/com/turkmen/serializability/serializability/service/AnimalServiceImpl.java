/**
 * 
 */
package com.turkmen.serializability.serializability.service;

import java.io.ByteArrayInputStream;
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
public class AnimalServiceImpl  implements IAnimalService{

	private SerializedAnimalRepo serializedAnimalRepo;

	public AnimalServiceImpl(SerializedAnimalRepo serializedAnimalRepo) {
		super();
		this.serializedAnimalRepo = serializedAnimalRepo;
	}

	public void save(Animal animal) throws Exception {

		byte[] serializedAnimalByteArr = serialize(animal);

		SerializedAnimal serializedAnimal = new SerializedAnimal(serializedAnimalByteArr);

		this.serializedAnimalRepo.save(serializedAnimal);

	}
	
	
	

	private byte[] serialize(Animal animal) throws IOException {

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
		try {

			objectOutputStream.writeObject(animal);

			return byteArrayOutputStream.toByteArray();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			objectOutputStream.close();
		}

		return null;
	}

}
