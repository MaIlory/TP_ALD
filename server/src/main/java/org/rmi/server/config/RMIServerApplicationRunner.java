package org.rmi.server.config;

import java.rmi.Naming;
import java.util.logging.Logger;

import org.rmi.Interfaces.IAnimal;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.stereotype.Component;
import org.rmi.server.impl.Animal;

// Composant qui s'exécute lors du démarrage de l'application
@Component
public class RMIServerApplicationRunner implements ApplicationRunner {
    private Animal animal;
    private Logger logger = Logger.getLogger(this.getClass().getName());
    // Injection de dépendance de Animal
    public RMIServerApplicationRunner(Animal animal) {
        this.animal = animal;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
    // Liste des services RMI enregistrés
        for (String serviceName : Naming.list("rmi://localhost:1099")) {
            System.out.println("Service RMI enregistré : " + serviceName);
        }
    }
    // Exposition du service HelloService en tant que service RMI
    @Bean
    RmiServiceExporter helloServiceExporter() {
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceName(IAnimal.class.getSimpleName()); // Nom du service
        exporter.setServiceInterface(IAnimal.class); // Interface du service
        exporter.setService(animal); // Implémentation du service
        exporter.setRegistryPort(1099); // Port pour le registre RMI
        logger.info("Serveur RMI démarré sur le port 1099"); // Journalisation du démarrage du serveur
        return exporter; // Retourne l'exportateur de service RMI
    }
}