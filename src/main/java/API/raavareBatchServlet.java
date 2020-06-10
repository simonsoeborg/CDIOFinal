package API;
// Author: Kristoffer

import Data.DBRaavareBatch;
import Data.DTO.RaavareBatch;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("raavarebatch")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class raavareBatchServlet {

    DBRaavareBatch DBrb = new DBRaavareBatch();

    @GET
    public List<RaavareBatch> GetRaavareBatch() {
        return DBrb.listAllRaavareBatch();
    }

    @DELETE
    @Path("{rbId}")
    public void deleteRaavareBatch(@PathParam("rbId") int rbId) {
        DBrb.deleteRaavareBatch(rbId);
    }

}


