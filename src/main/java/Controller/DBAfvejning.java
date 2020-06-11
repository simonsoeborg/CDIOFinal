/*
    Author: Simon Søborg
    Github: simonsoeborg
*/
package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBAfvejning {
    DBConnector dbc = new DBConnector();
    private String sqlQuery;
    private Connection SQLConn;

    private String findBrugerQuery = "SELECT * FROM Brugere WHERE UserId = ?";
    private String findReceptQuery = "SELECT receptNavn FROM ProduktBatchAfvejning WHERE pbId = ?";

    public String getLaborantName(int id) {
        SQLConn = dbc.createConnection();
        String data = null;

        try {
            if (SQLConn != null) {
                sqlQuery = findBrugerQuery;
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                pstm.setInt(1, id);
                ResultSet resultSet = pstm.executeQuery();

                while (resultSet.next()) {
                    data = resultSet.getString("FirstName") + " " +resultSet.getString("Lastname");
                }
                SQLConn.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return data;
    }

    public String findRecept(int id) {
        SQLConn = dbc.createConnection();
        String data = null;

        try {
            if (SQLConn != null) {
                sqlQuery = findReceptQuery;
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                pstm.setInt(1, id);
                ResultSet resultSet = pstm.executeQuery();

                while (resultSet.next()) {
                    data = resultSet.getString("receptNavn");
                }
                SQLConn.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
    }

}
