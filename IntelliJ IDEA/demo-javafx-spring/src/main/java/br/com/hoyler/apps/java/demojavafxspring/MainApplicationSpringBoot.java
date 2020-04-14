package br.com.hoyler.apps.java.demojavafxspring;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;

public class MainApplicationSpringBoot extends Application {

    private ConfigurableApplicationContext configurableApplicationContext;

    @Override
    public void init() {
        configurableApplicationContext = new SpringApplicationBuilder(MainApplication.class).run();
    }

    @Override
    public void stop() {
        configurableApplicationContext.close();
        Platform.exit();
    }

    @Override
    public void start(Stage stage) {
        configurableApplicationContext.publishEvent(new StageReadyEvent(stage));
    }

    public static class StageReadyEvent extends ApplicationEvent {

		private static final long serialVersionUID = -1689978865221177258L;

		public StageReadyEvent(Stage stage) {
            super(stage);
        }

        public Stage getStage(){
            return ((Stage)getSource());
        }
    }
}
