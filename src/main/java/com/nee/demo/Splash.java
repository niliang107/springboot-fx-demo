package com.nee.demo;


import de.felixroske.jfxsupport.SplashScreen;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/***
 * 启动时的闪屏
 */
public class Splash extends SplashScreen {

    @Override
    public Parent getParent() {
//        Group gp = new Group();
//        ImageView imageView = new ImageView(this.getClass().getResource(this.getImagePath()).toExternalForm());
//        gp.getChildren().add(imageView);
//        return gp;
        final ImageView imageView = new ImageView(getClass().getResource(getImagePath()).toExternalForm());
        final ProgressBar splashProgressBar = new ProgressBar();
        splashProgressBar.setPrefWidth(imageView.getImage().getWidth());

        final VBox vbox = new VBox();
        vbox.getChildren().addAll(imageView, splashProgressBar);
        return vbox;
    }

    @Override
    public String getImagePath() {
        return "/static/images/a1f18.jpg";
    }

    @Override
    public boolean visible() {
        return true;
    }
}
