package org.example;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private static int nextId = 1;

    private int id;
    private String name;
    private int age;
    private String gender;
    private static List<Users> usersList = new ArrayList<>();

    public Users(String name, int age, String gender) {
        this.id = nextId++;
        this.name = name;
        this.age = age;
        this.gender = gender;
        usersList.add(this);
    }

    // Геттеры
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }

    // Метод для вывода всех пользователей
    public static void displayAllUsers() {
        System.out.println("Список всех пользователей:");
        System.out.println("ID | Имя | Возраст | Пол");
        System.out.println("------------------------");
        for (Users user : usersList) {
            System.out.printf("%d | %s | %d | %s%n",
                    user.getId(), user.getName(), user.getAge(), user.getGender());
        }
    }

    // Метод для получения списка пользователей (для тестов)
    public static List<Users> getUsersList() {
        return new ArrayList<>(usersList);
    }

    // Метод для очистки списка (для тестов)
    public static void clearUsersList() {
        usersList.clear();
        nextId = 1;
    }

    @Override
    public String toString() {
        return String.format("User{id=%d, name='%s', age=%d, gender='%s'}",
                id, name, age, gender);
    }
}