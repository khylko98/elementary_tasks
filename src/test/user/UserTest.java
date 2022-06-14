package test.user;

import main.user.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @ParameterizedTest
    @DisplayName("Must throw NullPointerException when string are empty")
    @CsvSource({"'','',3,''"})
    void testUserEmptyString(String name, String surname, int age, String email) {
        assertThrows(NullPointerException.class, () -> new User(name, surname, age, email));
    }

    @ParameterizedTest
    @DisplayName("Must throw IllegalArgumentException when age less than 18")
    @CsvSource({"name, surname, 0, default@gmail.com", "name, surname, 13, default@gmail.com"})
    void testUserLessOne(String name, String surname, int age, String email) {
        assertThrows(IllegalArgumentException.class, () -> new User(name, surname, age, email));
    }

    @ParameterizedTest
    @DisplayName("Must return string like expected")
    @CsvSource({"name, John"})
    void testUserToString(String fieldForSearch, String valueForSearch) {
        String expected =   "INSERT INTO users VALUES ('null','null','null',null,'null');" +
                            "UPDATE users SET null='null' WHERE null='null';" +
                            "DELETE FROM users WHERE " + fieldForSearch + " like '" + valueForSearch + "';";
        assertEquals(expected, new User(fieldForSearch, valueForSearch).toString());
    }
}