package Controller;

import Data.DTO.DBConnector;
import Data.DTO.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUser {

    private Connection SQLConn;
    private String sqlQuery;
    private List<User> userList;
    private DBConnector MySQLConnector = new DBConnector();

    public List<User> listAllActivatedUsers() {
        userList = new ArrayList<>();
        userList = getAllActivatedUsers();
        return userList;
    }

    public List<User> listAllDeactivatedUsers() {
        userList = new ArrayList<>();
        userList = getAllDeactivatedUsers();
        return userList;
    }

    public List<User> listAllUsers() {
        userList = new ArrayList<>();
        userList = getAllUsers();
        return userList;
    }

    public List<User> getAllActivatedUsers() {
        SQLConn = MySQLConnector.createConnection();
        ArrayList<User> data = new ArrayList<>();
        if (SQLConn != null) {
            try {
                sqlQuery = "SELECT * FROM Brugere WHERE Status='Activated'";
                //prepared statement
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                ResultSet resultSet = pstm.executeQuery();
                while (resultSet.next()) {
                    data.add(new User(resultSet.getInt("UserId"), resultSet.getString("FirstName"), resultSet.getString("LastName"), resultSet.getString("Initial"), resultSet.getString("Role"), resultSet.getString("Status")));
                }
                SQLConn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return data;
    }

    public List<User> getAllUsers() {
        SQLConn = MySQLConnector.createConnection();
        ArrayList<User> data = new ArrayList<>();
        if (SQLConn != null) {
            try {
                sqlQuery = "SELECT * FROM Brugere";
                //prepared statement
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                ResultSet resultSet = pstm.executeQuery();
                while (resultSet.next()) {
                    data.add(new User(resultSet.getInt("UserId"), resultSet.getString("FirstName"), resultSet.getString("LastName"), resultSet.getString("Initial"), resultSet.getString("Role"), resultSet.getString("Status")));
                }
                SQLConn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return data;
    }

    public List<User> getAllDeactivatedUsers() {
        SQLConn = MySQLConnector.createConnection();
        ArrayList<User> data = new ArrayList<>();
        if (SQLConn != null) {
            try {
                sqlQuery = "SELECT * FROM Brugere WHERE Status='Deactivated'";
                //prepared statement
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                ResultSet resultSet = pstm.executeQuery();
                while (resultSet.next()) {
                    data.add(new User(resultSet.getInt("UserId"), resultSet.getString("FirstName"), resultSet.getString("LastName"), resultSet.getString("Initial"), resultSet.getString("Role"), resultSet.getString("Status")));
                }
                SQLConn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return data;
    }

    public void deactivateUser(int userID) {
        try {
            SQLConn = MySQLConnector.createConnection();
            String parameter2 = "Deactivated";
            if (SQLConn != null) {
                sqlQuery = "UPDATE Brugere  SET Status=? WHERE UserId = ?";
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                pstm.setString(1,parameter2);
                pstm.setInt(2, userID );

                pstm.executeUpdate();
                SQLConn.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void activateUser(int userID) {
        try {
            SQLConn = MySQLConnector.createConnection();
            String parameter1 = "Activated";
            if (SQLConn != null) {
                sqlQuery = "UPDATE Brugere  SET Status=? WHERE UserId = ?";
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                pstm.setString(1,parameter1);
                pstm.setInt(2, userID );
                pstm.executeUpdate();
                SQLConn.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }





    public User searchUser(int userID) {
        User temp = null;
        try {
            SQLConn = MySQLConnector.createConnection();
            if (SQLConn != null) {
                sqlQuery = "SELECT * FROM Brugere WHERE UserId = ?";
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                pstm.setInt(1, userID);
                ResultSet resultSet = pstm.executeQuery();

                while (resultSet.next()) {
                    temp = new User(resultSet.getInt("UserId"), resultSet.getString("FirstName"), resultSet.getString("LastName"), resultSet.getString("Initial"), resultSet.getString("Role"), resultSet.getString("Status"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return temp;
    }

    public void createUser(String firstName, String lastName, String initial, String role) {
        // String initial = String.valueOf(Character.toUpperCase(firstName.charAt(0))+ Character.toUpperCase(lastName.charAt(0)));
        try {
            SQLConn = MySQLConnector.createConnection();
            if (SQLConn != null) {
                sqlQuery = "INSERT INTO Brugere (FirstName, LastName, Initial, Role)" +
                        "VALUES (?, ?, ?, ?)";
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                pstm.setString(1, firstName);
                pstm.setString(2, lastName);
                pstm.setString(3, initial);
                pstm.setString(4, role);
                pstm.executeUpdate();
                SQLConn.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void editUser(int userID, String firstName, String lastName, String role) {
        try {
            SQLConn = MySQLConnector.createConnection();
            if(SQLConn != null) {
                sqlQuery = "UPDATE Brugere " +
                        "SET FirstName=?, " +
                        "LastName=?, " +
                        "Role=? " +
                        "WHERE UserId = ?";
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                pstm.setString(1, firstName);
                pstm.setString(2, lastName);
                pstm.setString(3, role);
                pstm.setInt(4, userID);

                pstm.executeUpdate();
                SQLConn.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
