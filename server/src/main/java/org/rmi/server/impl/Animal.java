package org.rmi.server.impl;

import org.rmi.Classes.Specie;
import org.rmi.Classes.TrackingFiles;
import org.rmi.Interfaces.IAnimal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;

@Service
public class Animal implements IAnimal{
    String name;
    String OwnerName;
    TrackingFiles trackingFile;
    Specie specie;


    public Animal(@Value("${Animal.name}") String name, @Value("${Animal.ownerName}") String OwnerName) throws RemoteException {
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
