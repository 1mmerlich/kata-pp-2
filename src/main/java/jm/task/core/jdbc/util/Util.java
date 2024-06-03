package jm.task.core.jdbc.util;
import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/aa_user_db";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    public static Connection getConnectionDB() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration()
                .setProperty("hibernate.connection.url", URL) //настраиваем Hibernate, метод set.Property устанавливает конфигурацию
                .setProperty("hibernate.connection.username", USER)
                .setProperty("hibernate.connection.password", PASSWORD)
                .setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
                .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect")
                .setProperty("hibernate.show_sql", "false")
                .addAnnotatedClass(User.class); //добавляем аннотированный класс User в конфигурацию и строим SessionFactory
        return configuration.buildSessionFactory();
    }
    public static void closeSessionFactory () {
        getSessionFactory().close(); //закрываем SF и освобождаем ресурсы
    }

}
