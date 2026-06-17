package com.example.demo6;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginController {

    @FXML private TextField loginUsername;
    @FXML private PasswordField loginPassword;
    @FXML private TextField regUsername;
    @FXML private PasswordField regPassword;
    @FXML private TextField regEmail;
    @FXML private Label messageLabel;
    @FXML private TabPane tabPane;

    private UserService userService = UserService.getInstance();

    @FXML
    private void handleLogin() {
        String username = loginUsername.getText();
        String password = loginPassword.getText();

        if (username.isEmpty() || password.isEmpty()) {
            showMessage("Заполните все поля!", "error");
            return;
        }

        User user = userService.вход(username, password);
        if (user != null) {
            showMessage("Вход выполнен! Добро пожаловать, " + username + "!", "success");
            openMainShop(user);
        } else {
            showMessage("Неверный логин или пароль!", "error");
        }
    }

    @FXML
    private void handleRegister() {
        String username = regUsername.getText();
        String password = regPassword.getText();
        String email = regEmail.getText();

        if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
            showMessage("Заполните все поля!", "error");
            return;
        }

        if (username.length() < 3) {
            showMessage("Имя пользователя минимум 3 символа!", "error");
            return;
        }

        if (password.length() < 4) {
            showMessage("Пароль минимум 4 символа!", "error");
            return;
        }

        if (!email.contains("@")) {
            showMessage("Введите корректный email!", "error");
            return;
        }

        boolean успех = userService.регистрация(username, password, email);

        if (успех) {
            showMessage("Регистрация успешна! Теперь вы можете войти.", "success");

            regUsername.clear();
            regPassword.clear();
            regEmail.clear();

            tabPane.getSelectionModel().select(0);
        } else {
            showMessage("Пользователь с таким именем уже существует!", "error");
        }
    }

    @FXML
    private void handleGuestAccess() {
        User guestUser = new User("Гость", "", "guest@example.com");
        openMainShop(guestUser);
    }

    private void showMessage(String message, String type) {
        messageLabel.setText(message);
        if (type.equals("error")) {
            messageLabel.setStyle("-fx-text-fill: red;");
        } else {
            messageLabel.setStyle("-fx-text-fill: green;");
        }
    }

    private void openMainShop(User user) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Parent root = loader.load();

            HelloController controller = loader.getController();
            controller.setCurrentUser(user);

            Stage shopStage = new Stage();
            shopStage.setTitle("Мебельный магазин - " + user.getUsername());
            shopStage.setScene(new Scene(root, 950, 650));
            shopStage.setResizable(false);

            Stage loginStage = (Stage) loginUsername.getScene().getWindow();
            loginStage.close();

            shopStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            showMessage("Ошибка открытия магазина!", "error");
        }
    }
}
