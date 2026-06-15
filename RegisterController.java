package com.example.demo6;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class RegisterController {

    @FXML private TextField regUsername;
    @FXML private PasswordField regPassword;
    @FXML private TextField regEmail;
    @FXML private TextField regFullName;
    @FXML private TextField regPhone;
    @FXML private Label messageLabel;

    private UserService userService = UserService.getInstance();

    @FXML
    private void handleRegister() {
        String username = regUsername.getText().trim();
        String password = regPassword.getText().trim();
        String email = regEmail.getText().trim();
        String fullName = regFullName.getText().trim();
        String phone = regPhone.getText().trim();

        // Проверка имени пользователя
        if (username.isEmpty() || username.length() < 3) {
            showError("Имя пользователя должно содержать минимум 3 символа");
            return;
        }

        // Проверка пароля
        if (password.isEmpty() || password.length() < 4) {
            showError("Пароль должен содержать минимум 4 символа");
            return;
        }

        // Проверка email
        if (email.isEmpty() || !email.contains("@")) {
            showError("Введите корректный email");
            return;
        }

        // Проверка телефона
        if (phone.isEmpty()) {
            showError("Введите номер телефона");
            return;
        }

        // Регистрация через UserService
        if (userService.регистрация(username, password, email)) {
            showSuccess("Регистрация успешна! Теперь вы можете войти.");
            backToLogin();
        } else {
            showError("Пользователь с таким именем уже существует");
        }
    }

    @FXML
    private void backToLogin() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login-view.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Авторизация - Мебельный магазин");
            stage.setScene(new Scene(root, 450, 550));
            stage.setResizable(false);
            stage.show();

            // Закрыть текущее окно
            Stage currentStage = (Stage) regUsername.getScene().getWindow();
            currentStage.close();

        } catch (Exception e) {
            e.printStackTrace();
            showError("Ошибка открытия окна входа!");
        }
    }

    @FXML
    private void goToLogin() {
        backToLogin();
    }

    private void showError(String message) {
        messageLabel.setText(message);
        messageLabel.setStyle("-fx-text-fill: red;");
    }

    private void showSuccess(String message) {
        messageLabel.setText(message);
        messageLabel.setStyle("-fx-text-fill: green;");
    }
}