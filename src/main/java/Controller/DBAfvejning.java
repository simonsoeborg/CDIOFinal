/*
    Author: Simon Søborg
    Github: simonsoeborg
*/
package Controller;

import Data.DTO.AfvejningReceptKomponent;

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

    private String findLaborantQuery = "SELECT * FROM Brugere WHERE UserId = ? AND Role = ? AND Status = ?";
    private String findReceptQuery = "SELECT receptNavn FROM ProduktBatchAfvejning WHERE pbId = ?";
    private String getProduktionStatusQuery = "SELECT status FROM ProduktBatch WHERE pbId = ?";
    private String getReceptRaavareQuery = "SELECT raavareid, raavarenavn, maengde, tolerance FROM AfvejningReceptKomponent2 WHERE pbId = ?";
    private String updateAfvejetDataQuery = "INSERT INTO ProduktBatchKomponent (pbid, rbid, afvejetmaengde, tara)" +
            "VALUES (?, ?, ?, ?)";
    private String updateProduktionStatusQuery = "UPDATE ProduktBatch SET status = ? WHERE pbId = ?";

    public String getLaborantName(int id) {
        SQLConn = dbc.createConnection();
        String data = null;

        try {
            if (SQLConn != null) {
                sqlQuery = findLaborantQuery;
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                pstm.setInt(1, id);
                pstm.setString(2, "Laborant");
                pstm.setString(3, "Activated");
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

    public String getProduktionStatus(int id) {
        SQLConn = dbc.createConnection();
        String data = null;
        try {
            if (SQLConn != null) {
                sqlQuery = getProduktionStatusQuery;
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                pstm.setInt(1, id);
                ResultSet resultSet = pstm.executeQuery();

                while (resultSet.next()) {
                    data = resultSet.getString("status");
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

    public void updateAfvejetData(int pbid, int rbid, double afvejetmaengde, double tara) {
        SQLConn = dbc.createConnection();
        if(SQLConn != null) {
            try {
                sqlQuery = updateAfvejetDataQuery;
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                pstm.setInt(1, pbid);
                pstm.setInt(2, rbid);
                pstm.setDouble(3, afvejetmaengde);
                pstm.setDouble(4, tara);
                pstm.executeUpdate();
                SQLConn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    public void updateProduktionStatus(int id) {
        SQLConn = dbc.createConnection();
        if(SQLConn != null) {
            try {
                sqlQuery = updateProduktionStatusQuery;
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                pstm.setString(1, "Afsluttet");
                pstm.setInt(2, id);
                pstm.executeUpdate();
                SQLConn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
}
