package com.nee.demo;

import com.nee.demo.view.LoginView;
import com.xwintop.xcore.util.javafx.AlertUtil;
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
        stage.setOnCloseRequest(event -> {
            if (AlertUtil.showConfirmAlert("确定要退出吗？")) {
                Platform.exit();
                System.exit(0);
            } else {
                event.consume();
            }
        });
    }

    @Override
    public void beforeInitialView(Stage stage, ConfigurableApplicationContext ctx) {
        stage.setTitle("Login");
        stage.setWidth(500);
        stage.setHeight(400);
    }
}
