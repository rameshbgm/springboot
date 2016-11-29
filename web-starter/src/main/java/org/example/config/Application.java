package org.example.config;



import org.example.PackageScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = PackageScan.class)
public class Application {

    /**
     * Entry point for the application.
     */
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }


    
}
