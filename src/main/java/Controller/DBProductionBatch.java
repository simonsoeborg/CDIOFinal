package Controller;

import Data.DTO.ProductionBatch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBProductionBatch {
    DBConnector dbc = new DBConnector();
    private String sqlQuery;
    private Connection SQLConn = dbc.createConnection();
    private List<ProductionBatch> productionBatches;

    private DBConnector MySQLConnector = new DBConnector();

    public List<ProductionBatch> GetAllProductionBatch() {
        ArrayList<ProductionBatch> data = new ArrayList<>();
        SQLConn = MySQLConnector.createConnection();
        if (SQLConn != null) {
            try {
                sqlQuery = "SELECT * FROM ProduktBatchView ORDER BY pbid";
                //prepared statement
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                ResultSet resultSet = pstm.executeQuery();
                while (resultSet.next()) {
                    data.add(new ProductionBatch(resultSet.getInt("pbid"),
                            resultSet.getInt("receptid"),
                            resultSet.getString("status"),
                            resultSet.getInt("userid"),
                            resultSet.getInt("rbid"),
                            resultSet.getDouble("afvejetmaengde"),
                            resultSet.getDouble("tara")));
                }
                SQLConn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        productionBatches = new ArrayList<>();
        productionBatches = data;
        return productionBatches;
    }


    public void deleteProductionBatch(int i, int pbid) {
        try {
            SQLConn = MySQLConnector.createConnection();
            if (SQLConn != null) {
                sqlQuery = "DELETE FROM ProduktBatch WHERE pbid=?";
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                pstm.setInt(1, pbid);
                pstm.executeUpdate();
                sqlQuery = "DELETE FROM ProduktBatchKomponent WHERE pbid=?";
                PreparedStatement pstm2 = SQLConn.prepareStatement(sqlQuery);
                pstm2.setInt(1, pbid);
                pstm2.executeUpdate();
                SQLConn.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void createProductionBatch(int pbid, int receptid, String status, int userid, int rbid, double tara, double afvejetmaengde) {
        try {
            PreparedStatement pstm;
            PreparedStatement pstm2;
            SQLConn = MySQLConnector.createConnection();
            if (SQLConn != null) {
                pstm = SQLConn.prepareStatement("INSERT INTO ProduktBatch VALUES (?, ?, ?, ?)");
                pstm.setInt(1, pbid);
                pstm.setInt(2, receptid);
                pstm.setString(3, status);
                pstm.setInt(4, userid);
                pstm.executeUpdate();
                pstm2 = SQLConn.prepareStatement("INSERT INTO ProduktBatchKomponent VALUES (?, ?, ?, ?, ?)");
                pstm2.setInt(1, 0);
                pstm2.setInt(2, pbid);
                pstm2.setInt(3, rbid);
                pstm2.setDouble(4, afvejetmaengde);
                pstm2.setDouble(5, tara);
                pstm2.executeUpdate();
                SQLConn.close();
            }
        } catch (SQLException e) {
            System.out.println(e);

        }
    }



    public void createProductionBatchComponent(int userid, int rbid, double afvejetmaengde, double tara) {
        try {
            PreparedStatement pstm;
            SQLConn = MySQLConnector.createConnection();
            if (SQLConn != null) {
                pstm = SQLConn.prepareStatement("INSERT INTO ProduktBatchkomponent VALUES (?, ?, ?, ?) ");
                  pstm.setInt(1, userid);
                   pstm.setInt(2, rbid);
                  pstm.setDouble(3, afvejetmaengde);
                  pstm.setDouble(4,tara);

                  pstm.executeUpdate();
                  SQLConn.close();
              }
          } catch (SQLException e) {
              System.out.println(e);
          }
    }

    public void deleteProductionBatchComponent(int pbid){
        try {
            PreparedStatement pstm;
            SQLConn = MySQLConnector.createConnection();
            if(SQLConn != null) {
                pstm = SQLConn.prepareStatement("DELETE pbid FROM ProduktBatchkomponent WHERE (?)");
                pstm.setInt(1,pbid);
                pstm.executeUpdate();
                SQLConn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}




