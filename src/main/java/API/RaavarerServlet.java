package API;

import DB.DBConnector;
import Data.DBRaavarer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("raavarer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RaavarerServlet {

    DBRaavarer raavarer = new DBRaavarer();

    @GET
    public List<DBRaavarer> listAllRaavarer() {
        return raavarer.listAllRaavarer();
    }


}
