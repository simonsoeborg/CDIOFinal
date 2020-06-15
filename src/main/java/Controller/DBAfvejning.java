/*
    Author: Simon Søborg
    Github: simonsoeborg
*/
package Controller;

import Data.DTO.AfvejningReceptKomponent;
import Data.DTO.Raavare;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBAfvejning {
    DBConnector dbc = new DBConnector();
    private String sqlQuery;
    private Connection SQLConn;

    private String findBrugerQuery = "SELECT * FROM Brugere WHERE UserId = ?";
    private String findReceptQuery = "SELECT receptNavn FROM ProduktBatchAfvejning WHERE pbId = ?";
    private String getReceptRaavareQuery = "SELECT raavareid, (SELECT raavarenavn FROM Raavare WHERE raavareid = ?), maengde, tolerance FROM ReceptKomponent WHERE pbId = ?";

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

    public List<AfvejningReceptKomponent> getAfvejningReceptKomponent(int id) {
        ArrayList<AfvejningReceptKomponent> data = new ArrayList<>();
        SQLConn = dbc.createConnection();
        if(SQLConn != null) {
            try {
                sqlQuery = getReceptRaavareQuery;
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                pstm.setInt(1, id);
                pstm.setInt(2, id);
                ResultSet resultSet = pstm.executeQuery();
                while (resultSet.next()) {
                    data.add(new AfvejningReceptKomponent(resultSet.getInt("raavareid"), resultSet.getString("raavareNavn"), resultSet.getDouble("maengde"), resultSet.getDouble("tolerance")));
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return data;
    }
}
