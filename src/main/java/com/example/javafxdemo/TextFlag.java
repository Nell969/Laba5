package com.example.javafxdemo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TextFlag extends Application {

    private RadioButton redBand1, greenBand1, blueBand1;
    private RadioButton redBand2, greenBand2, blueBand2;
    private RadioButton redBand3, greenBand3, blueBand3;
    private Label resultLabel;


    @Override
    public void start(Stage primaryStage) {
        // Создание радиокнопок для выбора цвета первой полосы
        redBand1 = new RadioButton("Красный");
        greenBand1 = new RadioButton("Зелёный");
        blueBand1 = new RadioButton("Синий");

        ToggleGroup group1 = new ToggleGroup();
        redBand1.setToggleGroup(group1);
        greenBand1.setToggleGroup(group1);
        blueBand1.setToggleGroup(group1);
        redBand1.setSelected(true); //Красный по умолчанию

        // Аналогично для второй и третьей полос
        redBand2 = new RadioButton("Красный");
        greenBand2 = new RadioButton("Зелёный");
        blueBand2 = new RadioButton("Синий");
        ToggleGroup group2 = new ToggleGroup();
        redBand2.setToggleGroup(group2);
        greenBand2.setToggleGroup(group2);
        blueBand2.setToggleGroup(group2);
        greenBand2.setSelected(true); //Зеленый по умолчанию


        redBand3 = new RadioButton("Красный");
        greenBand3 = new RadioButton("Зелёный");
        blueBand3 = new RadioButton("Синий");
        ToggleGroup group3 = new ToggleGroup();
        redBand3.setToggleGroup(group3);
        greenBand3.setToggleGroup(group3);
        blueBand3.setToggleGroup(group3);
        blueBand3.setSelected(true); //Синий по умолчанию

        // Кнопка "Нарисовать"
        Button drawButton = new Button("Нарисовать");
        drawButton.setOnAction(e -> handleDrawButton());

        // Лейбл для вывода результата
        resultLabel = new Label("Выберите цвета");
        resultLabel.setFont(new Font(20));

        // Размещение элементов в контейнерах
        VBox band1Box = new VBox(10, new Label("Первая полоса:"), redBand1, greenBand1, blueBand1);
        VBox band2Box = new VBox(10, new Label("Вторая полоса:"), redBand2, greenBand2, blueBand2);
        VBox band3Box = new VBox(10, new Label("Третья полоса:"), redBand3, greenBand3, blueBand3);
        HBox bandsBox = new HBox(20, band1Box, band2Box, band3Box);
        bandsBox.setAlignment(Pos.CENTER);
        bandsBox.setPadding(new Insets(20));

        VBox mainVBox = new VBox(20, bandsBox, drawButton, resultLabel);
        mainVBox.setAlignment(Pos.CENTER);
        mainVBox.setPadding(new Insets(20));


        // Создание сцены и установка её на сцену
        Scene scene = new Scene(mainVBox, 600, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Текстовый флаг");
        primaryStage.setResizable(false); // Запрет изменения размера окна
        primaryStage.show();
    }

    private void handleDrawButton() {
        String color1 = getColor(redBand1, greenBand1, blueBand1);
        String color2 = getColor(redBand2, greenBand2, blueBand2);
        String color3 = getColor(redBand3, greenBand3, blueBand3);
        resultLabel.setText(color1 + ", " + color2 + ", " + color3);
    }

    private String getColor(RadioButton red, RadioButton green, RadioButton blue) {
        if (red.isSelected()) return "Красный";
        else if (green.isSelected()) return "Зелёный";
        else return "Синий";
    }

    public static void main(String[] args) {
        launch(args);
    }
}

