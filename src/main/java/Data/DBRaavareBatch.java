package Data;

import DB.DBConnector;

import java.sql.Connection;
import java.util.List;

public class DBRaavareBatch {

    private int rbId;
    private int raavareId;
    private double maengde;
    private Connection SQLConn;
    private String sqlQuery;
    private List<DBRaavareBatch> rbList;

    private DBConnector MySQLConnector = new DBConnector();

    public DBRaavareBatch(int rbId, int raavareId, double maengde) {
        this.rbId = rbId;
        this.raavareId = raavareId;
        this.maengde = maengde;
    }




}
