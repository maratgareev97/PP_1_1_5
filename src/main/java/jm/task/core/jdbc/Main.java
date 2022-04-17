package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Util.getConn();
        //UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        UserService userService = new UserServiceImpl();
        //userDaoJDBC.dropUsersTable();
        userService.createUsersTable();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Имя: ");
        String name = scanner.nextLine();
        System.out.println("Фамилия: ");
        String lastName = scanner.nextLine();
        System.out.println("Возраст ");
        String age = scanner.nextLine();
        userService.saveUser(name, lastName, Byte.parseByte(age));
//
//        System.out.println("Удаление по id: ");
//        String id = scanner.nextLine();
//        userDaoJDBC.removeUserById(Long.parseLong(id));

        //userDaoJDBC.getAllUsers();
//        userDaoJDBC.cleanUsersTable();


        userService.closeBase();


    }
}
