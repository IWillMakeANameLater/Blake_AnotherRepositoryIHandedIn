package com.school.test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml")); //load fxml document (get as a resource - important for when it becomes one file)
        Scene scene = new Scene(fxmlLoader.load(), 320, 240); // Size of the window
        stage.setTitle("Hello!");
        stage.setScene(scene); //Scene contains all the 'nodes', or the objects of the GUI e.g. buttons etc.
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}