package com.example.pjatkpasswordmanagerv3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LogIn {

    public LogIn(){

    }

    @FXML
    private Button zaloguj;
    @FXML
    private Label wrongLogin;
    @FXML
    private TextField login;
    @FXML
    private PasswordField password;


    public void userLogIn(ActionEvent actionEvent) throws IOException {
        checkLogin();
    }

    private void checkLogin() throws IOException {
        Main m = new Main();
        if(verifyLogin(login.getText(), password.getText(),"password.txt")) {
            wrongLogin.setText("Success!");

            m.changeScene("afterLogin.fxml", 2);

        } else if (login.getText().isEmpty() && password.getText().isEmpty()) {
            wrongLogin.setText("Wpisz login lub hasło.");
        } else {
            wrongLogin.setText("Zły login lub hasło!");
        }


    }

    private  static Scanner x;
    public static boolean verifyLogin(String username, String password, String filepath){
        boolean found = false;
        String tempUsername = "";
        String tempPassword = "";

        try {
            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");

            while (x.hasNext() && !found) {
                tempUsername = x.next();
                tempPassword = x.next();

                if(tempUsername.trim().equals(username.trim()) && tempPassword.trim().equals(password.trim())){
                    found = true;
                }
            }
            x.close();

        }catch (Exception e){
            found = false;
        }
        return found;
    }

}
