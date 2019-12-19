package com.nee.demo;

import com.nee.demo.view.LoginView;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main extends AbstractJavaFxApplicationSupport {

    public static void main(String[] args) {
        launch(Main.class, LoginView.class, new Splash(), args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        super.start(stage);
    }

    @Override
    public void beforeInitialView(Stage stage, ConfigurableApplicationContext ctx) {
        stage.setTitle("Login");
        stage.setWidth(500);
        stage.setHeight(400);
    }

    //重启
    public void relaunch() {
        Platform.runLater(() -> {
            getStage().close();
            try {
                this.stop();
                this.init();
                this.start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
