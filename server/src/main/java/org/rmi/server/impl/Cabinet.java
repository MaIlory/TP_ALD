package org.rmi.server.impl;

import org.rmi.Interfaces.IAnimal;
import org.rmi.Interfaces.ICabinet;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.util.ArrayList;

@Service
public class Cabinet implements ICabinet {
    ArrayList<IAnimal> animals = new ArrayList<IAnimal>();

    public Cabinet() throws RemoteException {
        /*IAnimal animal1 = new IAnimal("Puppy", "Denis");
        IAnimal animal2 = new IAnimal("Dago", "Albert");
        IAnimal animal3 = new IAnimal("Tenko", "Sylvie");
        addAnimal(animal1);
        addAnimal(animal2);
        addAnimal(animal3);*/
    }

    @Override
    public IAnimal getAnimal(String name) throws RemoteException {
        for (IAnimal animal : animals) {
            if (animal.getName().equals(name)) {
                return animal;
            }
        }
        return null;
    }

    public void addAnimal(IAnimal animal) throws RemoteException {
        animals.add(animal);
    }

    public void removeAnimal(IAnimal animal) throws RemoteException {
        animals.remove(animal);
    }
}
