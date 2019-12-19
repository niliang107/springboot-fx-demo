package com.nee.demo;

import com.nee.demo.view.LoginView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoginViewTest extends ApplicationGuiTests<LoginView> {

    @Test
    public void testLoginBtn_Anton() {
        clickOn("#userName").write("Apple")
                .clickOn("#passwordField").write("1234567");

        TextField username = find("#userName");
        assertEquals("Apple", username.getText());
        PasswordField passwordField = find("#passwordField");
        assertEquals("1234567", passwordField.getText());
    }

    @After
    public void print() {
        TextField username = find("#userName");
        PasswordField passwordField = find("#passwordField");
        System.out.println("userName=" + username.getText() + ", password=" + passwordField.getText());
        reset();
        System.out.println("userName=" + username.getText() + ", password=" + passwordField.getText());
    }

    @Override
    public void reset() {
        TextField username = find("#userName");
        username.setText("");
        PasswordField password = find("#passwordField"); //fx:id
        password.setText("");
    }
}
