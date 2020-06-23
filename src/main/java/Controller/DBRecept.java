package Controller;

import Data.DTO.Recept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBRecept {

    private Connection SQLConn;
    private String sqlQuery;
    private PreparedStatement pstm;
    private ResultSet resultSet;

    private List<Recept> recepts;

    private DBConnector SQLConnector = new DBConnector();

    //-------------------------------Get all Recepts------------------------------------------

    public List<Recept> GetAllRecepts() {
        ArrayList<Recept> data = new ArrayList<>();
        SQLConn = SQLConnector.createConnection();
        if (SQLConn != null) {
            try {
                sqlQuery = "SELECT * FROM ReceptView ORDER BY receptId";
                //prepared statement
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                ResultSet resultSet = pstm.executeQuery();

                while (resultSet.next()) {
                    data.add(new Recept(resultSet.getInt("receptid"),
                            resultSet.getString("receptnavn"),
                            resultSet.getInt("raavareid"),
                            resultSet.getString("raavarenavn"),
                            resultSet.getDouble("maengde"),
                            resultSet.getDouble("tolerance")));
                }
                SQLConn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return data;
    }

    //-------------------------------------------------------------------------------------


    public void createRecept(int receptId, String receptNavn, int raavareId, double maengde, double tolerance) {

        try {
            SQLConn = SQLConnector.createConnection();
            if (SQLConn != null) {
                pstm = SQLConn.prepareStatement("INSERT INTO Recept (receptid, receptnavn) VALUES (?, ?)");
                pstm.setInt(1, receptId);
                pstm.setString(2, receptNavn);
                pstm.executeUpdate();
                SQLConn.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        try {
            SQLConn = SQLConnector.createConnection();
            if (SQLConn != null) {
                pstm = SQLConn.prepareStatement(
                        "INSERT INTO ReceptKomponent (receptid, raavareid, maengde, tolerance) VALUES (?, ?, ?, ?)");
                pstm.setInt(1, receptId);
                pstm.setInt(2, raavareId);
                pstm.setDouble(3, maengde);
                pstm.setDouble(4, tolerance);
                pstm.executeUpdate();
                SQLConn.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //-------------------------------------------------------------------------------------

    public void deleteReceptKomponent(int raavareid, int receptid) {
        try {
            SQLConn = SQLConnector.createConnection();
            if (SQLConn != null) {
                sqlQuery = "DELETE FROM ReceptKomponent WHERE raavareid = ? AND receptid = ?";
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                pstm.setInt(1, raavareid);
                pstm.setInt(2, receptid);
                pstm.executeUpdate();
                SQLConn.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //-------------------------------------------------------------------------------------

    public void deleteReceptId(int receptid) {
        try {
            SQLConn = SQLConnector.createConnection();
            if (SQLConn != null) {
                sqlQuery = "DELETE FROM ReceptKomponent WHERE receptid = ?";
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                pstm.setInt(1, receptid);
                pstm.executeUpdate();
                SQLConn.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        try {
            SQLConn = SQLConnector.createConnection();
            if (SQLConn != null) {
                sqlQuery = "DELETE FROM Recept WHERE receptid = ?";
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                pstm.setInt(1, receptid);
                pstm.executeUpdate();
                SQLConn.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //-------------------------------------------------------------------------------------

    public List<Recept> GetAllReceptsFromRecept() {
        ArrayList<Recept> receptIdData = new ArrayList<>();
        SQLConn = SQLConnector.createConnection();
        if (SQLConn != null) {
            try {
                sqlQuery = "SELECT * FROM Recept ORDER BY receptId";
                //prepared statement
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                ResultSet resultSet = pstm.executeQuery();

                while (resultSet.next()) {
                    receptIdData.add(new Recept(resultSet.getInt("receptid"),
                            resultSet.getString("receptnavn")));
                }
                SQLConn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return receptIdData;
    }


    //-------------------------------------------------------------------------------------
    }



