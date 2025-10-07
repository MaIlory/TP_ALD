package org.rmi.Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICabinet extends Remote {
    IAnimal getAnimal(String name) throws RemoteException;

    void addAnimal(IAnimal animal) throws RemoteException;

    void removeAnimal(IAnimal animal) throws RemoteException;
}
