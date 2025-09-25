package org.rmi.Interfaces;


import org.rmi.Classes.Specie;
import org.rmi.Classes.TrackingFiles;

public interface IAnimal {
    String getName();
    String getOwnerName();
    TrackingFiles getTrackingFile();
    Specie getSpecie();
}
