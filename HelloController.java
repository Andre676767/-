package com.example.demo6;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;

public class HelloController {

    @FXML private Label welcomeLabel;
    @FXML private Label userInfoLabel;
    @FXML private ListView<String> productsList;
    @FXML private ListView<String> categoriesList;
    @FXML private ListView<String> cartList;
    @FXML private Label totalLabel;
    @FXML private TextArea infoArea;
    @FXML private VBox productDetails;
    @FXML private Button removeButton;
    @FXML private Button orderButton;

    private User currentUser;
    private ArrayList<String> cartItems = new ArrayList<>();

    private String[][] products = {
            {"Стул деревянный", "2500", "Стулья"},
            {"Стул офисный", "4500", "Стулья"},
            {"Стул мягкий", "3500", "Стулья"},
            {"Стол обеденный", "15000", "Столы"},
            {"Стол письменный", "12000", "Столы"},
            {"Стол журнальный", "8000", "Столы"},
            {"Диван прямой", "25000", "Диваны"},
            {"Диван угловой", "35000", "Диваны"},
            {"Диван-книжка", "20000", "Диваны"},
            {"Шкаф-купе", "30000", "Шкафы"},
            {"Шкаф платяной", "25000", "Шкафы"},
            {"Комод", "15000", "Шкафы"},
            {"Кровать двуспальная", "27990", "Кровати"},
            {"Кровать односпальная", "15990", "Кровати"},
            {"Кровать-чердак", "39990", "Кровати"},
            {"Кресло мягкое", "12000", "Кресла"},
            {"Кресло-качалка", "15000", "Кресла"},
            {"Кресло компьютерное", "8000", "Кресла"}
    };


    private double extractPrice(String itemText) {
        String onlyNumbers = itemText.replaceAll("[^0-9]", "");
        if (!onlyNumbers.isEmpty()) {
            return Double.parseDouble(onlyNumbers);
        }
        return 0;
    }

    private String formatPrice(double price) {
        if (price >= 1000) {
            return String.format("%,.0f ₽", price).replace(",", " ");
        }
        return String.format("%.0f ₽", price);
    }

    @FXML
    public void initialize() {
        String[] categories = {"Стулья", "Столы", "Диваны", "Шкафы", "Кровати", "Кресла"};
        categoriesList.getItems().addAll(categories);

        categoriesList.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldVal, newVal) -> filterByCategory(newVal)
        );

        showAllProducts();

        productsList.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldVal, newVal) -> showProductDetails(newVal)
        );

        // Кнопка УДАЛИТЬ из корзины
        removeButton.setOnAction(e -> {
            int selected = cartList.getSelectionModel().getSelectedIndex();
            if (selected >= 0) {
                cartItems.remove(selected);
                cartList.getItems().remove(selected);
                updateTotal();
                infoArea.setText("Товар удален из корзины");
            } else {
                infoArea.setText("Выберите товар для удаления");
            }
        });

        // Кнопка ОФОРМИТЬ ЗАКАЗ
        orderButton.setOnAction(e -> {
            if (cartItems.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Корзина пуста");
                alert.setHeaderText(null);
                alert.setContentText("Добавьте товары в корзину для оформления заказа");
                alert.showAndWait();
            } else {
                double total = calculateTotal();

                Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
                confirm.setTitle("Оформление заказа");
                confirm.setHeaderText("Подтверждение заказа");
                confirm.setContentText("Общая сумма: " + formatPrice(total) + "\nОформить заказ?");

                confirm.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        Alert success = new Alert(Alert.AlertType.INFORMATION);
                        success.setTitle("Заказ оформлен");
                        success.setHeaderText(null);
                        success.setContentText("Спасибо за покупку!\nНаш менеджер свяжется с вами.");
                        success.showAndWait();

                        // Очистка корзины
                        cartItems.clear();
                        cartList.getItems().clear();
                        updateTotal();
                        infoArea.setText("Заказ успешно оформлен!");
                    }
                });
            }
        });
    }

    private double calculateTotal() {
        double total = 0;
        for (String item : cartItems) {
            total += extractPrice(item);
        }
        return total;
    }

    private void updateTotal() {
        totalLabel.setText("Итого: " + formatPrice(calculateTotal()));
    }

    private void showAllProducts() {
        productsList.getItems().clear();
        for (String[] product : products) {
            productsList.getItems().add(product[0] + " - " + formatPrice(Double.parseDouble(product[1])));
        }
    }

    private void filterByCategory(String category) {
        productsList.getItems().clear();
        for (String[] product : products) {
            if (product[2].equals(category)) {
                productsList.getItems().add(product[0] + " - " + formatPrice(Double.parseDouble(product[1])));
            }
        }
    }

    // ИСПРАВЛЕННЫЙ метод показа деталей товара
    private void showProductDetails(String productStr) {
        if (productStr == null) return;

        productDetails.getChildren().clear();
        String[] parts = productStr.split(" - ");
        String name = parts[0];
        String priceStr = parts[1].replace(" ₽", "");

        Label nameLabel = new Label("Товар: " + name);
        nameLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        Label priceLabel = new Label("Цена: " + priceStr + " ₽");
        priceLabel.setStyle("-fx-font-size: 13px;");

        Button addButton = new Button("Добавить в корзину");
        addButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px;");
        addButton.setOnAction(e -> {
            String fullItem = name + " - " + priceStr + " ₽";
            cartItems.add(fullItem);
            cartList.getItems().add(fullItem);
            updateTotal();
            infoArea.setText(" " + name + " добавлен в корзину!");
        });

        productDetails.getChildren().addAll(nameLabel, priceLabel, addButton);
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
        welcomeLabel.setText("Добро пожаловать, " + user.getUsername() + "!");
        userInfoLabel.setText(" " + user.getEmail());

        // Если админ, показываем дополнительную информацию
        if (user.isAdmin()) {
            userInfoLabel.setText(userInfoLabel.getText() + "Администратор");
        }
    }

    @FXML
    private void handleLogout() {
        try {
            Stage stage = (Stage) welcomeLabel.getScene().getWindow();
            stage.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("login-view.fxml"));
            Parent root = loader.load();
            Stage loginStage = new Stage();
            loginStage.setTitle("Вход в магазин");
            loginStage.setScene(new Scene(root, 450, 550));
            loginStage.setResizable(false);
            loginStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}