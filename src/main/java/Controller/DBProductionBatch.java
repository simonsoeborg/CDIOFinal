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
                sqlQuery = "SELECT * FROM ProduktBatch";
                //prepared statement
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                ResultSet resultSet = pstm.executeQuery();
                while (resultSet.next()) {
                    data.add(new ProductionBatch(resultSet.getInt("pbid"), resultSet.getInt("receptId"), resultSet.getString("status"), resultSet.getInt("userid")));
                }
                SQLConn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return data;
    }


    public void deleteProductionBatch(int pbId) {
        try {
            SQLConn = MySQLConnector.createConnection();
            if (SQLConn != null) {
                sqlQuery = "DELETE FROM ProduktBatch WHERE pbId=?";
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                pstm.setInt(1, pbId);
                pstm.executeUpdate();
                SQLConn.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void createProductionBatch(int pbId, int receptId, String status) {
        try {
            PreparedStatement pstm;
            SQLConn = MySQLConnector.createConnection();
            if (SQLConn != null) {
                pstm = SQLConn.prepareStatement("INSERT INTO ProduktBatch VALUES (?, ?, ?)");
                pstm.setInt(1, pbId);
                pstm.setInt(2, receptId);
                pstm.setString(3, status);
                pstm.executeUpdate();
                SQLConn.close();
            }
        } catch (SQLException e) {
            System.out.println(e);

        }
    }

    public void createProductionBatchComponent(int id, int rbid, double afvejetmaengde, double tara) {
        try {
            PreparedStatement pstm;
            SQLConn = MySQLConnector.createConnection();
            if (SQLConn != null) {
                pstm = SQLConn.prepareStatement("INSERT INTO ProduktBatchkomponent VALUES (?, ?, ?, ?) ");
                  pstm.setInt(1, id);
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

    public void deleteProductionBatchComponent(int pbId){
        try {
            PreparedStatement pstm;
            SQLConn = MySQLConnector.createConnection();
            if(SQLConn != null) {
                pstm = SQLConn.prepareStatement("DELETE pbid FROM ProduktBatchkomponent WHERE (?)");
                pstm.setInt(1,pbId);
                pstm.executeUpdate();
                SQLConn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}




