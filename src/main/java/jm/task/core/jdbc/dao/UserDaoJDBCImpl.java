package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private static Statement statement = null;
    private static Connection conn = Util.getConn();

    static {
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public UserDaoJDBCImpl() {
    }

    public void connection_base() {
    }

    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS kata1_1.user (id INT auto_increment NOT NULL, name varchar(100) null," +
                " lastName varchar(100), age int, primary key(id))ENGINE=InnoDB;";
        try {
            statement.executeUpdate(sql);
            System.out.println("Таблица создана");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        String sql = "DROP TABLE kata1_1.user;";
        try {
            statement.executeUpdate(sql);
            System.out.println("Таблица удалена");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        int rows = 0;
        String sql = "INSERT INTO kata1_1.user (name, lastName, age) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, lastName);
            stmt.setString(3, String.valueOf(age));
            rows = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.printf("Добавлена %d строка", rows);
    }

    public void removeUserById(long id) {
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        int rows = 0;
        String sql = "select name, lastName, age from kata1_1.user;";
        try {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString(1);
                String lastName = rs.getString(2);
                Byte age = rs.getByte(3);
                users.add(new User(name, lastName, age));
                System.out.println(users);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;

    }

    public void cleanUsersTable() {
        int rows = 0;
        String sql="TRUNCATE TABLE kata1_1.user";
        //String sql = "DELETE FROM kata1_1.user;";
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print("Удалена строка");
    }
}
