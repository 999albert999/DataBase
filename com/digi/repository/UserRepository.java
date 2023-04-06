package com.digi.repository;

import com.digi.model.User;
import com.digi.util.MyDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class UserRepository {
    public static void insert(User user) {
        Connection connection = MyDataSource.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into users values (?,?,?,?,?,?)");
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getSurname());
            preparedStatement.setInt(4, user.getAge());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getPassword());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<User> getAll() {
        Connection connection = MyDataSource.getConnection();
        List<User> list = new LinkedList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                list.add(new User(userId, name, surname, age, email, password));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static void update(User user) {
        if (user != null) {
            Connection connection = MyDataSource.getConnection();
            try {
                PreparedStatement preparedStatement1 = connection.prepareStatement("select * from users where email= ?");
                preparedStatement1.setString(1, user.getEmail());
                ResultSet resultSet = preparedStatement1.executeQuery();
                if (resultSet.next()) {
                    String name = user.getName() != null ? user.getName() : resultSet.getString("name");
                    String surname = user.getSurname() != null ? user.getSurname() : resultSet.getString("surname");
                    int age = user.getAge() != 0 ? user.getAge() : resultSet.getInt("age");
                    PreparedStatement preparedStatement = connection.prepareStatement("update users set name=?, surname=?, age=? where email=?");
                    preparedStatement.setString(1,name);
                    preparedStatement.setString(2,surname);
                    preparedStatement.setInt(3,age);
                    preparedStatement.setString(4, user.getEmail());
                    preparedStatement.executeUpdate();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static void delete(User user) {
        Connection connection = MyDataSource.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from users where email = ?");
            preparedStatement.setString(1, user.getEmail());
            if (preparedStatement.executeQuery().next()) {
                PreparedStatement preparedStatement1 = connection.prepareStatement("delete from users where email = ?");
                preparedStatement1.setString(1, user.getEmail());
                preparedStatement1.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
