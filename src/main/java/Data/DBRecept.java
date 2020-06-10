package Data;

import DB.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBRecept {

    private int receptId;
    private String receptNavn;
    private int raavareId;
    private double nonNetto;
    private double tolerance;
    private Connection SQLConn;
    private String sqlQuery;
    private PreparedStatement pstm;
    private ResultSet ResultSet;
    private ArrayList<DBRecept> recepts;

    private DBConnector SQLConnector = new DBConnector();

    public DBRecept(){}

    public DBRecept(int receptId, String receptNavn, int raavareID, double nonNetto, double tolerance) {
        this.receptId = receptId;
        this.receptNavn = receptNavn;
        this.raavareId = raavareID;
        this.nonNetto = nonNetto;
        this.tolerance = tolerance;
    }

    //-----------------------FETCH ALL RECEPTS------------------------------------------

    // Fetch user list from MySQL database
    public void fetchAllRecepts() {
        try {
            recepts = new ArrayList<>();
            recepts = addReceptsFromResultSet();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public ArrayList<DBRecept> getRecepts() {
        return recepts;
    }

    public ArrayList<DBRecept> addReceptsFromResultSet() throws SQLException {
        SQLConnector.createConnection();
        ArrayList<DBRecept> data = new ArrayList<>();
        if (SQLConn != null) {
            ResultSet = SQLConn.prepareStatement("SELECT * FROM Recept").executeQuery();
            while (ResultSet.next()) {
                data.add(new DBRecept(ResultSet.getInt("receptId"), ResultSet.getString("receptNavn"),
                        ResultSet.getInt("raavareID"), ResultSet.getDouble("nonNetto"),
                        ResultSet.getDouble("tolerance")));
            }
            SQLConn.close();
        }
        return data;
    }

    //-----------------------FETCH ALL RECEPTS------------------------------------------


    public void createRecept(int receptId, String receptNavn, int raavareID, double nonNetto, double tolerance) {

        try {
            SQLConn = SQLConnector.createConnection();
            if (SQLConn != null) {
                pstm = SQLConn.prepareStatement("INSERT INTO Recept (receptId, receptNavn, raavareID, nonNetto, tolerance)" +
                        "VALUES (?, ?, ?, ?, ?)");
                ResultSet = pstm.executeQuery();
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
