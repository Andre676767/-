package com.example.demo6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TestApp extends Application {

    @Override
    public void start(Stage stage) {
        Label label = new Label("✅ JavaFX работает!");
        label.setStyle("-fx-font-size: 24px; -fx-text-fill: green;");

        StackPane root = new StackPane(label);
        Scene scene = new Scene(root, 400, 300);

        stage.setTitle("Тест JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}