package org.rmi.Classes;

import org.rmi.Interfaces.IAnimal;

import java.io.Serializable;
import java.rmi.RemoteException;


public class Animal implements IAnimal, Serializable {
    String name;
    String OwnerName;
    TrackingFiles trackingFile;
    Specie specie;


    public Animal(String name, String OwnerName) throws RemoteException {
        this.name=name;
        this.OwnerName=OwnerName;
        this.trackingFile = new TrackingFiles("Lorem Ipsum");
        this.specie = new Specie("Chien", 10);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getOwnerName() {
        return this.OwnerName;
    }

    @Override
    public TrackingFiles getTrackingFile() {
        return this.trackingFile;
    }

    @Override
    public Specie getSpecie() {
        return this.specie;
    }
}
