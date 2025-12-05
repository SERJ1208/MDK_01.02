package org.example;

public class Main {
    public static void main(String[] args) {
        // Создаем пользователей
        new Users("Иван", 25, "мужской");
        new Users("Мария", 30, "женский");
        new Users("Петр", 22, "мужской");

        // Выводим всех пользователей
        Users.displayAllUsers();
    }
}