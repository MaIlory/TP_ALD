package org.rmi.Classes;

import java.io.Serializable;
import java.rmi.RemoteException;

public class Specie implements Serializable {
    String name;
    int lifetime;
    String description;

    public Specie(String name, int lifetime) throws RemoteException {
        this.name = name;
        this.lifetime = lifetime;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getLifetime() {
        return lifetime;
    }
    public void setLifetime(int lifetime) {
        this.lifetime = lifetime;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
