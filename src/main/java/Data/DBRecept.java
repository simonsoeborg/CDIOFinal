package Data;

import DB.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public DBRecept(int raavareID, double nonNetto, double tolerance){
        this.raavareId = raavareID;
        this.nonNetto = nonNetto;
        this.tolerance = tolerance;
    }

    public ArrayList<DBRecept> getRecepts() {
        return recepts;
    }

    public createRecept(int ReceptId, int ReceptNavn, DBRecept){
        try{
        SQLConn = SQLConnector.createConnection();
        pstm = SQLConn.prepareStatement();
        rs = pstm.executeQuery();
        } catch (){
    }

    }

    public updateRecept{

    }
}
