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
                        data.add(new ProductionBatch(resultSet.getInt("pbId"), resultSet.getInt("receptId"), resultSet.getInt("status")));
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
    }
