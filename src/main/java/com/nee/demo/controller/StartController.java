package com.nee.demo.controller;

import com.nee.demo.cache.UserCache;
import com.nee.demo.orm.mapper.TestModelMapper;
import com.nee.demo.orm.model.DemoModel;
import de.felixroske.jfxsupport.FXMLController;
import de.felixroske.jfxsupport.GUIState;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@FXMLController
public class StartController implements Initializable {

    private static Logger log = LoggerFactory.getLogger(StartController.class);

    @Resource
    private TestModelMapper testModelMapper;

    @FXML
    private Button btn;
    @FXML
    private Label loginTips;

    @FXML
    private TableColumn<DemoModel, String> id;
    @FXML
    private TableColumn<DemoModel, String> username;
    @FXML
    private TableColumn<DemoModel, String> age;
    @FXML
    private TableColumn<DemoModel, String> createTime;

    @FXML
    private TableView<DemoModel> tableView01;
    @FXML
    private TextField queryKey;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.info("===========>>> initialize ... <<<============");
        String loginUser = UserCache.getData() == null ? "" : UserCache.getData().getUserName();
        loginTips.setText(loginTips.getText() + loginUser);
        GUIState.getStage().setWidth(620);
        GUIState.getStage().setHeight(360);
        GUIState.getStage().setTitle("Hello World");
        GUIState.getStage().setResizable(true);
    }

    @FXML
    public void btnClick(ActionEvent actionEvent) {
        String key = queryKey.getText();
        List<DemoModel> list = new ArrayList<>();
        if (null == key || "".equals(key)) {
            list = testModelMapper.queryAll();
        } else {
            list = testModelMapper.queryByUserName(key);
        }


        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        //id.setCellFactory(TextFieldTableCell.forTableColumn());
        username.setCellValueFactory(new PropertyValueFactory<>("userName"));
        //username.setCellFactory(TextFieldTableCell.forTableColumn());
        age.setCellValueFactory(new PropertyValueFactory<>("age"));
        //age.setCellFactory(TextFieldTableCell.forTableColumn());
        createTime.setCellValueFactory(new PropertyValueFactory<>("createTime"));
        //createTime.setCellFactory(TextFieldTableCell.forTableColumn());

        /*List<DemoModelProperty> dataProperty = new ArrayList<>();
        for (DemoModel demoModel : list) {
            DemoModelProperty p = new DemoModelProperty(demoModel.getId(), demoModel.getUserName(), demoModel.getAge(), demoModel.getCreateTime().getTime());
            dataProperty.add(p);
        }*/
        ObservableList<DemoModel> data = FXCollections.observableArrayList(list);
        tableView01.setItems(data);
    }

}
