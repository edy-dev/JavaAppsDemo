package br.com.hoyler.apps.java.demojavafxspring;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import static javafx.application.Application.*;


@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        launch(MainApplicationSpringBoot.class, args);
        System.out.print("End");
    }
}
