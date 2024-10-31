package com.example.javafxdemo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculator extends Application {

    private TextField display;
    private double operand1 = 0;
    private String operator = "";

    @Override
    public void start(Stage primaryStage) {
        display = new TextField();
        display.setEditable(false);
        display.setAlignment(Pos.CENTER_RIGHT);

        Button btn0 = new Button("0");
        Button btn1 = new Button("1");
        Button btn2 = new Button("2");
        Button btn3 = new Button("3");
        Button btn4 = new Button("4");
        Button btn5 = new Button("5");
        Button btn6 = new Button("6");
        Button btn7 = new Button("7");
        Button btn8 = new Button("8");
        Button btn9 = new Button("9");
        Button btnPlus = new Button("+");
        Button btnMinus = new Button("-");
        Button btnMultiply = new Button("*");
        Button btnDivide = new Button("/");
        Button btnEquals = new Button("=");
        Button btnClear = new Button("C");
        Button btnDecimal = new Button(".");


        //Обработчики событий для кнопок
        btn0.setOnAction(e -> handleNumber("0"));
        btn1.setOnAction(e -> handleNumber("1"));
        btn2.setOnAction(e -> handleNumber("2"));
        btn3.setOnAction(e -> handleNumber("3"));
        btn4.setOnAction(e -> handleNumber("4"));
        btn5.setOnAction(e -> handleNumber("5"));
        btn6.setOnAction(e -> handleNumber("6"));
        btn7.setOnAction(e -> handleNumber("7"));
        btn8.setOnAction(e -> handleNumber("8"));
        btn9.setOnAction(e -> handleNumber("9"));
        btnPlus.setOnAction(e -> handleOperator("+"));
        btnMinus.setOnAction(e -> handleOperator("-"));
        btnMultiply.setOnAction(e -> handleOperator("*"));
        btnDivide.setOnAction(e -> handleOperator("/"));
        btnEquals.setOnAction(e -> handleEquals());
        btnClear.setOnAction(e -> handleClear());
        btnDecimal.setOnAction(e -> handleDecimal());


        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        grid.add(display, 0, 0, 4, 1);
        grid.add(btn7, 0, 1);
        grid.add(btn8, 1, 1);
        grid.add(btn9, 2, 1);
        grid.add(btnDivide, 3, 1);
        grid.add(btn4, 0, 2);
        grid.add(btn5, 1, 2);
        grid.add(btn6, 2, 2);
        grid.add(btnMultiply, 3, 2);
        grid.add(btn1, 0, 3);
        grid.add(btn2, 1, 3);
        grid.add(btn3, 2, 3);
        grid.add(btnMinus, 3, 3);
        grid.add(btn0, 0, 4);
        grid.add(btnDecimal, 1, 4);
        grid.add(btnEquals, 2, 4);
        grid.add(btnPlus, 3, 4);
        grid.add(btnClear, 0,5);


        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setTitle("Калькулятор");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private void handleNumber(String number) {
        display.setText(display.getText() + number);
    }

    private void handleOperator(String op) {
        if (!display.getText().isEmpty()) {
            operand1 = Double.parseDouble(display.getText());
            operator = op;
            display.clear();
        }
    }

    private void handleEquals() {
        if (!display.getText().isEmpty() && !operator.isEmpty()) {
            double operand2 = Double.parseDouble(display.getText());
            double result = 0;
            try {
                switch (operator) {
                    case "+":
                        result = operand1 + operand2;
                        break;
                    case "-":
                        result = operand1 - operand2;
                        break;
                    case "*":
                        result = operand1 * operand2;
                        break;
                    case "/":
                        if (operand2 == 0) {
                            display.setText("Ошибка: деление на ноль");
                            return;
                        }
                        result = operand1 / operand2;
                        break;
                }
                display.setText(String.valueOf(result));
                operand1 = result;
                operator = "";
            } catch (NumberFormatException ex) {
                display.setText("Ошибка ввода");
            }
        }
    }

    private void handleClear() {
        display.clear();
        operand1 = 0;
        operator = "";
    }

    private void handleDecimal() {
        if (!display.getText().contains(".")) {
            display.setText(display.getText() + ".");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
