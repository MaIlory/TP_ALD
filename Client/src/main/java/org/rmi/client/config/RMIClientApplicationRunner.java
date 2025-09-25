package org.rmi.client.config;

import org.rmi.Classes.Specie;
import org.rmi.Classes.TrackingFiles;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.stereotype.Component;
import org.rmi.Interfaces.IAnimal;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Composant qui s'exécute lors du démarrage de l'application
@Component
public class RMIClientApplicationRunner implements ApplicationRunner {
    private RmiProxyFactoryBean proxy; // Proxy pour le service RMI

    // Injection de dépendance du proxy RMI
    public RMIClientApplicationRunner(RmiProxyFactoryBean proxy) {
        this.proxy = proxy;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        int choice = 0;
        // Récupération de l'instance de *** via le proxy
        IAnimal serviceAnimal = (IAnimal) proxy.getObject();
        // Invocation de la méthode helloWorld et affichage du résultat

        /*while (choice != 3) {
            System.out.println("Type 1 to get your animal's tracking file\n" +
                    "Type 2 to modify your animal's tracking file" +
                    "Type 3 to quit");
            choice = System.in.read();
            if (choice == '1') {
                System.out.println(serviceAnimal.getTrackingFile().getTrackingFile());
            }
            if (choice == '2') {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                serviceAnimal.getTrackingFile().setTrackingFile(br.readLine());
            }
        }*/
        System.out.println(serviceAnimal.getName());

        Specie specie = serviceAnimal.getSpecie();
        System.out.println(specie.getName());

        TrackingFiles trackigTrackingFiles = serviceAnimal.getTrackingFile();

        System.out.println(trackigTrackingFiles.getTrackingFileContent());
        trackigTrackingFiles.setTrackingFileContent("Test du doosier de suivi");
        System.out.println(trackigTrackingFiles.getTrackingFileContent());
    }
}