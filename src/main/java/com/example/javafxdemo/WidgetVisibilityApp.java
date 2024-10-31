package com.example.javafxdemo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WidgetVisibilityApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Widget Visibility Example");

        Label label1 = new Label("Label 1");
        Label label2 = new Label("Label 2");
        Label label3 = new Label("Label 3");

        CheckBox checkBox1 = new CheckBox("Show Label 1");
        CheckBox checkBox2 = new CheckBox("Show Label 2");
        CheckBox checkBox3 = new CheckBox("Show Label 3");

        checkBox1.selectedProperty().addListener((observable, oldValue, newValue) -> {
            label1.setVisible(newValue);
        });
        checkBox2.selectedProperty().addListener((observable, oldValue, newValue) -> {
            label2.setVisible(newValue);
        });
        checkBox3.selectedProperty().addListener((observable, oldValue, newValue) -> {
            label3.setVisible(newValue);
        });

        VBox vbox = new VBox(10, checkBox1, label1, checkBox2, label2, checkBox3, label3);
        vbox.setStyle("-fx-padding: 10;");

        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

