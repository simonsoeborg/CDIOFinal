
import Data.DTO.DBConnector;
import Data.DTO.ProductionBatch;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class DBProductionBatch {
    DBConnector dbc = new DBConnector();
    private String sqlQuery;
    private Connection SQLConn = dbc.createConnection();
    private List<ProductionBatch> productionBatches;

    private DBConnector MySQLConnector = new DBConnector();


