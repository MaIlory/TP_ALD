package org.rmi.client.Classes;

import org.rmi.Classes.Specie;
import org.rmi.Classes.TrackingFiles;
import org.rmi.Interfaces.IAnimal;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Mammal implements IAnimal, Serializable {
    String name;
    String ownerName;
    Specie specie;
    TrackingFiles files;

    public Mammal(String name, String ownerName) throws RemoteException {
        this.name = name;
        this.ownerName = ownerName;
        this.specie = new Specie("Rabbit", 5);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getOwnerName() {
        return this.ownerName;
    }

    @Override
    public TrackingFiles getTrackingFile() {
        return this.files;
    }

    @Override
    public Specie getSpecie() {
        return this.specie;
    }
}
