package DB;

import Data.DBRaavare;
import Data.DBUser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBConnector {

    private String host = "mysql30.unoeuro.com";
    private String database = "uglyrage_com_db";
    private String username = "uglyrage_com";
    private String port = "3306";
    private String password = "2d4f6r3t";
    private List<DBUser> userList;
    private List<DBRaavare> Raavarer;

    public DBConnector(){ }

    public Connection createConnection() {
        Connection SQLConn;
        String dbURL = "jdbc:mysql://" + host + ":" + port + "/" + database + "?useTimezone=true&serverTimezone=UTC";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            SQLConn = DriverManager.getConnection(dbURL, username, password);
            return SQLConn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
