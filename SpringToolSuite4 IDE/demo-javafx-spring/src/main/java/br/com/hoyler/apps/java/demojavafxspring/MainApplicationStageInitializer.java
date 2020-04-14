package br.com.hoyler.apps.java.demojavafxspring;


import br.com.hoyler.apps.java.demojavafxspring.tools.ViewFXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MainApplicationStageInitializer implements ApplicationListener<MainApplicationSpringBoot.StageReadyEvent> {


    private String applicationTitle;
    private ApplicationContext applicationContext;

    public MainApplicationStageInitializer(@Value("${spring.application.ui.title}") String applicationTitle, ApplicationContext applicationContext) {
        this.applicationTitle = applicationTitle;
        this.applicationContext = applicationContext;
    }

    @Override
    public void onApplicationEvent(MainApplicationSpringBoot.StageReadyEvent stageReadyEvent) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ViewFXML.LOGIN.getFilePatch()));
            fxmlLoader.setControllerFactory(aClass -> this.applicationContext.getBean(aClass));
            Parent parent = fxmlLoader.load();

            Stage stage = stageReadyEvent.getStage();
            stage.setTitle(applicationTitle);
            stage.setScene(new Scene(parent, stage.getWidth(), stage.getHeight()));
            stage.show();

        } catch (IOException e) {
          throw new RuntimeException();
        }
    }
}
