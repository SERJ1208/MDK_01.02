package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class UsersTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
        Users.clearUsersList(); // Очищаем список перед каждым тестом
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testUserCreationAndDisplay() {
        // Создаем пользователей
        Users user1 = new Users("Анна", 28, "женский");
        Users user2 = new Users("Сергей", 35, "мужской");

        // Проверяем корректность создания
        assertEquals(1, user1.getId());
        assertEquals("Анна", user1.getName());
        assertEquals(28, user1.getAge());
        assertEquals("женский", user1.getGender());

        assertEquals(2, user2.getId());
        assertEquals("Сергей", user2.getName());

        // Проверяем вывод на экран
        Users.displayAllUsers();
        String output = outputStream.toString();

        assertTrue(output.contains("Анна"));
        assertTrue(output.contains("Сергей"));
        assertTrue(output.contains("28"));
        assertTrue(output.contains("35"));
        assertTrue(output.contains("женский"));
        assertTrue(output.contains("мужской"));
    }

    @Test
    void testUsersList() {
        new Users("Тест", 20, "мужской");
        new Users("Тест2", 25, "женский");

        List<Users> users = Users.getUsersList();
        assertEquals(2, users.size());
        assertEquals("Тест", users.get(0).getName());
        assertEquals("Тест2", users.get(1).getName());
    }
}