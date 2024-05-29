package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;


public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService  = new UserServiceImpl();

//        userService.createUsersTable();
//        userService.removeUserById(1);
//        userService.saveUser("Антон", "Албычев", (byte) 48);
//        userService.dropUsersTable();
//        userService.cleanUsersTable();
//        userService.getAllUsers();

        Util.closeSessionFactory();
    }
}
