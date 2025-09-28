package org.rmi.server.impl;

import org.rmi.Classes.Animal;
import org.rmi.Interfaces.ICabinet;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.util.ArrayList;

@Service
public class Cabinet implements ICabinet {
    ArrayList<Animal> animals = new ArrayList<Animal>();

    public Cabinet() throws RemoteException {
        Animal animal1 = new Animal("Puppy", "Denis");
        Animal animal2 = new Animal("Dago", "Albert");
        Animal animal3 = new Animal("Tenko", "Sylvie");
        addAnimal(animal1);
        addAnimal(animal2);
        addAnimal(animal3);
    }

    @Override
    public Animal getAnimal(String name) throws RemoteException {
        for (Animal animal : animals) {
            if (animal.getName().equals(name)) {
                return animal;
            }
        }
        return null;
    }

    public void addAnimal(Animal animal) throws RemoteException {
        animals.add(animal);
    }

    public void removeAnimal(Animal animal) throws RemoteException {
        animals.remove(animal);
    }
}
