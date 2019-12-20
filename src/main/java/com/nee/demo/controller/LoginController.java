package com.nee.demo.controller;

import com.nee.demo.Main;
import com.nee.demo.cache.UserCache;
import com.nee.demo.orm.mapper.TestModelMapper;
import com.nee.demo.orm.model.DemoModel;
import com.nee.demo.view.Sample;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@FXMLController
public class LoginController implements Initializable {
    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @FXML
    private GridPane login;

    @FXML
    private Button loginBtn;

    @FXML
    private TextField userName;
    @FXML
    private PasswordField passwordField;

    @Resource
    private TestModelMapper query;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.info("LoginController:  {}" + resources);
    }

    @FXML
    private void handleSubmitButtonAction(ActionEvent event) throws Exception {
        String userNameStr = userName.getText().trim();
        String passwordStr = passwordField.getText().trim();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        String str = null;
        if (userNameStr == null && passwordStr == null) {
            str = "用户名和密码不能为空！";
        } else if (userNameStr == null) {
            str = "用户名不能为空！";
        } else if (userNameStr == null) {
            str = "密码不能为空！";
        }
        if (str != null) {
            alert.setContentText(str);
            alert.showAndWait();
            return;
        }
        List<DemoModel> list = query.queryByUserName(userNameStr);
        if (list.isEmpty()) {
            alert.setContentText("用户名错误，请检查用户名！");
            alert.showAndWait();
            return;
        } else {
            DemoModel info = checkLogin(userNameStr, passwordStr);
            // 登录
            if (info != null) {
                //FXMLLoader loader = new FXMLLoader(getClass().getResource("/static/fxml/sample.fxml"));
                //GridPane startPane = loader.load();
                //GUIState.getScene().setRoot(startPane);
//                GUIState.getScene().setRoot(successpage);
//                GUIState.getStage().setWidth(1000);
//                GUIState.getStage().setHeight(700);
//                GUIState.getStage().setX(150);
//                GUIState.getStage().setY(50);
//                GUIState.getStage().setTitle("Hello World");
//                GUIState.getStage().setResizable(true);
                UserCache.setData(info);
                //登录成功，跳转首页
                Main.showView(Sample.class);

            } else {
                alert.setContentText("请输入正确的密码！");
                alert.showAndWait();
            }
        }
    }

    /**
     * 弹框
     */
    public Parent successpage() {
        HBox hbox = new HBox();
        Label label = new Label("登录成功");
        hbox.getChildren().add(label);
        hbox.setAlignment(Pos.CENTER);
        return hbox;
    }

    /**
     * 判断账号和密码是否正确
     */
    private DemoModel checkLogin(String userName, String password) {
        return query.query(userName, password);
    }
}
