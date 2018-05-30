/**
 * 
 */
package com.turkmen.serializability.serializability.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.stream.Collectors;

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
public class AnimalServiceImpl implements IAnimalService {

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

	@Override
	public List<Animal> getAnimals() throws Exception {
		return serializedAnimalRepo.findAll().stream().map(serializedAnimal -> {
			try {
				return deserialize(serializedAnimal.getSerializedAnimal());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}).collect(Collectors.toList());

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

	private Animal deserialize(byte[] serializedAnimal) throws IOException, ClassNotFoundException {

		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(serializedAnimal);
		ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
		try {

			Animal animal = (Animal) objectInputStream.readObject();

			return animal;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			objectInputStream.close();
		}

		return null;
	}

}
