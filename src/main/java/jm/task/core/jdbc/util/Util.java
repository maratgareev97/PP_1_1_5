package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    //System.out.println("-------Тестирование конектинга-------");
    private static Connection conn = null;


    private static String userName = "root";
    private static String password = "GOGUDAserver123!";
    private static String url = "jdbc:mysql://localhost:3306/kata1_1";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, userName, password);
            System.out.println("С базой соеденились");
        } catch (Exception ex) {
            System.err.println("Ошибка соединения с базой");
            ex.printStackTrace();
        }
    }

    public static Connection getConn() {
        return conn;
    }


}



