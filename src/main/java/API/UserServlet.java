package API;

import Data.DBRecept;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserServlet {

    private DBRecept DBR = new DBRecept();

}
