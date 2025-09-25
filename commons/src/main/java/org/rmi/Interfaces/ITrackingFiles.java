package org.rmi.Interfaces;

import org.rmi.Classes.TrackingFiles;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ITrackingFiles extends Remote {
    String getTrackingFileContent();
    void setTrackingFileContent(String fileContent);
}
