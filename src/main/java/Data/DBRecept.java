package Data;

import DB.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBRecept implements IDataHandlerDAO {

    private int receptId;
    private String receptNavn;
    private int raavareId;
    private double nonNetto;
    private double tolerance;
    private Connection SQLConn;
    private String sqlQuery;
    private PreparedStatement pstm;
    private ResultSet rs;
    private ArrayList<DBRecept> recepts;

    private DBConnector SQLConnector = new DBConnector();

    public DBRecept(int receptId, String receptNavn, int raavareID, double nonNetto, double tolerance) {
        this.receptId = receptId;
        this.receptNavn = receptNavn;
        this.raavareId = raavareID;
        this.nonNetto = nonNetto;
        this.tolerance = tolerance;
    }

    public ArrayList<DBRecept> getRecepts() {
        return recepts;
    }

    public void createRecept(int receptId, String receptNavn, int raavareID, double nonNetto, double tolerance) {

        try {
            SQLConn = SQLConnector.createConnection();
            if (SQLConn != null) {
                pstm = SQLConn.prepareStatement("INSERT INTO Recept (receptId, receptNavn, raavareID, nonNetto, tolerance)" +
                        "VALUES (?, ?, ?, ?, ?)");
                rs = pstm.executeQuery();
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
