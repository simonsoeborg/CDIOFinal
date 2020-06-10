package Data;
// Author: Kristoffer
import DB.DBConnector;
import Data.DTO.Raavare;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBRaavare {
    DBConnector dbc = new DBConnector();
    private String sqlQuery;
    private Connection SQLConn = dbc.createConnection();
    private List<Raavare> raavare;

    private DBConnector MySQLConnector = new DBConnector();

    public void fetchAllRaavare() {
        raavare = new ArrayList<>();
        raavare = GetAllRaavare();
    }

    public List<Raavare> GetAllRaavare() {
        ArrayList<Raavare> data = new ArrayList<>();
        SQLConn = MySQLConnector.createConnection();
        if (SQLConn != null) {
            try {
                sqlQuery = "SELECT * FROM Raavare";
                //prepared statement
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                ResultSet resultSet = pstm.executeQuery();
                while (resultSet.next()) {
                    data.add(new Raavare(resultSet.getInt("raavareId"), resultSet.getString("raavareNavn"), resultSet.getString("leverandoer")));
                   // System.out.println(resultSet.getString("raavareNavn"));
                }
                SQLConn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return data;
    }

    public List<Raavare> listAllRaavare() {
        fetchAllRaavare();
        return raavare;
    }

    public void deleteRaavare(int raavareId) {
        try {
            SQLConn = MySQLConnector.createConnection();
            if (SQLConn != null) {
                sqlQuery = "DELETE FROM Raavare WHERE raavareId= ?";
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                pstm.setInt(1, raavareId);
                pstm.executeUpdate();
                SQLConn.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
