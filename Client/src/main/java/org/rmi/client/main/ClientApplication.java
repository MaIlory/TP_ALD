package org.rmi.client.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication(scanBasePackages = {
        "org.rmi.client.config", // Package pour la configuration
        "org.rmi.client.Classes"
})
public class ClientApplication {

    public static void main(String[] args) {
        Path cheminRelatif = Paths.get("target", "classes");
        Path cheminAbsolu = cheminRelatif.toAbsolutePath();
        String codebaseUrl = cheminAbsolu.toUri().toString();  // Ajoute file://

        System.setProperty("java.rmi.server.codebase", codebaseUrl);
        System.setProperty("java.security.policy", "client.policy");
        SpringApplication.run(ClientApplication.class, args); // Démarre l'application Spring Boot


    }

}
