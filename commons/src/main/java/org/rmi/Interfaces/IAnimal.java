package org.rmi.Interfaces;


import org.rmi.Classes.Specie;
import org.rmi.Classes.TrackingFiles;

import java.rmi.Remote;

public interface IAnimal extends Remote {
    String getName();
    String getOwnerName();
    TrackingFiles getTrackingFile();
    Specie getSpecie();
}
