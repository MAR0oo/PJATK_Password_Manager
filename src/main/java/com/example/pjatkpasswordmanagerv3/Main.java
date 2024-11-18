package com.example.pjatkpasswordmanagerv3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static final int width = 700;
    private static final int height = 500;

    private static Stage stg;
    private static Scene css;

    @Override
    public void start(Stage primarystage) throws IOException {
        String css1 = this.getClass().getResource("login.css").toExternalForm();
        String css2 = this.getClass().getResource("aftelogin.css").toExternalForm();

        stg = primarystage;

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), width, height);

        css = scene;

        //scene.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
        scene.getStylesheets().add(css1);
        primarystage.setTitle("Password Manager");
        primarystage.setScene(scene);
        primarystage.show();
        primarystage.setResizable(false);

    }

        public void changeScene (String fxml, int a) throws IOException {
            Parent pane = FXMLLoader.load(getClass().getResource(fxml));
            stg.getScene().setRoot(pane);
            switch (a) {
                case 2 -> {
                    css.getStylesheets().add(this.getClass().getResource("aftelogin.css").toExternalForm());
                    stg.setResizable(true);
                }
                default -> {
                    stg.getScene().getRoot().getStylesheets().add(this.getClass().getResource("login.css").toExternalForm());
                    stg.setResizable(false);
                    stg.setWidth(width);
                    stg.setHeight(height);
                }
            }

        }


    public static void main(String[] args) {
        launch();
    }
}

