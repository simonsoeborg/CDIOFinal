package API;

import Data.DBRaavareBatch;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("raavarebatch")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class raavareBatchServlet {
    DBRaavareBatch dbrb = new DBRaavareBatch();

}

