package com.nee.demo.controller;

import com.alibaba.fastjson.JSON;
import com.nee.demo.orm.mapper.TestModelMapper;
import com.nee.demo.orm.model.DemoModel;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@FXMLController
public class StartController implements Initializable {

    private static Logger log = LoggerFactory.getLogger(StartController.class);

    @Resource
    private TestModelMapper testModelMapper;

    @FXML
    private Button btn;

    private ResourceBundle resourceBundle;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.info("===========>>> initialize ... <<<============");
        resourceBundle = resources;
    }

    @FXML
    public void btnClick(ActionEvent actionEvent) {
        log.info("===========>>> " + actionEvent.getSource().toString() + " <<<============");
        btn.setText("Congratulations");
        List<DemoModel> data = testModelMapper.queryAll();
        log.info("query: {}", JSON.toJSONString(data));
    }

}
