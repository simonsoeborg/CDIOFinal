package Data;

import DB.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBUser {

    private int id;
    private String firstname;
    private String lastname;
    private String password;
    private String role;
    private Connection SQLConn;
    private String sqlQuery;
    private ArrayList<DBUser> userList;

    private DBConnector MySQLConnector = new DBConnector();

    public DBUser() {
    }

    public DBUser(int id, String firstname, String lastname, String password, String role) {
        this.id = id;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
    }

    public ArrayList<DBUser> listAllUsers() {
        return userList;
    }

    public void fetchAllUsers() {
        userList = new ArrayList<>();
        userList = addUsersFromResultSet();
    }

    public ArrayList<DBUser> addUsersFromResultSet() {
        SQLConn = MySQLConnector.createConnection();
        ArrayList<DBUser> data = new ArrayList<>();
        if (SQLConn != null) {
            try {
                sqlQuery = "SELECT * FROM Users";
                //prepared statement
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                ResultSet resultSet = pstm.executeQuery();
                while (resultSet.next()) {
                    data.add(new DBUser(resultSet.getInt("userID"), resultSet.getString("FirstName"), resultSet.getString("LastName"), resultSet.getString("Password"), resultSet.getString("Role")));
                }
                SQLConn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }

        }
        return data;
    }

    public void deleteUser(int id) {
        try {
            SQLConn = MySQLConnector.createConnection();
            if (SQLConn != null) {
                sqlQuery = "DELETE FROM Users WHERE userID = ?";
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                pstm.setInt(1, id);
                pstm.executeUpdate();
                SQLConn.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void createUser(String firstName, String lastName, String password, String role) {
        try {
            SQLConn = MySQLConnector.createConnection();
            if (SQLConn != null) {
                sqlQuery = "INSERT INTO Users (FirstName, LastName, Password, Role)" +
                        "VALUES (?, ?, ?, ?)";
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                pstm.setString(1, firstName);
                pstm.setString(2, lastName);
                pstm.setString(3, password);
                pstm.setString(4, role);

                pstm.executeUpdate();
                SQLConn.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void editUser(int userID, String CPR, String firstName, String lastName, String role, String password) {
        try {
            SQLConn = MySQLConnector.createConnection();
            if(SQLConn != null) {
                sqlQuery = "UPDATE Users " +
                        "SET FirstName=?, " +
                        "LastName=?, " +
                        "Password=?, " +
                        "Role=? " +
                        "WHERE userID = ?";
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                pstm.setString(1, firstName);
                pstm.setString(2, lastName);
                pstm.setString(3, password);
                pstm.setString(4, role);
                pstm.setInt(6, userID);

                pstm.executeUpdate();
                SQLConn.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
