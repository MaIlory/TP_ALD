package org.rmi.Classes;

import org.rmi.Interfaces.ITrackingFiles;

import java.io.Serializable;
import java.rmi.RemoteException;

public class TrackingFiles implements ITrackingFiles, Serializable {
    String fileContent;

    public TrackingFiles(String fileContent) throws RemoteException {
        this.fileContent = fileContent;
    }

    public String getTrackingFileContent(){
        return this.fileContent;
    }
    public void setTrackingFileContent(String fileContent){
        this.fileContent = fileContent;
    }
}
