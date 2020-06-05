package Data;

import API.RaavarerServlet;
import DB.DBConnector;

import javax.ws.rs.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class DBRaavarer implements IDataHandlerDAO {

private int raavareId;
private String raavareNavn;
private String leveradør;
private Connection SQLConn;
private String sqlQuery;
private ArrayList<DBRaavarer> raavarer;

private DBConnector MySQLConnector = new DBConnector();

    public DBRaavarer(int raavareId, String raavareNavn, String leveradør) {
        this.raavareId = raavareId;
        this.raavareNavn = raavareNavn;
        this.leveradør = leveradør;
    }

    public ArrayList<DBRaavarer> listAllRaavarer() {
        return raavarer;
    }

}
