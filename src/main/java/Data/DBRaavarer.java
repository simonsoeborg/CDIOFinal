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
private String leveradoer;
private Connection SQLConn;
private String sqlQuery;
private ArrayList<DBRaavarer> raavarer;

private DBConnector MySQLConnector = new DBConnector();

public DBRaavarer() {
}

public ArrayList<DBRaavarer> listAllRaavarer() {
        return raavarer;
    }

}
