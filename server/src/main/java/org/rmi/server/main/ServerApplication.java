package org.rmi.server.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "org.rmi.server.impl", // Package pour l'implémentation du service
        "org.rmi.server.config" // Package pour la configuration
})
public class ServerApplication {

    public static void main(String[] args) {

        System.setProperty("java.security.policy", "server.policy");
        SpringApplication.run(ServerApplication.class, args); // Démarre l'application Spring Boot
    }

}
