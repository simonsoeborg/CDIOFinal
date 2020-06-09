package API;
import DB.DBConnector;
import Data.DBRecept;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("receipts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReceptServlet {

    private DBConnector DBC = new DBConnector("mysql30.unoeuro.com","3306", "uglyrage_com_db_cdio", "uglyrage_com", "2d4f6r3t");

    @GET
    public List<User> listAllUsers() {
        return DBC.listAllUsers();
    }
}
