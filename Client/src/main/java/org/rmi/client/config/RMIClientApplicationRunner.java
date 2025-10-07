package org.rmi.client.config;

import org.rmi.Interfaces.IAnimal;
import org.rmi.client.Classes.Mammal;
import org.rmi.Classes.Specie;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.stereotype.Component;
import org.rmi.Interfaces.ICabinet;

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
        // Récupération de l'instance de *** via le proxy
        ICabinet serviceCabinet = (ICabinet) proxy.getObject();

        assert serviceCabinet != null;

        /*IAnimal animal = serviceCabinet.getAnimal("Tenko");
        Specie specie = animal.getSpecie();

        System.out.println("Animal Owner Name: " + animal.getOwnerName());
        System.out.println("Specie Name: " + specie.getName());
*/
        Mammal animal2 = new Mammal("Roger", "David");
        animal2.getSpecie().setName("Rabbit");
        animal2.getSpecie().setLifetime(3);
        //animal2.getTrackingFile().setTrackingFileContent("This is the file content of Roger Rabbit.");

        serviceCabinet.addAnimal(animal2);

        IAnimal animal3 = serviceCabinet.getAnimal("Roger");
        Specie specie3 = animal3.getSpecie();

        System.out.println("Animal Owner Name: " + animal3.getOwnerName());
        System.out.println("Specie Name: " + specie3.getName());

    }
}