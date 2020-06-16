/* Author: Karl Emil */

package Controller;

import Data.DTO.RaavareBatch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBRaavareBatch {
    DBConnector dbc = new DBConnector();
    private String sqlQuery;
    private Connection SQLConn = dbc.createConnection();
    private List<RaavareBatch> raavarebatch;

    private DBConnector MySQLConnector = new DBConnector();

    public void fetchAllRaavareBatch() {
        raavarebatch = new ArrayList<>();
        raavarebatch = GetAllRaavareBatch();
    }

    public List<RaavareBatch> GetAllRaavareBatch() {
        ArrayList<RaavareBatch> data = new ArrayList<>();
        SQLConn = MySQLConnector.createConnection();
        if (SQLConn != null) {
            try {
                sqlQuery = "SELECT * FROM RaavareBatchMedNavn";
                //prepared statement
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                ResultSet resultSet = pstm.executeQuery();
                while (resultSet.next()) {
                    data.add(new RaavareBatch(resultSet.getInt("rbId"), resultSet.getInt("raavareId"), resultSet.getDouble("maengde"), resultSet.getString("leverandoer"), resultSet.getString("raavarenavn")));
                    System.out.println(resultSet.getString("raavarenavn"));
                }
                SQLConn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        return data;
    }

    public List<RaavareBatch> listAllRaavareBatch() {
        fetchAllRaavareBatch();
        return raavarebatch;
    }

    public void deleteRaavareBatch(int rbId) {
        try {
            SQLConn = MySQLConnector.createConnection();
            if (SQLConn != null) {
                sqlQuery = "DELETE FROM Raavarebatch WHERE rbId= ?";
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                pstm.setInt(1, rbId);
                pstm.executeUpdate();
                SQLConn.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public String getRaavareNavn(int raavareId) {
        String raavareNavn = null;
        try {
            SQLConn = MySQLConnector.createConnection();
            if (SQLConn != null) {
                sqlQuery = "SELECT * FROM Raavare WHERE raavareId= ?";
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                pstm.setInt(1, raavareId);
                ResultSet resultSet = pstm.executeQuery();
                resultSet.next();
                raavareNavn = resultSet.getString("raavarenavn");
                SQLConn.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return raavareNavn;
    }

    public void createRaavareBatch(RaavareBatch rb) {
        try {
            SQLConn = MySQLConnector.createConnection();
            if (SQLConn != null) {
                sqlQuery = "INSERT INTO Raavarebatch (rbid, raavareid, maengde, leverandoer)" +
                        "VALUES (?, ?, ?, ?)";
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                pstm.setInt(1, rb.getRbId());
                pstm.setInt(2, rb.getRaavareId());
                pstm.setDouble(3, rb.getMaengde());
                pstm.setString(4, rb.getLeverandoer());
                pstm.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
