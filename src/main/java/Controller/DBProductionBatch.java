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
    private List<ProductionBatch> ProductionBatches;
    private PreparedStatement pstm;

    private DBConnector MySQLConnector = new DBConnector();

    public void fetchAllProductionBatch() {
        ProductionBatches = new ArrayList<>();
        ProductionBatches = GetAllProductionBatch();
    }

    public List<ProductionBatch> GetAllProductionBatch() {
        ArrayList<ProductionBatch> data = new ArrayList<>();
        SQLConn = MySQLConnector.createConnection();
        if (SQLConn != null) {
            try {
                sqlQuery = "SELECT * FROM ProduktBatchView";
                //prepared statement
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                ResultSet resultSet = pstm.executeQuery();
                while (resultSet.next()) {
                    data.add(new ProductionBatch(resultSet.getInt("pbId"), resultSet.getInt("receptid"), resultSet.getInt("status"), resultSet.getInt("userId"), resultSet.getInt("rbID"), resultSet.getDouble("tara"), resultSet.getDouble("netto")));
                }
                SQLConn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return data;
    }

    public List<ProductionBatch> listAllProductionBatches() {
        fetchAllProductionBatch();
        return ProductionBatches;
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

    public void createProductionBatch(int pbId, int receptId, int status, int id, int rbid, double afvejetmaengde, double tara) {

        PreparedStatement ptsm;
        try {
            SQLConn = MySQLConnector.createConnection();
            if (SQLConn != null) {
                ptsm = SQLConn.prepareStatement("INSERT INTO ProduktBatch (pbId, receptId, status,id,rbid,afvejetmaengde,tara)");
                "VALUES (?, ?, ?)");
                pstm.setInt(1, pbId);
                pstm.setInt(2, receptId);
                pstm.setInt(3, status);
                pstm.setInt(4,id);
                pstm.setDouble(5,afvejetmaengde);
                pstm.setDouble(6,tara);

                pstm.executeUpdate();
                SQLConn.close();
            }
        } catch (SQLException e) {
            System.out.println(e);

        }  try {
            SQLConn = MySQLConnector.createConnection();
            if (SQLConn != null) {
                ptsm = SQLConn.prepareStatement("INSERT INTO ProduktBatchkomponent (id, rbid, afvejetmaengde,tara)");
                "VALUES (?, ?, ?)");
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

    public void deleteProductionBatchkomponent(int pbId) {
        try {
            SQLConn = MySQLConnector.createConnection();
            if (SQLConn != null) {
                sqlQuery = "DELETE FROM ProduktBatch WHERE pbId= ?";
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                pstm.setInt(1, pbId);
                pstm.executeUpdate();
                SQLConn.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}




