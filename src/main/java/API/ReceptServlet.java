package API;
import Controller.DBRecept;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("receipts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReceptServlet {

    DBRecept dbr = new DBRecept();

    @GET
    public ArrayList<DBRecept> getRecepts() {
        return dbr.getRecepts();
    }

}
