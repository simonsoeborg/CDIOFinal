package Controller;

import Data.DTO.ProductionBatch;
import com.mysql.cj.jdbc.exceptions.MySQLQueryInterruptedException;

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
                sqlQuery = "SELECT * FROM ProductionBatch";
                //prepared statement
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                ResultSet resultSet = pstm.executeQuery();
                while (resultSet.next()) {
                    data.add(new ProductionBatch(resultSet.getInt("pbId"), resultSet.getInt("receptId"), resultSet.getInt("status"), resultSet.getInt("userId"), resultSet.getInt("rbID"), resultSet.getDouble("tara"), resultSet.getDouble("netto")));
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
                sqlQuery = "DELETE FROM ProductionBatch WHERE pbId= ?";
                PreparedStatement pstm = SQLConn.prepareStatement(sqlQuery);
                pstm.setInt(1, pbId);
                pstm.executeUpdate();
                SQLConn.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void createProductionBatch(int pbId, int receptId, int status, int userId, int rbId, double tara, double netto) {

        try {
            SQLConn = MySQLConnector.createConnection();
            if (SQLConn != null) {
                ptsm = SQLConn.prepareStatement("INSERT INTO ProductionBatch (pbId, receptId, status, userId, rbID, tara, netto)" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)");
                ResultSet = pstm.executeQuery();
                pstm.setInt(1, pbId);
                pstm.setInt(2, receptId);
                pstm.setInt(3, status);
                pstm.setInt(4, userId);
                pstm.setInt(5, rbId);
                pstm.setDouble(6, tara);
                pstm.setDouble(7, netto);

                pstm.executeUpdate();
                SQLConn.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}



