package main.user;

import java.util.UUID;

public class User {
    private String[] save = new String[5];
    private String[] update = new String[4];
    private String[] delete = new String[2];

    public User(String name, String surname, int age, String email) {
        if (name.isEmpty() || surname.isEmpty() || email.isEmpty()) {
            throw new NullPointerException("Name, surname or email can't be empty!");
        } else if (age < 18) {
            throw new IllegalArgumentException("Age can't be less than 18!");
        } else {
            save[0] = UUID.randomUUID().toString();
            save[1] = name;
            save[2] = surname;
            save[3] = String.valueOf(age);
            save[4] = email;
        }
    }

    public User(String fieldForReplacement, String valueForReplacement, String fieldForSearch, String valueForSearch) {
        if (fieldForReplacement.isEmpty() || fieldForSearch.isEmpty()
                || valueForReplacement.isEmpty() || valueForSearch.isEmpty()) {
            throw new NullPointerException("FieldForReplacement, valueForReplacement, fieldForSearch, valueForSearch" +
                    " can't be empty!");
        } else {
            update[0] = fieldForReplacement;
            update[1] = valueForReplacement;
            update[2] = fieldForSearch;
            update[3] = valueForSearch;
        }
    }

    public User(String fieldForSearch, String valueForSearch) {
        if (fieldForSearch.isEmpty() || valueForSearch.isEmpty()) {
            throw new NullPointerException("FieldForSearch or valueForSearch can't be empty!");
        } else {
            delete[0] = fieldForSearch;
            delete[1] = valueForSearch;
        }
    }

    @Override
    public String toString() {
        return "INSERT INTO users VALUES (" +
                "'" + save[0] + "','" + save[1] + "','" + save[2] + "'," + save[3] + ",'" + save[4] + "'" +
                ");" +
                "UPDATE users SET " + update[0] + "='" + update[1] + "' " +
                "WHERE " + update[2] + "='" + update[3] + "';" +
                "DELETE FROM users WHERE " + delete[0] + " like '" + delete[1] + "';";
    }
}
