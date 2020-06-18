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
//                pstm.setInt(1,id);
                ResultSet resultSet = pstm.executeQuery();

                while (resultSet.next()){
                    data.add(new Recept(resultSet.getInt("receptid"),
                            resultSet.getString("receptnavn"),
                            resultSet.getInt("raavareiD"),
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


    public void createRecept(int receptId, String receptNavn, String raavareNavn, double maengde, double tolerance) {

        try {
            SQLConn = SQLConnector.createConnection();
            if (SQLConn != null) {
                pstm = SQLConn.prepareStatement("INSERT INTO Recept (receptId, receptNavn) VALUES (?, ?)");
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
                        "INSERT INTO ReceptKomponent (receptId, raavareid, maengde, tolerance) VALUES (?, ?, ?, ?)");
                pstm.setInt(1, receptId);
                pstm.setString(2, raavareNavn);
                pstm.setDouble(3, maengde);
                pstm.setDouble(4, tolerance);
                pstm.executeUpdate();
                SQLConn.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

    //-------------------------------------------------------------------------------------

//    public void UpdateRecept(int receptId, String receptNavn, String raavareNavn, double maengde, double tolerance) {
//        try {
//            SQLConn = SQLConnector.createConnection();
//            if (SQLConn != null) {
//                pstm = SQLConn.prepareStatement("UPDATE FrejaView2 SET receptId = ?, receptNavn = ?, raavareNavn = ?, " +
//                        "maengde = ?, tolerance = ? WHERE receptId = ?");
//                pstm.setInt(1, receptId);
//                pstm.setString(2, receptNavn);
//                pstm.setString(3, raavareNavn);
//                pstm.setDouble(4, maengde);
//                pstm.setDouble(5, tolerance);
//
//                pstm.executeUpdate();
//                SQLConn.close();
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//    }
//
//    public void deleteRecept(int receptId) {
//        try {
//            SQLConn = SQLConnector.createConnection();
//            if (SQLConn != null) {
//                pstm = SQLConn.prepareStatement("DELETE FROM Recept WHERE receptId = ?");
//                pstm.setInt(1, receptId);
//                pstm.executeUpdate();
//                SQLConn.close();
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//    }

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
}


