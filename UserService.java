package com.example.demo6;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    private static UserService instance;
    private Map<String, User> пользователи;

    private UserService() {
        пользователи = new HashMap<>();
        создатьАдминаПоУмолчанию();
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    private void создатьАдминаПоУмолчанию() {
        // Администратор
        User admin = new User("admin", "admin123", "admin@furniture.ru");
        admin.setFullName("Администратор Системы");
        admin.setPhone("+7 (999) 123-45-67");
        admin.setAdmin(true);
        пользователи.put("admin", admin);

        // Обычный пользователь
        User user = new User("user", "user123", "user@example.com");
        user.setFullName("Иван Петров");
        user.setPhone("+7 (999) 987-65-43");
        пользователи.put("user", user);

        // Ещё один тестовый пользователь
        User ivan = new User("ivan", "ivan123", "ivan@mail.ru");
        ivan.setFullName("Иван Иванов");
        ivan.setPhone("+7 (916) 123-45-67");
        пользователи.put("ivan", ivan);
    }

    public boolean регистрация(String имя, String пароль, String email) {
        return регистрация(имя, пароль, email, "", "");
    }

    public boolean регистрация(String имя, String пароль, String email, String телефон, String полноеИмя) {
        if (пользователи.containsKey(имя)) {
            return false;
        }

        if (имя == null || имя.length() < 3) {
            return false;
        }

        if (пароль == null || пароль.length() < 4) {
            return false;
        }

        if (email == null || !email.contains("@")) {
            return false;
        }

        User новыйПользователь = new User(имя, пароль, email);
        новыйПользователь.setPhone(телефон);
        новыйПользователь.setFullName(полноеИмя);
        пользователи.put(имя, новыйПользователь);
        return true;
    }

    public User вход(String имя, String пароль) {
        User пользователь = пользователи.get(имя);
        if (пользователь != null && пользователь.getPassword().equals(пароль)) {
            return пользователь;
        }
        return null;
    }

    public boolean существуетПользователь(String имя) {
        return пользователи.containsKey(имя);
    }

    public User получитьПользователя(String имя) {
        return пользователи.get(имя);
    }

    public Map<String, User> getAllUsers() {
        return пользователи;
    }
}