package org.rmi.Interfaces;

import org.rmi.Classes.Animal;

import java.rmi.RemoteException;

public interface ICabinet {
    Animal getAnimal(String name) throws RemoteException;

    void addAnimal(Animal animal) throws RemoteException;

    void removeAnimal(Animal animal) throws RemoteException;
}
