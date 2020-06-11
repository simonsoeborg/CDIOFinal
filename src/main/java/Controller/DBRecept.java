package Data;

import Data.DTO.DBConnector;
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

    //-------------------------------FETCH ALL RECEPTS------------------------------------------

    public void fetchAllRecepts() {
        recepts = new ArrayList<>();
        recepts = GetAllRecepts();
    }

    public List<Recept> GetAllRecepts() {
        ArrayList<Recept> data = new ArrayList<>();
        SQLConn = SQLConnector.createConnection();
        if (SQLConn != null) {
            try {
                sqlQuery = "SELECT * FROM Recept";
                //prepared statement
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                ResultSet resultSet = pstm.executeQuery();
                while (resultSet.next()) {
                    data.add(new Recept(resultSet.getInt("receptId"),
                            resultSet.getString("receptNavn"),
                            resultSet.getInt("raavareId"),
                            resultSet.getDouble("nonNetto"),
                            resultSet.getDouble("tolerance")));
                }
                SQLConn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return data;
    }

    public List<Recept> listAllRecepts() {
        fetchAllRecepts();
        return recepts;
    }

    //-------------------------------------------------------------------------------------


    public void createRecept(int receptId, String receptNavn, int raavareID, double nonNetto, double tolerance) {

        try {
            SQLConn = SQLConnector.createConnection();
            if (SQLConn != null) {
                pstm = SQLConn.prepareStatement("INSERT INTO Recept (receptId, receptNavn, raavareID, nonNetto, tolerance)" +
                        "VALUES (?, ?, ?, ?, ?)");
                resultSet = pstm.executeQuery();
                pstm.setInt(1, receptId);
                pstm.setString(2, receptNavn);
                pstm.setInt(3, raavareID);
                pstm.setDouble(4, nonNetto);
                pstm.setDouble(5, tolerance);
                pstm.executeUpdate();
                SQLConn.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void UpdateRecept(int receptId, String receptNavn, int raavareID, double nonNetto, double tolerance) {
        try {
            SQLConn = SQLConnector.createConnection();
            if (SQLConn != null) {
                pstm = SQLConn.prepareStatement("UPDATE Recept " + "SET receptId=?, " + "receptNavn=?, " +
                        "raavareID=?, " + "nonNetto=? " + "tolerance=? " + "WHERE receptId = ?");
                pstm.setInt(1, receptId);
                pstm.setString(2, receptNavn);
                pstm.setInt(3, raavareID);
                pstm.setDouble(4, nonNetto);
                pstm.setDouble(5, tolerance);

                pstm.executeUpdate();
                SQLConn.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void UpdateReceptComponent(int raavareID, double nonNetto, double tolerance) {
        try {
            SQLConn = SQLConnector.createConnection();
            if (SQLConn != null) {
                pstm = SQLConn.prepareStatement("UPDATE Recept " + "SET raavareID=?, "
                        + "nonNetto=? " + "tolerance=? " + "WHERE raavareID = ?");
                pstm.setInt(3, raavareID);
                pstm.setDouble(4, nonNetto);
                pstm.setDouble(5, tolerance);

                pstm.executeUpdate();
                SQLConn.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteRecept(int receptId) {
        try {
            SQLConn = SQLConnector.createConnection();
            if (SQLConn != null) {
                pstm = SQLConn.prepareStatement("DELETE FROM Recept WHERE receptId = ?");
                pstm.setInt(1, receptId);
                pstm.executeUpdate();
                SQLConn.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //Dette skal indgå, når man har trykket på knappen 'rediger

    public void deleteReceptComponent(int raavareId) {
        try {
            SQLConn = SQLConnector.createConnection();
            if (SQLConn != null) {
                pstm = SQLConn.prepareStatement("DELETE FROM Recept WHERE raavareID = ?");
                pstm.setInt(1, raavareId);
                pstm.executeUpdate();
                SQLConn.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}


