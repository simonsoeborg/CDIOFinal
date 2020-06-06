package Data;

import DB.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBAfvejning {
    DBConnector dbc = new DBConnector();
    private String sqlQuery;
    private Connection SQLConn = dbc.createConnection();

    public String findBruger(int id) {
        String data = null;

        try {
            if (SQLConn != null) {
                sqlQuery = "SELECT FirstName, LastName FROM Brugere WHERE UserId = ?";
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                pstm.setInt(1, id);
                ResultSet resultSet = pstm.executeQuery();

                while (resultSet.next()) {
                    data = resultSet.getString("FirstName") + " " + resultSet.getString("Lastname");
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return data;
    }

}
