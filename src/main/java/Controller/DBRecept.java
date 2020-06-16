package Controller;

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

    public List<Recept> GetAllRecepts(int id) {
        ArrayList<Recept> data = new ArrayList<>();
        SQLConn = SQLConnector.createConnection();
        if (SQLConn != null) {
            try {
                sqlQuery = "SELECT * FROM FrejaView2 WHERE receptId = ?";
                //prepared statement
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                pstm.setInt(1,id);
                ResultSet resultSet = pstm.executeQuery();
                while (resultSet.next()) {
                    data.add(new Recept(resultSet.getInt("receptId"),
                            resultSet.getString("receptNavn"),
                            resultSet.getString("raavareNavn"),
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


    public void createRecept(int receptId, String receptNavn, String raavareNavn, double maengde, double tolerance) {

        try {
            SQLConn = SQLConnector.createConnection();
            if (SQLConn != null) {
                pstm = SQLConn.prepareStatement("INSERT INTO FrejaView2 (receptId, receptNavn, raavareNavn, maengde, tolerance)" +
                        "VALUES (?, ?, ?, ?, ?)");
                pstm.setInt(1, receptId);
                pstm.setString(2, receptNavn);
                pstm.setString(3, raavareNavn);
                pstm.setDouble(4, maengde);
                pstm.setDouble(5, tolerance);
                pstm.executeUpdate();
                SQLConn.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void UpdateRecept(int receptId, String receptNavn, String raavareNavn, double maengde, double tolerance) {
        try {
            SQLConn = SQLConnector.createConnection();
            if (SQLConn != null) {
                pstm = SQLConn.prepareStatement("UPDATE FrejaView2 SET receptId = ?, receptNavn = ?, raavareNavn = ?, " +
                        "meangde = ?, tolerance = ? WHERE receptId = ?");
                pstm.setInt(1, receptId);
                pstm.setString(2, receptNavn);
                pstm.setString(3, raavareNavn);
                pstm.setDouble(4, maengde);
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

   /* public void UpdateReceptComponent(int raavareId, double nonNetto, double tolerance) { //Virker ikke
        try {
            SQLConn = SQLConnector.createConnection();
            if (SQLConn != null) {
                pstm = SQLConn.prepareStatement("UPDATE Recept  SET nonNetto = ?, " +
                        "tolerance = ? WHERE raavareId = ?");
                pstm.setDouble(1, nonNetto);
                pstm.setDouble(2, tolerance);
                pstm.setInt(3, raavareId);
                pstm.executeUpdate();
                SQLConn.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //Dette skal indgå, når man har trykket på knappen 'rediger'

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
    }*/
}


