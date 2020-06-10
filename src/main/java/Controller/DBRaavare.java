package Controller;

import Data.DTO.DBConnector;
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
                }
                SQLConn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        raavare = new ArrayList<>();
        raavare = data;
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
